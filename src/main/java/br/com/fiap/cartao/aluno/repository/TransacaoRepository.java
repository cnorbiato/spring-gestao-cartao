package br.com.fiap.cartao.aluno.repository;

import br.com.fiap.cartao.aluno.domain.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface TransacaoRepository  extends JpaRepository<Transacao, BigInteger> {

    List<Transacao> findByAlunoDocumento(String documento);

}
