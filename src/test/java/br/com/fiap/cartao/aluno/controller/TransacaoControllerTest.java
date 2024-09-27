package br.com.fiap.cartao.aluno.controller;

import br.com.fiap.cartao.aluno.domain.Aluno;
import br.com.fiap.cartao.aluno.domain.Transacao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.Month;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
class TransacaoControllerTest {

    Aluno alunoTest;
    BigInteger valBigAlunoId = new BigInteger("3");
    Transacao transacaoTest;
    BigInteger valBigTransacaoId = new BigInteger("4");
    BigDecimal valBigTransacaoCompra = new BigDecimal("325.99");
    LocalDateTime dataTransacao = LocalDateTime.of(2020, Month.MARCH, 1, 10, 10, 30);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    public void init(){

        alunoTest = Aluno.builder()
                .id(valBigAlunoId)
                .documento("123123123")
                .email("tester@teste.com")
                .nome("nomeTester")
                .build();
          transacaoTest = Transacao.builder()
                  .id(valBigTransacaoId)
                  .aluno(alunoTest)
                  .dataHoraCompra(dataTransacao)
                  .valorCompra(valBigTransacaoCompra)
                  .build();
    }

    @Test
    void insert() throws Exception {
       mvc.perform(post("/transacao").contentType(MediaType.APPLICATION_JSON)
               .content(objectMapper.writeValueAsString(transacaoTest)))
               .andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        mvc.perform(get("/transacao/{id}", 4)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(transacaoTest.getId())));
    }

    @Test
    void findAll() throws Exception {
        mvc.perform(get("/transacao")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(transacaoTest.getId())));
    }
}