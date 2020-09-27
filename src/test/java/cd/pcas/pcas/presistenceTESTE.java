package cd.pcas.pcas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cd.pcas.pcas.model.HospitalEntity;
import cd.pcas.pcas.model.HospitalRecursos;
import cd.pcas.pcas.repository.HospitalRepository;
import cd.pcas.pcas.repository.RecursosRepository;
import cd.pcas.pcas.util.DateComparator;

@SpringBootTest
public class presistenceTESTE {

    @Autowired
    HospitalRepository hRepository;

    @Autowired
    RecursosRepository Rrepository;

    @Test
    public void persistenceTeste() {

        HospitalEntity hospitalEntity = new HospitalEntity();
        hospitalEntity.setId(666L);
        hospitalEntity.setNome("Outroooooooooo outrooooo");
        hospitalEntity.setCnpj(13131111232545236L);
        hospitalEntity.setEndereco("Deletado aaaaaaaaaasdasdsadsaaaaaaaa");
        hospitalEntity.setLocalizacao("Deletada aaaaaaaaaaaaaaaaaaaaa");
        hospitalEntity.setOcupacao(5L);
        HospitalRecursos hospitalRecursos = new HospitalRecursos();
        hospitalRecursos.setId(100110L);
        hospitalRecursos.setMedico(611666L);
        hospitalRecursos.setTomografo(9911169L);
        hospitalRecursos.setRespirador(9111699L);
        hospitalRecursos.setEnfermeiro(9611199L);
        hospitalRecursos.setAmbulancia(9611199L);
        hospitalEntity.setHospitalRecursos(hospitalRecursos);
        hospitalRecursos.setHospitalEntity(hospitalEntity);
        Rrepository.save(hospitalRecursos);
        hRepository.save(hospitalEntity);

    }

    @Test
    public void EditarHospitalTeste() {
        Optional<HospitalEntity> hospitalEntity = hRepository.findById(273L);
        // HospitalEntity new_HospitalEntity = new HospitalEntity();
        if (hospitalEntity.isPresent()) {
            // new_HospitalEntity = hospitalEntity.get();
        }
        // new_HospitalEntity.setNome("ABCSER");
        // hRepository.save(new_HospitalEntity);
    }

    @Test
    public void EditarRecursosTeste() {
        // Optional<HospitalEntity> hospitalEntity = hRepository.findById(273L);
        // HospitalEntity new_HospitalEntity = new HospitalEntity();
        // if(hospitalEntity.isPresent()){
        // new_HospitalEntity = hospitalEntity.get();
    }
    // HospitalRecursos hospitalRecursos = new_HospitalEntity.getHospitalRecursos();
    // hospitalRecursos.setAmbulancia(69L);
    // hRepository.save(new_HospitalEntity);

    // }

    @Test
    public void getItens() {

    }

    @Test
    public void persistenceDelete() {

        Optional<HospitalEntity> hospitalEntity = hRepository.findById(271L);
        // HospitalEntity new_HospitalEntity = new HospitalEntity();
        if (hospitalEntity.isPresent()) {
            // new_HospitalEntity = hospitalEntity.get();
        }
        System.out.println("deleted");

    }

    @Test
    public void finByOcupacao() {
        // Verificar a Diferença, Asc Desc, Nao funciona, sempre o mesmo resultado! :/
        // List<HospitalEntity> hospitalEntity = hRepository.findAllByOrderByIdAsc();
        // System.out.println(hospitalEntity);

        // API do spring ajuda na criação de JPQL
        List<HospitalEntity> hospitalEntity = hRepository.findOcupacaoMaiorQue90();
        System.out.println(hospitalEntity);

        List<HospitalEntity> contacts = new ArrayList<>();

        for (HospitalEntity hospitalEntity2 : hRepository.findAll()) {
            contacts.add(hospitalEntity2);
        }

        // hospitalEntity = hRepository.findOcupacaoMenorQue90();
        // System.out.println(hospitalEntity);

    }

    @Test
    public void dataSortMenor() {
        List<HospitalEntity> hospitalEntity = hRepository.findOcupacaoMenorQue90();
        System.out.println(hospitalEntity);
        Collections.sort(hospitalEntity, new DateComparator());
        System.out.println();
    }

    @Test
    public void dataSortMaior() {
        List<HospitalEntity> hospitalEntity = hRepository.findOcupacaoMaiorQue90();
        System.out.println(hospitalEntity);
        Collections.sort(hospitalEntity, new DateComparator());
        System.out.println();
    }

}
