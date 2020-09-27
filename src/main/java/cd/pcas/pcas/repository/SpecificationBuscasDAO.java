package cd.pcas.pcas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import cd.pcas.pcas.model.HospitalEntity;

@Repository
public interface SpecificationBuscasDAO extends JpaRepository<HospitalEntity , Long>, JpaSpecificationExecutor<HospitalEntity>  {
    
}
