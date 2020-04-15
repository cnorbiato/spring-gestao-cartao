package br.com.fiap.cartao.aluno.controller;

import br.com.fiap.cartao.aluno.domain.Aluno;
import br.com.fiap.cartao.aluno.domain.Transacao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.*;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import java.math.BigInteger;


@RunWith(SpringRunner.class)
@WebMvcTest(AlunoController.class)
class AlunoControllerTest {

    Aluno alunoTest;
    BigInteger valBigAlunoId = new BigInteger("3");

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
    }

    @Test
    void insert() throws Exception {
       mvc.perform(post("/aluno").contentType(MediaType.APPLICATION_JSON)
               .content(objectMapper.writeValueAsString(alunoTest)))
               .andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        mvc.perform(get("/aluno/{id}", 3)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(alunoTest.getId())));

    }

    @Test
    void delete() throws Exception {
        mvc.perform(delete("/aluno/{id}", 3)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    void update() throws Exception {
        alunoTest.setDocumento("567567567");

        mvc.perform(put("/aluno/{id}", 3)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(alunoTest)))
                .andExpect(status().isOk());
    }
}