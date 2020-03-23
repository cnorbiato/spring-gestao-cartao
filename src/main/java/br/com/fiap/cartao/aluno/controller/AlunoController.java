package br.com.fiap.cartao.aluno.controller;

import br.com.fiap.cartao.aluno.domain.Aluno;
import br.com.fiap.cartao.aluno.service.AlunoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/aluno")
@AllArgsConstructor
public class AlunoController {

    private AlunoService alunoService;

    @GetMapping("/")
    List<Aluno> findAll(){
        return alunoService.findAll();
    }

    @GetMapping("/{id}")
    Aluno findById(@PathVariable BigInteger id){
        return alunoService.findbyId(id);
    }

    @PostMapping("/")
    Aluno insert(@RequestBody Aluno aluno){
        return alunoService.insert(aluno);
    }

    @PatchMapping("/{id}")
    Aluno update(@RequestBody Aluno aluno){
        return alunoService.update(aluno);
    }

    @DeleteMapping("/{id}")
    void delete(@RequestBody Aluno aluno){
        alunoService.delete(aluno);
    }


}
