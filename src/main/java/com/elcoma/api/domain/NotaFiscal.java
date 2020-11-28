package com.elcoma.api.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name = "tb_notafiscal")
@Getter @Setter
public class NotaFiscal implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_loja")
    private Loja loja;

    public NotaFiscal(){}

    public NotaFiscal(Integer id, Double decimal, Usuario usuario, Loja loja) {
        this.id = id;
        this.valor = decimal;
        this.usuario = usuario;
        this.loja= loja;
    }
}
