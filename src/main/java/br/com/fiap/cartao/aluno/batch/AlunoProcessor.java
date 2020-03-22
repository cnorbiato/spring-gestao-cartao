package br.com.fiap.cartao.aluno.batch;

import br.com.fiap.cartao.aluno.domain.Aluno;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class AlunoProcessor implements ItemProcessor<Aluno,Aluno> {

    @Override
    public Aluno process(Aluno item) throws Exception {
        Aluno aluno = new Aluno();
        aluno.setNome(item.getNome());
        aluno.setDocumento(item.getDocumento());
        return aluno.isAnyEmpty() ? null : aluno;
    }
}
