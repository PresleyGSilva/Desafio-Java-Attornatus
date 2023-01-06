package br.com.attornatus.desafio.repository;

import br.com.attornatus.desafio.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    List<Endereco> findEnderecosByPessoaId(Long idPessoa);
}
