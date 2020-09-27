package cd.pcas.pcas.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cd.pcas.pcas.error.ResourceNotFoundException;
import cd.pcas.pcas.model.ContratosRecursos;
import cd.pcas.pcas.model.HospitalEntity;
import cd.pcas.pcas.model.HospitalRecursos;
import cd.pcas.pcas.repository.ContratoRepositoty;
import cd.pcas.pcas.repository.HospitalRepository;
import cd.pcas.pcas.repository.RecursosRepository;
import cd.pcas.pcas.util.DateComparator;
import cd.pcas.pcas.util.DateComparatorMenor;

@Service
public class RelatoriosService {

    @Autowired
    HospitalRepository _hospitalRepository;

    @Autowired
    ContratoRepositoty _contratoRepositoty;

    @Autowired
    RecursosRepository _recursosRepository;

    public List<ContratosRecursos> getAllContract() throws ResourceNotFoundException {
        List<ContratosRecursos> contratos = _contratoRepositoty.findAll();
        return contratos;
    }

    public ContratosRecursos getContractById(Long id) throws ResourceNotFoundException {
        Optional<ContratosRecursos> ContratctEntity = _contratoRepositoty.findById(id);
        if (ContratctEntity.isPresent()) {
            return ContratctEntity.get();
        } else {
            throw new ResourceNotFoundException("Erro ao carregar Contrato " + id);
        }
    }

    public List<HospitalEntity> porcentagemOcupacaoMaior() throws ResourceNotFoundException{
        List<HospitalEntity> list = _hospitalRepository.findOcupacaoMaiorQue90();
        return list;

    }

    public List<HospitalEntity> porcentagemOcupacaoMenor() throws ResourceNotFoundException {
        List<HospitalEntity> list = _hospitalRepository.findOcupacaoMenorQue90();
        return list;

    }

    public List<HospitalEntity> superLotacaoMaior() throws ResourceNotFoundException {
        List<HospitalEntity> list = _hospitalRepository.findOcupacaoMaiorQue90();
        Collections.sort(list, new DateComparator());
        return list;

    }

    public List<HospitalEntity> superLotacaoMenor() throws ResourceNotFoundException {
        List<HospitalEntity> list = _hospitalRepository.findOcupacaoMaiorQue90();
        Collections.sort(list, new DateComparatorMenor());
        return list;
    }

    public HospitalRecursos mediaRecursosHospitais() throws ResourceNotFoundException {
        List<HospitalRecursos> hospitalRecursos = _recursosRepository.findAll();
        Long soma_enfermeiro = 0L;
        Long soma_medico = 0L;
        Long soma_respirador = 0L;
        Long soma_tomografo = 0L;
        Long soma_embulancia = 0L;
        HospitalRecursos recursosMedia = new HospitalRecursos();
        for (HospitalRecursos valores : hospitalRecursos) {
            soma_enfermeiro = soma_enfermeiro + valores.getEnfermeiro();
            soma_embulancia = soma_embulancia + valores.getAmbulancia();
            soma_medico = soma_medico + valores.getMedico();
            soma_respirador = soma_respirador + valores.getRespirador();
            soma_tomografo = soma_tomografo + valores.getTomografo();
        }
        if (hospitalRecursos.size() <= 0) {
            throw new ResourceNotFoundException("Erro ao calcular a media dos Recursos");
        }
        recursosMedia.setEnfermeiro(soma_enfermeiro / hospitalRecursos.size());
        recursosMedia.setAmbulancia(soma_embulancia / hospitalRecursos.size());
        recursosMedia.setMedico(soma_medico / hospitalRecursos.size());
        recursosMedia.setRespirador(soma_respirador / hospitalRecursos.size());
        recursosMedia.setTomografo(soma_tomografo / hospitalRecursos.size());
        return recursosMedia;
    }
}
