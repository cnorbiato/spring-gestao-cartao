package br.com.fiap.cartao.aluno.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
//@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Transacao implements Serializable {

    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private BigInteger id;

    private BigDecimal valorCompra;

    private LocalDateTime dataHoraCompra;

    public Transacao(BigInteger id, BigDecimal valorCompra, LocalDateTime dataHoraCompra, Aluno aluno) {
        this.id = id;
        this.valorCompra = valorCompra;
        this.dataHoraCompra = dataHoraCompra;
        this.aluno = aluno;
    }

    @ManyToOne
    @JoinColumn(name = "documento", referencedColumnName="documento")
    private Aluno aluno;

}
