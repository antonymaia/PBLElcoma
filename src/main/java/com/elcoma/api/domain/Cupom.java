package com.elcoma.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "tb_cupom")
@Getter @Setter
public class Cupom implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String validade;
    private String valor;

    @ManyToOne
    @JoinColumn(name = "id_loja")
    private Loja loja;

    public Cupom() {
    }

    public Cupom(Integer id, String validade, String valor, Loja loja) {
        this.id = id;
        this.validade = validade;
        this.valor = valor;
        this.loja = loja;
    }


}
