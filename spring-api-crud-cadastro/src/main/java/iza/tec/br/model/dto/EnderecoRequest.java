package iza.tec.br.model.dto;

import lombok.Data;

@Data
public class EnderecoRequest {
    private String cep;
    private String logradouro;
    private String numero;
    private String cidade;
    private String estado;
}
