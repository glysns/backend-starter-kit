package iza.tec.br.webservice;

import iza.tec.br.model.dto.PessoaRequest;
import iza.tec.br.model.dto.PessoaResponse;
import iza.tec.br.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService service;
    @PostMapping
    public Integer incluir(@RequestBody PessoaRequest requisicao ){
        return service.incluir(requisicao);
    }
    @PutMapping("/{id}")
    public Integer alterar(@PathVariable("id") Integer id, @RequestBody PessoaRequest requisicao){
        return service.alterar(id,requisicao);
    }
    @GetMapping("/{id}")
    public PessoaResponse buscar(@PathVariable("id") Integer id){
        return service.buscar(id);
    }
    @GetMapping
    public List<PessoaResponse> listarTodos(){
        return service.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Integer id){
        service.excluir(id);
    }

}