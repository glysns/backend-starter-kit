package iza.tec.br;

import iza.tec.br.model.dto.PessoaRequest;
import iza.tec.br.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class StartApp implements ApplicationRunner {
    @Autowired
    private PessoaService service;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        PessoaRequest request = new PessoaRequest();
        request.setAniversario(LocalDate.now());
        request.setCpf("88909855623");
        request.setNome("Gleyson Sampaio");
        try{
            service.buscar(1);
        }catch (Exception ex) {
            service.incluir(request);
        }
    }
}
