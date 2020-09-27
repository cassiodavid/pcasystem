package cd.pcas.pcas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cd.pcas.pcas.error.ResourceNotFoundException;
import cd.pcas.pcas.model.ContratosRecursos;
import cd.pcas.pcas.model.HospitalEntity;
import cd.pcas.pcas.repository.ContratoRepositoty;
import cd.pcas.pcas.repository.HospitalRepository;
import cd.pcas.pcas.repository.RecursosRepository;

import cd.pcas.pcas.model.HospitalRecursos;

@Service
public class IntercambioRecursos {

    @Autowired
    HospitalRepository _hospitalRepository;

    @Autowired
    RecursosRepository _recursosRepository;

    @Autowired
    ContratoRepositoty _contratoRepositoty;

    public List<HospitalRecursos> getAllRecursos() {
        List<HospitalRecursos> HospitalRecursos = _recursosRepository.findAll();
        if (HospitalRecursos.size() > 0) {
            return HospitalRecursos;
        } else {
            return new ArrayList<HospitalRecursos>();
        }
    }

    public HospitalRecursos getRecursosById(Long id) throws ResourceNotFoundException {
        Optional<HospitalRecursos> hospitalRecursos = _recursosRepository.findById(id);
        HospitalEntity hospitalEntity = new HospitalEntity();
        HospitalRecursos hospitalRecursos2 = new HospitalRecursos();
        if (hospitalRecursos.isPresent()) {
            hospitalRecursos2 = hospitalRecursos.get();
            hospitalEntity.setHospitalRecursos(hospitalRecursos2);
            hospitalRecursos2.setHospitalEntity(hospitalEntity);
            return hospitalRecursos2;
        } else {
            throw new ResourceNotFoundException("Erro ao Encontrar Recursos referente ao ID solicitado " + id);
        }
    }

    public HospitalEntity SolicitarRecursos(Map<String, String> map, Long id) throws ResourceNotFoundException {

        boolean medic = map.containsKey("medico");
        if (medic == false) {
            map.put("medico", "0");
        }
        ;
        boolean enfer = map.containsKey("enfermeiro");
        if (enfer == false) {
            map.put("enfermeiro", "0");
        }
        ;
        boolean respir = map.containsKey("respirador");
        if (respir == false) {
            map.put("respirador", "0");
        }
        ;
        boolean tomogra = map.containsKey("tomografo");
        if (tomogra == false) {
            map.put("tomografo", "0");
        }
        ;
        boolean ambulan = map.containsKey("ambulancia");
        if (ambulan == false) {
            map.put("ambulancia", "0");
        }
        ;

        long medico = Long.parseLong(map.get("medico"));
        long enfermeiro = Long.parseLong(map.get("enfermeiro"));
        long respirador = Long.parseLong(map.get("respirador"));
        long tomografo = Long.parseLong(map.get("tomografo"));
        long ambulancia = Long.parseLong(map.get("ambulancia"));
        long parahospital = Long.parseLong(map.get("parahospital"));
        Optional<HospitalEntity> hospitalRequerente = _hospitalRepository.findById(id);
        Long hospitalRecursos = hospitalRequerente.get().getHospitalRecursos().getId();
        Optional<HospitalRecursos> HospitalRecursos2 = _recursosRepository.findById(hospitalRecursos);
        HospitalRecursos recursosAtualizado = HospitalRecursos2.get();
        if (HospitalRecursos2.isPresent()) {
            recursosAtualizado.setAmbulancia(HospitalRecursos2.get().getAmbulancia() - ambulancia);
            recursosAtualizado.setEnfermeiro(HospitalRecursos2.get().getEnfermeiro() - enfermeiro);
            recursosAtualizado.setMedico(HospitalRecursos2.get().getMedico() - medico);
            recursosAtualizado.setTomografo(HospitalRecursos2.get().getTomografo() - tomografo);
            recursosAtualizado.setRespirador(HospitalRecursos2.get().getRespirador() - respirador);
        }
        _recursosRepository.save(recursosAtualizado);
        Optional<HospitalEntity> hospitalAtualizado = _hospitalRepository.findById(parahospital);
        Long hospitalRecursosAtualizado = hospitalAtualizado.get().getHospitalRecursos().getId();
        Optional<HospitalRecursos> HospitalRecursosAtualizados2 = _recursosRepository
                .findById(hospitalRecursosAtualizado);
        HospitalRecursos recursosAtualizadoRequerente = HospitalRecursosAtualizados2.get();
        if (HospitalRecursosAtualizados2.isPresent()) {
            recursosAtualizadoRequerente.setAmbulancia(HospitalRecursosAtualizados2.get().getAmbulancia() + ambulancia);
            recursosAtualizadoRequerente.setEnfermeiro(HospitalRecursosAtualizados2.get().getEnfermeiro() + enfermeiro);
            recursosAtualizadoRequerente.setMedico(HospitalRecursosAtualizados2.get().getMedico() + medico);
            recursosAtualizadoRequerente.setTomografo(HospitalRecursosAtualizados2.get().getTomografo() + tomografo);
            recursosAtualizadoRequerente.setRespirador(HospitalRecursosAtualizados2.get().getRespirador() + respirador);
        }
        _recursosRepository.save(recursosAtualizadoRequerente);
        ContratosRecursos contratosRecursos = new ContratosRecursos();
        contratosRecursos.setHospitalSolicitado(id);
        contratosRecursos.setSolicitadoMedico(medico);
        contratosRecursos.setSolicitadoEnfermeiro(enfermeiro);
        contratosRecursos.setSolicitadoRespirador(respirador);
        contratosRecursos.setSolicitadoTomografo(tomografo);
        contratosRecursos.setSolicitadoAmbulancia(ambulancia);
        contratosRecursos.setHospitalAtribuido(parahospital);
        contratosRecursos.setAtribuidoMedico(medico);
        contratosRecursos.setAtribuidoEnfermeiro(enfermeiro);
        contratosRecursos.setAtribuidoRespirador(respirador);
        contratosRecursos.setAtribuidoTomografo(tomografo);
        contratosRecursos.setAtribuidoAmbulancia(ambulancia);
        contratosRecursos.setValoreMedico(medico * 3);
        contratosRecursos.setValoreEnfermeiro(enfermeiro * 3);
        contratosRecursos.setValoreRespirador(respirador * 5);
        contratosRecursos.setValoreTomografo(tomografo * 12);
        contratosRecursos.setValoreAmbulancia(ambulancia * 10);
        _contratoRepositoty.save(contratosRecursos);

        return hospitalRequerente.get();

    }

    public Boolean getOcupacao(Long Hospital01, Long Hospital02) throws ResourceNotFoundException {
        Long hospital01;
        Long hospital02;
        Optional<HospitalEntity> hospitalEntity = _hospitalRepository.findById(Hospital01);
        if (hospitalEntity.isPresent()) {
            hospital01 = hospitalEntity.get().getOcupacao();
        } else {
            throw new ResourceNotFoundException("Erro ao Encontrar Hospital " + Hospital01);
        }
        Optional<HospitalEntity> hospitalEntity2 = _hospitalRepository.findById(Hospital02);
        if (hospitalEntity2.isPresent()) {
            hospital02 = hospitalEntity2.get().getOcupacao();
        } else {
            throw new ResourceNotFoundException("Erro ao Encontrar Hospital " + Hospital02);
        }
        if ((hospital01 > 90) | (hospital02 > 90)) {
            return true;
        } else {
            return false;
        }
    }
}