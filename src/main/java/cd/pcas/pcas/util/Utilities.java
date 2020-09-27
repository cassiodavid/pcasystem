package cd.pcas.pcas.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import cd.pcas.pcas.error.ResourceNotFoundException;
import cd.pcas.pcas.model.HospitalEntity;

public class Utilities {

    private Long ocupacao;

    public Long getBusca() {
        return ocupacao;
    }

    public void setBusca(Long ocupacao) {
        this.ocupacao = ocupacao;
    }

    public Specification<HospitalEntity> toSpec() {
        return (root, query, builder) -> {
            List<Predicate> predicados = new ArrayList<>();
            if (ocupacao != 0) {
                Path<String> ocupacao = root.<String>get("ocupacao");
                Predicate predicadoNome = builder.like(ocupacao, "%" + ocupacao + "%");
                predicados.add(predicadoNome);
            }
            return builder.and(predicados.toArray(new Predicate[0]));
        };
    }

    public Map<String, String> retornosMap(Map<String, String> map) throws ResourceNotFoundException {
        Map<String, String> map_resposta = new HashMap<>();
        boolean medic = map.containsKey("medico");
        if (medic == true) {
            map_resposta.put("medico", map.get("medico"));
        }
        ;
        boolean enfer = map.containsKey("enfermeiro");
        if (enfer == true) {
            map_resposta.put("enfermeiro", map.get("enfermeiro"));
        }
        ;
        boolean respir = map.containsKey("respirador");
        if (respir == true) {
            map_resposta.put("respirador", map.get("respirador"));
        }
        ;
        boolean tomogra = map.containsKey("tomografo");
        if (tomogra == true) {
            map_resposta.put("tomografo", map.get("tomografo"));
        }
        ;
        boolean ambulan = map.containsKey("ambulancia");
        if (ambulan == true) {
            map_resposta.put("ambulancia", map.get("ambulancia"));
        }
        ;
        boolean parahospitalVKey = map.containsKey("parahospital");
        if (parahospitalVKey == true) {
            map_resposta.put("parahospital", map.get("parahospital"));
        }
        ;
        boolean enviar_medico = map.containsKey("enviar_medico");
        if (enviar_medico == true) {
            map_resposta.put("enviar_medico", map.get("enviar_medico"));
        }
        ;

        boolean enviar_enfermeiro = map.containsKey("enviar_enfermeiro");
        if (enviar_enfermeiro == true) {
            map_resposta.put("enviar_enfermeiro", map.get("enviar_enfermeiro"));
        }
        ;

        boolean enviar_respirador = map.containsKey("enviar_respirador");
        if (enviar_respirador == true) {
            map_resposta.put("enviar_respirador", map.get("enviar_respirador"));
        }
        ;

        boolean enviar_tomografo = map.containsKey("enviar_tomografo");
        if (enviar_tomografo == true) {
            map_resposta.put("enviar_tomografo", map.get("enviar_tomografo"));
        }
        ;

        boolean enviar_ambulancia = map.containsKey("enviar_ambulancia");
        if (enviar_ambulancia == true) {
            map_resposta.put("enviar_ambulancia", map.get("enviar_ambulancia"));
        }
        ;
        boolean enviar_parahospital = map.containsKey("enviar_parahospital");
        if (enviar_parahospital == true) {
            map_resposta.put("enviar_parahospital", map.get("enviar_parahospital"));
        }
        ;
        return map_resposta;
    }

    public boolean verificarPontosSeIgual(Map<String, String> map) throws ResourceNotFoundException {

        Long pontos = 0L;

        boolean medic = map.containsKey("medico");
        if (medic == true) {
            Long medico = Long.parseLong(map.get("medico"));
            pontos = pontos + (medico * 3);
        }
        ;
        boolean enfer = map.containsKey("enfermeiro");
        if (enfer == true) {
            Long enfermeiro = Long.parseLong(map.get("enfermeiro"));
            pontos = pontos + (enfermeiro * 3);
        }
        ;
        boolean respir = map.containsKey("respirador");
        if (respir == true) {
            Long respirador = Long.parseLong(map.get("respirador"));
            pontos = pontos + (respirador * 5);
        }
        ;
        boolean tomogra = map.containsKey("tomografo");
        if (tomogra == true) {
            Long tomografo = Long.parseLong(map.get("tomografo"));
            pontos = pontos + (tomografo * 12);
        }
        ;
        boolean ambulan = map.containsKey("ambulancia");
        if (ambulan == true) {
            Long ambulancia = Long.parseLong(map.get("ambulancia"));
            pontos = pontos + (ambulancia * 10);
        }
        ;

        Long pontosEnviados = 0L;

        boolean env_medico = map.containsKey("enviar_medico");
        if (env_medico == true) {
            Long enviar_medico = Long.parseLong(map.get("enviar_medico"));
            pontosEnviados = pontosEnviados + (enviar_medico * 3);
        }
        ;
        boolean env_enfer = map.containsKey("enviar_enfermeiro");
        if (env_enfer == true) {
            Long enviar_enfermeiro = Long.parseLong(map.get("enviar_enfermeiro"));
            pontosEnviados = pontosEnviados + (enviar_enfermeiro * 3);
        }
        ;
        boolean env_respir = map.containsKey("enviar_respirador");
        if (env_respir == true) {
            Long enviar_respirador = Long.parseLong(map.get("enviar_respirador"));
            pontosEnviados = pontosEnviados + (enviar_respirador * 5);
        }
        ;
        boolean env_tomogra = map.containsKey("enviar_tomografo");
        if (env_tomogra == true) {
            Long enviar_tomografo = Long.parseLong(map.get("enviar_tomografo"));
            pontosEnviados = pontosEnviados + (enviar_tomografo * 12);
        }
        ;
        boolean env_ambulan = map.containsKey("enviar_ambulancia");
        if (env_ambulan == true) {
            Long enviar_ambulancia = Long.parseLong(map.get("enviar_ambulancia"));
            pontosEnviados = pontosEnviados + (enviar_ambulancia * 10);
        }
        ;

        if (pontos.longValue() != pontosEnviados.longValue()) {
            return false;
        } else {
            return true;
        }
    }
}
