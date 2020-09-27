package cd.pcas.pcas.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "tb_contrato")
public class ContratosRecursos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long hospitalSolicitado;
    private Long solicitadoMedico;
    private Long solicitadoEnfermeiro;
    private Long solicitadoRespirador;
    private Long solicitadoTomografo;
    private Long solicitadoAmbulancia;
    private Long hospitalAtribuido;
    private Long atribuidoMedico;
    private Long atribuidoEnfermeiro;
    private Long atribuidoRespirador;
    private Long atribuidoTomografo;
    private Long atribuidoAmbulancia;
    private Long ValoreMedico;
    private Long ValoreEnfermeiro;
    private Long ValoreRespirador;
    private Long ValoreTomografo;
    private Long ValoreAmbulancia;
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHospitalSolicitado() {
        return hospitalSolicitado;
    }

    public void setHospitalSolicitado(Long hospitalSolicitado) {
        this.hospitalSolicitado = hospitalSolicitado;
    }

    public Long getSolicitadoMedico() {
        return solicitadoMedico;
    }

    public void setSolicitadoMedico(Long solicitadoMedico) {
        this.solicitadoMedico = solicitadoMedico;
    }

    public Long getSolicitadoEnfermeiro() {
        return solicitadoEnfermeiro;
    }

    public void setSolicitadoEnfermeiro(Long solicitadoEnfermeiro) {
        this.solicitadoEnfermeiro = solicitadoEnfermeiro;
    }

    public Long getSolicitadoRespirador() {
        return solicitadoRespirador;
    }

    public void setSolicitadoRespirador(Long solicitadoRespirador) {
        this.solicitadoRespirador = solicitadoRespirador;
    }

    public Long getSolicitadoTomografo() {
        return solicitadoTomografo;
    }

    public void setSolicitadoTomografo(Long solicitadoTomografo) {
        this.solicitadoTomografo = solicitadoTomografo;
    }

    public Long getSolicitadoAmbulancia() {
        return solicitadoAmbulancia;
    }

    public void setSolicitadoAmbulancia(Long solicitadoAmbulancia) {
        this.solicitadoAmbulancia = solicitadoAmbulancia;
    }

    public Long getHospitalAtribuido() {
        return hospitalAtribuido;
    }

    public void setHospitalAtribuido(Long hospitalAtribuido) {
        this.hospitalAtribuido = hospitalAtribuido;
    }

    public Long getAtribuidoMedico() {
        return atribuidoMedico;
    }

    public void setAtribuidoMedico(Long atribuidoMedico) {
        this.atribuidoMedico = atribuidoMedico;
    }

    public Long getAtribuidoEnfermeiro() {
        return atribuidoEnfermeiro;
    }

    public void setAtribuidoEnfermeiro(Long atribuidoEnfermeiro) {
        this.atribuidoEnfermeiro = atribuidoEnfermeiro;
    }

    public Long getAtribuidoRespirador() {
        return atribuidoRespirador;
    }

    public void setAtribuidoRespirador(Long atribuidoRespirador) {
        this.atribuidoRespirador = atribuidoRespirador;
    }

    public Long getAtribuidoTomografo() {
        return atribuidoTomografo;
    }

    public void setAtribuidoTomografo(Long atribuidoTomografo) {
        this.atribuidoTomografo = atribuidoTomografo;
    }

    public Long getAtribuidoAmbulancia() {
        return atribuidoAmbulancia;
    }

    public void setAtribuidoAmbulancia(Long atribuidoAmbulancia) {
        this.atribuidoAmbulancia = atribuidoAmbulancia;
    }

    public Long getValoreMedico() {
        return ValoreMedico;
    }

    public void setValoreMedico(Long valoreMedico) {
        ValoreMedico = valoreMedico;
    }

    public Long getValoreEnfermeiro() {
        return ValoreEnfermeiro;
    }

    public void setValoreEnfermeiro(Long valoreEnfermeiro) {
        ValoreEnfermeiro = valoreEnfermeiro;
    }

    public Long getValoreRespirador() {
        return ValoreRespirador;
    }

    public void setValoreRespirador(Long valoreRespirador) {
        ValoreRespirador = valoreRespirador;
    }

    public Long getValoreTomografo() {
        return ValoreTomografo;
    }

    public void setValoreTomografo(Long valoreTomografo) {
        ValoreTomografo = valoreTomografo;
    }

    public Long getValoreAmbulancia() {
        return ValoreAmbulancia;
    }

    public void setValoreAmbulancia(Long valoreAmbulancia) {
        ValoreAmbulancia = valoreAmbulancia;
    }

    public ContratosRecursos() {
        super();
    }

    public ContratosRecursos(Long id, Long hospitalSolicitado, Long solicitadoMedico, Long solicitadoEnfermeiro,
            Long solicitadoRespirador, Long solicitadoTomografo, Long solicitadoAmbulancia, Long hospitalAtribuido,
            Long atribuidoMedico, Long atribuidoEnfermeiro, Long atribuidoRespirador, Long atribuidoTomografo,
            Long atribuidoAmbulancia, Long valoreMedico, Long valoreEnfermeiro, Long valoreRespirador,
            Long valoreTomografo, Long valoreAmbulancia) {
        this.id = id;
        this.hospitalSolicitado = hospitalSolicitado;
        this.solicitadoMedico = solicitadoMedico;
        this.solicitadoEnfermeiro = solicitadoEnfermeiro;
        this.solicitadoRespirador = solicitadoRespirador;
        this.solicitadoTomografo = solicitadoTomografo;
        this.solicitadoAmbulancia = solicitadoAmbulancia;
        this.hospitalAtribuido = hospitalAtribuido;
        this.atribuidoMedico = atribuidoMedico;
        this.atribuidoEnfermeiro = atribuidoEnfermeiro;
        this.atribuidoRespirador = atribuidoRespirador;
        this.atribuidoTomografo = atribuidoTomografo;
        this.atribuidoAmbulancia = atribuidoAmbulancia;
        ValoreMedico = valoreMedico;
        ValoreEnfermeiro = valoreEnfermeiro;
        ValoreRespirador = valoreRespirador;
        ValoreTomografo = valoreTomografo;
        ValoreAmbulancia = valoreAmbulancia;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    
    

    
}
