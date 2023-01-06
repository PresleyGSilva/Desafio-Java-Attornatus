package br.com.attornatus.desafio.web.dto;

import br.com.attornatus.desafio.entity.Pessoa;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record PessoaResponseDto(
        Long id,
        String nome,
        LocalDate dataNascimento,
        List<EnderecoResponseDto> enderecos
) {
    public static PessoaResponseDto of(Pessoa pessoa) {
        return PessoaResponseDto.builder()
                .id(pessoa.getId())
                .dataNascimento(pessoa.getDataNascimento())
                .nome(pessoa.getNome())
                .enderecos(EnderecoResponseDto.ofList(pessoa.getEnderecos()))
                .build();
    }

}
