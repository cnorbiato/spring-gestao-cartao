package br.com.fiap.cartao.aluno.repository;

import br.com.fiap.cartao.aluno.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface AlunoRepository extends JpaRepository<Aluno, BigInteger> {
}
