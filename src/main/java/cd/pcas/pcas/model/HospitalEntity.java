package cd.pcas.pcas.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "tb_hospital")
public class HospitalEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cnpj")
    private Long cnpj;

    @Column(name = "nome")
    private String nome;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "localizacao")
    private String localizacao;

    @Column(name = "ocupacao")
    private Long ocupacao;

    @Column(name = "data")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @JsonManagedReference
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "hospitalEntity")
    private HospitalRecursos hospitalRecursos;

    public HospitalEntity() {
        super();
    }

    public HospitalEntity(Long id, Long cnpj, String nome, String endereco, String localizacao) {
        super();
        this.id = id;
        this.cnpj = cnpj;
        this.nome = nome;
        this.endereco = endereco;
        this.localizacao = localizacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(Long ocupacao) {
        this.ocupacao = ocupacao;
    }

    public HospitalRecursos getHospitalRecursos() {
        return hospitalRecursos;
    }

    public void setHospitalRecursos(HospitalRecursos hospitalRecursos) {
        this.hospitalRecursos = hospitalRecursos;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

}
