package cd.pcas.pcas.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cd.pcas.pcas.model.HospitalEntity;

@Repository
public interface HospitalRepository extends JpaRepository<HospitalEntity, Long>{

    @Query("SELECT o FROM tb_hospital o WHERE o.ocupacao > 90 ")
    List<HospitalEntity> findOcupacaoMaiorQue90();

    @Query("SELECT o FROM tb_hospital o WHERE o.ocupacao < 90 ")
    List<HospitalEntity> findOcupacaoMenorQue90();

    List<HospitalEntity> findByDataCriacao(LocalDateTime dataCriacao);

    List<HospitalEntity> findAllByOrderByIdDesc();

    List<HospitalEntity> findAllByOrderByIdAsc();

    
}
