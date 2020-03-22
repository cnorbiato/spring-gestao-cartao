package br.com.fiap.cartao.aluno.batch;

import br.com.fiap.cartao.aluno.domain.Aluno;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

@Component
public class AlunoFileRowMapper implements FieldSetMapper<Aluno> {
    @Override
    public Aluno mapFieldSet(FieldSet fieldSet) throws BindException {
        Aluno aluno = new Aluno();
        aluno.setDocumento(fieldSet.readString("documento"));
        aluno.setNome(fieldSet.readString("nome"));

        return aluno;
    }
}
