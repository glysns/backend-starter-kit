package iza.tec.br.model.entity;


import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "tab_endereco")
@Data
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    private String cep;
    private String logradouro;
    private String numero;
    private String cidade;
    private String estado;

}
