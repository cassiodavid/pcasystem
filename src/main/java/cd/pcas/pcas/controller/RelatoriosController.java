package cd.pcas.pcas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cd.pcas.pcas.error.ResourceNotFoundException;
import cd.pcas.pcas.model.ContratosRecursos;
import cd.pcas.pcas.model.HospitalEntity;
import cd.pcas.pcas.model.HospitalRecursos;
import cd.pcas.pcas.service.RelatoriosService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/relatorio")
public class RelatoriosController {

    @Autowired
    RelatoriosService _relatoriosService;

    @GetMapping
    @ApiOperation(value = "Retorna todos os historicos de negociação ")
    public ResponseEntity<List<ContratosRecursos>> getAllContract() throws ResourceNotFoundException {
        List<ContratosRecursos> contratosRecursosLista = _relatoriosService.getAllContract();
        return new ResponseEntity<List<ContratosRecursos>>(contratosRecursosLista, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna um historico de negociação pelo ID.")
    public ResponseEntity<ContratosRecursos> getHospitalEntityById(@PathVariable("id") Long id) {
        ContratosRecursos contratosRecursos = _relatoriosService.getContractById(id);
        return new ResponseEntity<ContratosRecursos>(contratosRecursos, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/maiorocupacao")
    @ApiOperation(value = "Retornar uma lista de hospitais com o numero de ocupação maior que 90% ")
    public ResponseEntity<List<HospitalEntity>> porcentagemOcupacaoMaior() throws ResourceNotFoundException {
        List<HospitalEntity> ocupacaoMaiorList = _relatoriosService.porcentagemOcupacaoMaior();
        return new ResponseEntity<List<HospitalEntity>>(ocupacaoMaiorList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/menorocupacao")
    @ApiOperation(value = "Retornar uma lista de hospitais com o numero de ocupação menor que 90% ")
    public ResponseEntity<List<HospitalEntity>> porcentagemOcupacaoMenor() throws ResourceNotFoundException {
        List<HospitalEntity> ocupacaoMenorList = _relatoriosService.porcentagemOcupacaoMenor();
        return new ResponseEntity<List<HospitalEntity>>(ocupacaoMenorList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/superlotacaomaior")
    @ApiOperation(value = "Retornar uma lista de hospitais com o numero de ocupação maior que 90% a mais tempo.")
    public ResponseEntity<List<HospitalEntity>> superLotacaoMaior() throws ResourceNotFoundException {
        List<HospitalEntity> superLotacaoMaiorList = _relatoriosService.superLotacaoMaior();
        return new ResponseEntity<List<HospitalEntity>>(superLotacaoMaiorList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/superlotacaomenor")
    @ApiOperation(value = "Retornar uma lista de hospitais com o numero de ocupação maior que 90% a menos tempo.")
    public ResponseEntity<List<HospitalEntity>> superLotacaoMenor() throws ResourceNotFoundException {
        List<HospitalEntity> superLotacaoMenorList = _relatoriosService.superLotacaoMenor();
        return new ResponseEntity<List<HospitalEntity>>(superLotacaoMenorList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/mediarecursos")
    @ApiOperation(value = "Retornar a Media dos recursos dos Hospitais")
    public ResponseEntity<HospitalRecursos> mediaRecursos() throws ResourceNotFoundException {
        HospitalRecursos hospitalMediaRecursos = _relatoriosService.mediaRecursosHospitais();
        return new ResponseEntity<HospitalRecursos>(hospitalMediaRecursos, new HttpHeaders(), HttpStatus.OK);
    }

}
