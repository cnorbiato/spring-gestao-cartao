package br.com.fiap.cartao.aluno.controller;

import br.com.fiap.cartao.aluno.domain.Transacao;
import br.com.fiap.cartao.aluno.service.TransacaoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/transacao")
@AllArgsConstructor
public class TransacaoController {

    private TransacaoService transacaoService;

    @GetMapping()
    List<Transacao> findAll(){
        return transacaoService.findAll();
    }

    @GetMapping("{id}")
    Transacao findById(@PathVariable BigInteger id){
        return transacaoService.findById(id);
    }

    @GetMapping(params = { "documento" })
    List<Transacao> findByAlunoDocumento(@RequestParam(name = "documento" ) String documento){
        return transacaoService.findByDocumentoAluno(documento);
    }

    @PostMapping
    Transacao insert(@RequestBody Transacao transacao){
        return transacaoService.insert(transacao);
    }

}
