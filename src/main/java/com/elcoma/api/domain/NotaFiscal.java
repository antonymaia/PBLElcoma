package com.elcoma.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "tb_nota_fiscal")
@Getter @Setter
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_loja")
    private Loja loja_fk;

    @JsonIgnore
    @OneToOne(mappedBy = "notaFiscal_fk")
    private PerfilUsuario perfilUsuario;


    public NotaFiscal(Integer id, Double decimal, Usuario usuario, Loja loja) {
        this.id = id;
        this.valor = decimal;
        this.usuario = usuario;
        this.loja_fk = loja;
    }
}
