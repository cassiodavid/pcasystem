package cd.pcas.pcas.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "tb_recursos")
public class HospitalRecursos implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "medico")
    private Long medico;

    @Column(name = "enfermeiro")
    private Long enfermeiro;

    @Column(name = "respirador")
    private Long respirador;

    @Column(name = "tomografo")
    private Long tomografo;

    @Column(name = "ambulancia")
    private Long ambulancia;

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "hospital_id")
    private HospitalEntity hospitalEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMedico() {
        return medico;
    }

    public void setMedico(Long medico) {
        this.medico = medico;
    }

    public Long getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Long enfermeiro) {
        this.enfermeiro = enfermeiro;
    }

    public Long getRespirador() {
        return respirador;
    }

    public void setRespirador(Long respirador) {
        this.respirador = respirador;
    }

    public Long getTomografo() {
        return tomografo;
    }

    public void setTomografo(Long tomografo) {
        this.tomografo = tomografo;
    }

    public Long getAmbulancia() {
        return ambulancia;
    }

    public void setAmbulancia(Long ambulancia) {
        this.ambulancia = ambulancia;
    }

    public HospitalRecursos(Long id, Long medico, Long enfermeiro, Long respirador, Long tomografo, Long ambulancia) {
        this.id = id;
        this.medico = medico;
        this.enfermeiro = enfermeiro;
        this.respirador = respirador;
        this.tomografo = tomografo;
        this.ambulancia = ambulancia;
    }

    public HospitalRecursos() {
        super();
    }

    public HospitalEntity getHospitalEntity() {
        return hospitalEntity;
    }

    public void setHospitalEntity(HospitalEntity hospitalEntity) {
        this.hospitalEntity = hospitalEntity;
    }

}