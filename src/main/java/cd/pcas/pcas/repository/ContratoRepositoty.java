package cd.pcas.pcas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cd.pcas.pcas.model.ContratosRecursos;

public interface ContratoRepositoty extends JpaRepository<ContratosRecursos , Long> {
    
}
