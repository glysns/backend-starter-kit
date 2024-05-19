package iza.tec.br.service;

import iza.tec.br.model.dto.EnderecoRequest;
import iza.tec.br.model.dto.EnderecoResponse;
import iza.tec.br.model.dto.PessoaRequest;
import iza.tec.br.model.dto.PessoaResponse;
import iza.tec.br.model.entity.EnderecoEntity;
import iza.tec.br.model.entity.PessoaEntity;
import iza.tec.br.repository.PessoaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Component
@Slf4j
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public Integer incluir(PessoaRequest requisicao){
        return gravar(null, requisicao);
    }

    public Integer alterar(Integer id, PessoaRequest requisicao){
        return gravar(id, requisicao);
    }

    @Transactional
    private Integer gravar(Integer id, PessoaRequest requisicao){
        try {
            //pesquisa sobre tratamento de exceções
            //e handler exception no spring
            if(id == null && repository.existsByCpf(requisicao.getCpf()))
                throw new RuntimeException("Já existe uma pessoa com este cpf");

            PessoaEntity entity = Optional.ofNullable(id).isPresent() ? repository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Elemento não encontrado"))
                    : new PessoaEntity();

            EnderecoEntity endereco = new EnderecoEntity();
            //copiando dados da request para a entity
            BeanUtils.copyProperties(requisicao,entity); //
            if(requisicao.getEndereco()!=null) {
                //copiando dados da request endereço para a entity
                BeanUtils.copyProperties(requisicao.getEndereco(), endereco);
                entity.getEnderecos().add(endereco);
            }
            repository.save(entity);
            return entity.getId();

        } catch (Exception ex) {
            log.error("Não foi possível incluir ou alterar a Aplicacao [ %s ]", requisicao.getNome(), ex);
            throw ex; // crie a sua excecão de negócio
        }
    }
    
    public void excluir(Integer id) {
        repository.deleteById(id);
    }

    public PessoaResponse buscar(Integer id){
        return convert(buscarEntity(id));
    }
    private PessoaEntity buscarEntity(Integer id){
        PessoaEntity entity = repository.findById(id).orElseThrow(() -> new NoSuchElementException("Elemento não encontrado"));
        return entity;
    }
    public List<PessoaResponse> listarTodos() {
        List<PessoaResponse> response = repository.findAll()
                .stream().map(this::convert).collect(Collectors.toList());
        if (response.isEmpty())
            throw new RuntimeException("Lista vazia");

        return response;

    }
    private PessoaResponse convert(PessoaEntity entity){
        PessoaResponse response = new PessoaResponse();
        BeanUtils.copyProperties(entity, response);
        //se quiser já retornar o(s) endereco(s)
        //tenha a logica do endereço padrão
        //o céu é o limite
        response.setEndereco( convert(entity.getEnderecos().get(0)) );
        return response;
    }
    //convert endereço
    private EnderecoResponse convert(EnderecoEntity entity){
        EnderecoResponse response = new EnderecoResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
}