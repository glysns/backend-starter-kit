package iza.tec.br.repository;

import iza.tec.br.model.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    boolean existsByCpf(String cpf);
}
