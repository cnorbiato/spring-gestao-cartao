package br.com.fiap.cartao.aluno.controller;

import br.com.fiap.cartao.aluno.batch.JobRunner;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
@AllArgsConstructor
public class JobController {

    private JobRunner jobRunner;

    @GetMapping("/run")
    public String runJob(){
        jobRunner.runBatchJob();
        return String.format("Job Carga Aluno submetido com sucesso");
    }

}
