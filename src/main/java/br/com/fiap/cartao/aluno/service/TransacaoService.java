package br.com.fiap.cartao.aluno.service;

import br.com.fiap.cartao.aluno.domain.Transacao;
import br.com.fiap.cartao.aluno.exception.CustomObjectNotFoundException;
import br.com.fiap.cartao.aluno.repository.TransacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TransacaoService {

    private TransacaoRepository transacaoRepository;

    public Transacao findById(BigInteger id){
        Optional<Transacao> optionalTransacao = transacaoRepository.findById(id);
        return optionalTransacao.orElseThrow(() ->
                new CustomObjectNotFoundException("Transacao nao encontrada pelo Id Informado: " + id));
    }

    public List<Transacao> findByDocumentoAluno(String documento){
       return transacaoRepository.findByAlunoDocumento(documento);
    }

    public List<Transacao> findAll(){
        return transacaoRepository.findAll();
    }

    public Transacao insert(Transacao transacao){
        return transacaoRepository.saveAndFlush(transacao);
    }

    public Transacao update(Transacao transacao){
        findById(transacao.getId());
        return transacaoRepository.saveAndFlush(transacao);
    }

    public void delete(Transacao transacao){
        findById(transacao.getId());
        transacaoRepository.delete(transacao);
    }

}
