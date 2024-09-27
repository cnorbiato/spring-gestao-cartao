package br.com.fiap.cartao.aluno.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@NoArgsConstructor
@Data
@Builder
public class Aluno implements Serializable {

    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private BigInteger id;

    private String nome;

    private String documento;

    private String email;

    public Aluno(BigInteger id, String nome, String documento, String email) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.email = email;
    }

    @JsonIgnore
    public boolean isAnyEmpty(){
        return this.nome.isEmpty() || this.documento.isEmpty() ? true: false;
    }

}
