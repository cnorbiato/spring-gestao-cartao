package br.com.fiap.cartao.aluno.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@NoArgsConstructor
@Data
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private BigInteger id;

    private String nome;

    private String documento;

    private String email;

    @JsonIgnore
    public boolean isAnyEmpty(){
        return this.nome.isEmpty() || this.documento.isEmpty() ? true: false;
    }

}
