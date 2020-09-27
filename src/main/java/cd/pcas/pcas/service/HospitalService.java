package cd.pcas.pcas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cd.pcas.pcas.error.ResourceNotFoundException;
import cd.pcas.pcas.model.HospitalEntity;
import cd.pcas.pcas.model.HospitalRecursos;
import cd.pcas.pcas.repository.HospitalRepository;
import cd.pcas.pcas.repository.RecursosRepository;

@Service
public class HospitalService {

    @Autowired
    HospitalRepository _repository;

    @Autowired
    RecursosRepository _recursos;

    public List<HospitalEntity> getAllHospital() {
        List<HospitalEntity> hospitalEntity = _repository.findAll();
        if (hospitalEntity.size() > 0) {
            return hospitalEntity;
        } else {
            return new ArrayList<HospitalEntity>();
        }
    }

    public HospitalEntity getHospitalById(Long id) throws ResourceNotFoundException {
        Optional<HospitalEntity> hospitalEntity = _repository.findById(id);
        if (hospitalEntity.isPresent()) {
            return hospitalEntity.get();
        } else {
            throw new ResourceNotFoundException("Erro ao Encontrar Hospital " + id);
        }
    }

    public HospitalEntity createrHospitalEntity(HospitalEntity entity) throws ResourceNotFoundException {
        HospitalEntity hospitalEntity = new HospitalEntity();
        HospitalRecursos hospitalRecursos = new HospitalRecursos();
        HospitalRecursos hospitalRecursos2 = entity.getHospitalRecursos();
        if (entity != null) {
            hospitalEntity.setNome(entity.getNome());
            hospitalEntity.setCnpj(entity.getCnpj());
            hospitalEntity.setEndereco(entity.getEndereco());
            hospitalEntity.setLocalizacao(entity.getLocalizacao());
            hospitalEntity.setOcupacao(entity.getOcupacao());
            hospitalRecursos.setAmbulancia(hospitalRecursos2.getAmbulancia());
            hospitalRecursos.setEnfermeiro(hospitalRecursos2.getEnfermeiro());
            hospitalRecursos.setMedico(hospitalRecursos2.getMedico());
            hospitalRecursos.setRespirador(hospitalRecursos2.getRespirador());
            hospitalRecursos.setTomografo(hospitalRecursos2.getTomografo());
        }
        hospitalEntity.setHospitalRecursos(hospitalRecursos);
        hospitalRecursos.setHospitalEntity(hospitalEntity);
        if (hospitalEntity.getOcupacao() > 100 | hospitalEntity.getOcupacao() < 0) {
            throw new ResourceNotFoundException("Ocupação maior que 100 Pocento OU menor que ZERO");
        }
        _repository.save(hospitalEntity);
        _recursos.save(hospitalRecursos);
        return entity;
    }

    public HospitalEntity updatePercentageOcupationHospitalEntity(HospitalEntity hospitalEntity, Long id)
            throws ResourceNotFoundException {
        HospitalEntity NewHospitalEntity = new HospitalEntity();
        Optional<HospitalEntity> OldHospitalEntity = _repository.findById(id);
        if (OldHospitalEntity.isPresent()) {
            NewHospitalEntity = OldHospitalEntity.get();
        } else {
            throw new ResourceNotFoundException("Erro ao atualizar a ocupacao do hospital " + id);
        }
        NewHospitalEntity.setOcupacao(hospitalEntity.getOcupacao());
        NewHospitalEntity.setDataCriacao(hospitalEntity.getDataCriacao());
        if (NewHospitalEntity.getOcupacao() > 100 | NewHospitalEntity.getOcupacao() < 0) {
            throw new ResourceNotFoundException("Ocupação maior que 100 Pocento OU menor que ZERO");
        }
        _repository.save(NewHospitalEntity);
        return NewHospitalEntity;
    }

    public HospitalEntity updateHospitalEntity(HospitalEntity entity) throws Exception {
        Optional<HospitalEntity> hospitalEntity = _repository.findById(entity.getId());
        if (hospitalEntity.isPresent()) {
            HospitalEntity new_HospitalEntity = hospitalEntity.get();
            new_HospitalEntity.setNome(entity.getNome());
            new_HospitalEntity.setCnpj(entity.getCnpj());
            new_HospitalEntity.setEndereco(entity.getEndereco());
            new_HospitalEntity.setLocalizacao(entity.getLocalizacao());
            new_HospitalEntity.setOcupacao(entity.getOcupacao());
            // new_HospitalEntity.setHospitalRecursos(entity.getHospitalRecursos());
            new_HospitalEntity = _repository.save(new_HospitalEntity);
            return new_HospitalEntity;
        } else {
            entity = _repository.save(entity);
            return entity;
        }
    }

    public void deleteHospitalEntity(Long id) throws ResourceNotFoundException {
        Optional<HospitalEntity> hospitalEntity = _repository.findById(id);
        if (hospitalEntity.isPresent()) {
            _repository.deleteById(id);
        } else {
            new ResourceNotFoundException("Erro ao Deletar Hospital " + id);
        }
    }
}
