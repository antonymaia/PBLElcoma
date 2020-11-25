package com.elcoma.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_loja")
@Getter
@Setter
public class Loja implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cnpj;
    private String estilo;
    private String nome;
    private String ponto;

    @OneToMany(mappedBy = "loja")
    @JsonIgnore
    private List<NotaFiscal> notasFiscais = new ArrayList<>();
   // @OneToMany(mappedBy = "loja_fk")
    //private List<Cupom> cupons = new ArrayList();


    public Loja(){}
    public Loja(Integer id, String cnpj, String estilo, String nome, String ponto) {
        this.id = id;
        this.cnpj = cnpj;
        this.estilo = estilo;
        this.nome = nome;
        this.ponto = ponto;
    }
}