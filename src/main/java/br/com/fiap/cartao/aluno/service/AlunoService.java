package br.com.fiap.cartao.aluno.service;

import br.com.fiap.cartao.aluno.domain.Aluno;
import br.com.fiap.cartao.aluno.exception.CustomObjectNotFoundException;
import br.com.fiap.cartao.aluno.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AlunoService {

    private AlunoRepository alunoRepository;

    public Aluno findbyId(BigInteger id){
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);

        return alunoOptional.orElseThrow(() ->
                new CustomObjectNotFoundException("Aluno nao encontrado pelo Id Informado: " + id));

    }

    public List<Aluno> findAll(){
        return alunoRepository.findAll();
    }

    public Aluno insert(Aluno aluno){
        return alunoRepository.saveAndFlush(aluno);
    }

    public Aluno update(Aluno aluno){
        findbyId(aluno.getId());
        return alunoRepository.saveAndFlush(aluno);
    }

    public void delete(Aluno aluno){
        findbyId(aluno.getId());
        alunoRepository.delete(aluno);
    }

}
