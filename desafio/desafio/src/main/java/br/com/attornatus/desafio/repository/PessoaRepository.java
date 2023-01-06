package br.com.attornatus.desafio.repository;

import br.com.attornatus.desafio.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
