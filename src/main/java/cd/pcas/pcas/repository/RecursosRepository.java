package cd.pcas.pcas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cd.pcas.pcas.model.HospitalRecursos;

@Repository
public interface RecursosRepository extends JpaRepository<HospitalRecursos , Long> {
    
}
