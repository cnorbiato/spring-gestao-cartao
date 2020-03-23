package br.com.fiap.cartao.aluno.batch;

import br.com.fiap.cartao.aluno.domain.Aluno;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@AllArgsConstructor
public class AlunoJob {

    private JobBuilderFactory jobBuilderFactory;
    private StepBuilderFactory stepBuilderFactory;
    private AlunoProcessor alunoProcessor;
    private AlunoDbWriter alunoDbWriter;
    private AlunoFileRowMapper alunoFileRowMapper;

    @Qualifier(value = "alunoJob")
    @Bean
    public Job alunoMainJob() throws Exception {
        return this.jobBuilderFactory.get("alunoJob")
                .start(step1AlunoJob())
                .build();
    }

    @Bean
    public Step step1AlunoJob() {
        return this.stepBuilderFactory.get("step1")
                .<Aluno, Aluno>chunk(20)
                .reader(alunoReader())
                .processor(alunoProcessor)
                .writer(alunoDbWriter)
                .build();
    }

    @Bean
    @StepScope
    public FlatFileItemReader<Aluno> alunoReader() {
        FlatFileItemReader<Aluno> reader = new FlatFileItemReader<>();
        reader.setComments(new String[] { "-"});
        reader.setResource(new ClassPathResource("/static/lista_alunos.txt"));
        reader.setLineMapper(new DefaultLineMapper<Aluno>() {{
            setLineTokenizer(new FixedLengthTokenizer() {{
                setNames("nome", "documento");
                setColumns(new Range[]{new Range(1, 41), new Range(42, 55)});
                setStrict(false);
            }});
            setFieldSetMapper(alunoFileRowMapper);
        }});

        return reader;

    }

}
