package com.elcoma.api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

//anotação usada para especificar que essa classe corresponde a tabela "tb_usuario"
@Entity(name = "tb_usuario")
/*anotações do lombok, utilizada para gerar o getters e setters sem o codigo
  mas para utilizar, é necessário que você adicione o plugin lombok na sua ide*/
@Getter @Setter
public class Usuario implements Serializable {
    //anotação usada para especificar que o atributo id é um a chave primaira da tabela
    @Id
    // abotação usada para especificar que a chave primaria é auto increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cpf;
    private String nome;
    private String endereco;
    private String sexo;
    private String email;
    private Date nascimento;
    private String senha;

    //Construtor vazio
    public Usuario(){}

    //Construtor com todos atributos inicializados
    public Usuario(int id, String cpf, String nome, String endereco, String sexo, String email, Date nascimento, String senha) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.sexo = sexo;
        this.email = email;
        this.nascimento = nascimento;
        this.senha = senha;
    }


}
