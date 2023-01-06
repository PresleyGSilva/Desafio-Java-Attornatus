package br.com.attornatus.desafio.web.dto;

import java.time.LocalDate;
import java.util.List;

public record PessoaRequestDto(
        String nome,
        LocalDate dataNascimento,
        List<EnderecoRequestDto> enderecos
) {

}
