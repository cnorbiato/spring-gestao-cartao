package br.com.fiap.cartao.aluno.batch;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@AllArgsConstructor
public class JobRunner {
    private static final Logger logger = LoggerFactory.getLogger(JobRunner.class);

    private JobLauncher jobLauncher;
    private Job alunoJob;

    @Async
    public void runBatchJob() {
        JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
        jobParametersBuilder.addString("fileName", "lista_alunos.txt");
        jobParametersBuilder.addDate("date", new Date(), true);

        try {

            JobExecution jobExecution = jobLauncher.run(alunoJob,
                    jobParametersBuilder.toJobParameters());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
