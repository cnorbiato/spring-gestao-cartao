package br.com.fiap.cartao.aluno.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@NoArgsConstructor
@Data
public class Aluno implements Serializable {

    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private BigInteger id;

    private String nome;

    private String documento;

    private String email;

    @JsonIgnore
    public boolean isAnyEmpty(){
        return this.nome.isEmpty() || this.documento.isEmpty() ? true: false;
    }

}
