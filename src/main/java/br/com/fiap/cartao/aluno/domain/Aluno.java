package br.com.fiap.cartao.aluno.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Aluno {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private BigInteger id;

    private String nome;

    private String documento;

    public boolean isAnyEmpty(){
        return this.nome.isEmpty() || this.documento.isEmpty() ? true: false;
    }

}
