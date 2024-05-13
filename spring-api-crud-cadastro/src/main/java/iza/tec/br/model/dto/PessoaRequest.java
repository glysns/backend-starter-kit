package iza.tec.br.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PessoaRequest{
    private String nome;
    private LocalDate aniversario;
    private String cpf;
    //aqui considera que cadastrar um pessoa com endereço
    //reveja sua lógica com base nos requisitos reais
    private EnderecoRequest endereco;
}