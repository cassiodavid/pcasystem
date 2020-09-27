package cd.pcas.pcas.controller;

import cd.pcas.pcas.error.ResourceNotFoundException;
import cd.pcas.pcas.error.MensagemErroRecursos;
import cd.pcas.pcas.model.HospitalEntity;
import cd.pcas.pcas.model.HospitalRecursos;
import cd.pcas.pcas.repository.HospitalRepository;
import cd.pcas.pcas.repository.RecursosRepository;
import cd.pcas.pcas.service.HospitalService;
import cd.pcas.pcas.service.IntercambioRecursos;
import cd.pcas.pcas.util.Utilities;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recursos")
public class RecursosController {

    @Autowired
    IntercambioRecursos _intercambioRecursos;

    @Autowired
    HospitalRepository _hospitalRepositori;

    @Autowired
    RecursosRepository _recursos;

    @Autowired
    HospitalService _hospitalService;

    @GetMapping
    @ApiOperation(value = "Retorna uma lista de recursos")
    public ResponseEntity<List<HospitalRecursos>> getAllRecursos() {
        List<HospitalRecursos> list = _intercambioRecursos.getAllRecursos();
        return new ResponseEntity<List<HospitalRecursos>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna recursos pelo ID.")
    public ResponseEntity<HospitalRecursos> getRecursosEntityById(@PathVariable("id") Long id) throws Exception {
        HospitalRecursos hospitalRecursos = _intercambioRecursos.getRecursosById(id);
        return new ResponseEntity<HospitalRecursos>(hospitalRecursos, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/solicitar")
    @ApiOperation(value = "Retorna uma lista com as informaçoes dos hospitais para uma analise de solicitação.")
    public ResponseEntity<List<HospitalEntity>> getAllHospital() {
        List<HospitalEntity> list = _hospitalService.getAllHospital();
        return new ResponseEntity<List<HospitalEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/solicitar/{id}")
    @ApiOperation(value = "Retorna informaçoes do hospital para uma analise de envio. ao Mudar pra Post, enviar parametros para a troca de Recursos!")
    public ResponseEntity<HospitalEntity> getHospitalEntityById(@RequestParam Map<String, String> map,
            @PathVariable("id") Long id) throws Exception {
        HospitalEntity hospitalEntity = _hospitalService.getHospitalById(id);
        return new ResponseEntity<HospitalEntity>(hospitalEntity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/solicitar/{id}")
    @ApiOperation(value = "Solicita Recursos passando um MAP como parametro. obs: 'parahospital' é obrigatorio. Verificarar pontos conforme Tabela. ")
    public ResponseEntity<HospitalEntity> getRecursosHospitaisEntityById(@RequestParam Map<String, String> map,
            @PathVariable("id") Long id) throws ResourceNotFoundException {
        MensagemErroRecursos msg = new MensagemErroRecursos();
        Utilities utilities = new Utilities();
        boolean verificarPontos = true;
        Map<String, String> map_resposta = utilities.retornosMap(map);
        Long hospital2 = Long.parseLong(map_resposta.get("parahospital"));
        Boolean verificarOcupacoes = _intercambioRecursos.getOcupacao(id, hospital2);
        if (verificarOcupacoes == false) {
            verificarPontos = utilities.verificarPontosSeIgual(map_resposta);
            if (verificarPontos == true) {
                HospitalEntity hospitalEntity = _intercambioRecursos.SolicitarRecursos(map_resposta, id);
                return new ResponseEntity<HospitalEntity>(hospitalEntity, new HttpHeaders(), HttpStatus.OK);
            } else {
               
                throw new ResourceNotFoundException("Erro ao Solicitar Recursos dos Hospitais! " + msg.getMensagemString());
            }
        } else {
            if (verificarPontos == true) {
                HospitalEntity hospitalEntity = _intercambioRecursos.SolicitarRecursos(map_resposta, id);
                return new ResponseEntity<HospitalEntity>(hospitalEntity, new HttpHeaders(), HttpStatus.OK);
            } else {
                throw new ResourceNotFoundException("Erro ao Solicitar Recursos dos Hospitais " + msg.getMensagemString());
            }
        }
    }
}
