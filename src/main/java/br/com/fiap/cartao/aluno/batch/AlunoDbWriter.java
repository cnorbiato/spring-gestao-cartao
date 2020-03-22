package br.com.fiap.cartao.aluno.batch;

import br.com.fiap.cartao.aluno.domain.Aluno;
import br.com.fiap.cartao.aluno.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AlunoDbWriter implements ItemWriter<Aluno> {

    private AlunoRepository alunoRepository;

    @Override
    public void write(List<? extends Aluno> alunos) throws Exception {
        alunoRepository.saveAll(alunos);
        alunoRepository.flush();
    }
}
