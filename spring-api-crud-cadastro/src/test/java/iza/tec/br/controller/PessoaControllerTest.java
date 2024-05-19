package iza.tec.br.controller;

import iza.tec.br.model.dto.PessoaRequest;
import iza.tec.br.service.PessoaService;
import iza.tec.br.webservice.PessoaController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

@SpringBootTest
@ActiveProfiles("test")
@Slf4j
public class PessoaControllerTest {
    @Autowired
    private PessoaController controller;

    //trataria as respostas http
    @Test
    public void deveSalvarUmaPessoaSemEndereco(){
        PessoaRequest request = new PessoaRequest();
        request.setAniversario(LocalDate.of(1990, 10, 21));
        request.setCpf("22398688923");
        request.setNome("Gleyson Sampaio Teste");
        Integer id = controller.incluir(request);
        log.info("O id da gerado na inclusão da marca foi -> {}", id);
        Assertions.assertTrue(id > 0);
    }
}
