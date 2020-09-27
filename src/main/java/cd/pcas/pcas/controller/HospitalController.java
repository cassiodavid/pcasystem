
package cd.pcas.pcas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cd.pcas.pcas.error.ResourceNotFoundException;
import cd.pcas.pcas.model.HospitalEntity;
import cd.pcas.pcas.service.HospitalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/hospital")
@Api(value = "API REST Hospitais")
@CrossOrigin(origins = "*")
public class HospitalController {

   @Autowired
   HospitalService _hospitalService;

   @GetMapping
   @ApiOperation(value = "Retorna uma Lista de Hospital")
   public ResponseEntity<List<HospitalEntity>> getAllHospital() {
      List<HospitalEntity> list = _hospitalService.getAllHospital();
      return new ResponseEntity<List<HospitalEntity>>(list, new HttpHeaders(), HttpStatus.OK);
   }

   @GetMapping("/{id}")
   @ApiOperation(value = "Retorna uma Lista de Hospital")
   public ResponseEntity<HospitalEntity> getHospitalEntityById(@PathVariable("id") Long id) {
      HospitalEntity hospitalEntity = _hospitalService.getHospitalById(id);
      return new ResponseEntity<HospitalEntity>(hospitalEntity, new HttpHeaders(), HttpStatus.OK);
   }

   @PostMapping
   @ApiOperation(value = "Cria um novo hospital passando as informaçoes via JSON no endpoint /hospital ")
   public ResponseEntity<HospitalEntity> createHospitalEntity(@RequestBody HospitalEntity hospitalEntity)
         throws ResourceNotFoundException {
      HospitalEntity New_hospitalEntity = _hospitalService.createrHospitalEntity(hospitalEntity);
      return new ResponseEntity<HospitalEntity>(New_hospitalEntity, new HttpHeaders(), HttpStatus.OK);
   }

   @PutMapping("{id}")
   @ApiOperation(value = "Atualiza as porcentagens de Ocupação dos Hospitais, Retorna Tudo mas so atualiza a Ocupação.")
   public ResponseEntity<HospitalEntity> updatePercentageOcupationHospitalEntity(
         @RequestBody HospitalEntity hospitalEntity, @PathVariable Long id) throws ResourceNotFoundException {
      HospitalEntity New_hospitalEntity = _hospitalService.updatePercentageOcupationHospitalEntity(hospitalEntity, id);
      return new ResponseEntity<HospitalEntity>(New_hospitalEntity, new HttpHeaders(), HttpStatus.OK);
   }

   @DeleteMapping("/{id}")
   @ApiOperation(value = "Deleta um Hospital OBS: Não implementado")
   public HttpStatus deleteHospitalEntityById(@PathVariable("id") Long id) throws Exception {
      _hospitalService.deleteHospitalEntity(id);
      return HttpStatus.FORBIDDEN;
   }

}
