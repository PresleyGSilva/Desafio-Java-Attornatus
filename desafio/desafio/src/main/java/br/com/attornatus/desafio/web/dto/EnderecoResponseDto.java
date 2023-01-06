package br.com.attornatus.desafio.web.dto;

import br.com.attornatus.desafio.entity.Endereco;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public record EnderecoResponseDto(
        Long id,
        String logradouro,
        String cep,
        String numero,
        String cidade,
        boolean principal
) {

    public static List<EnderecoResponseDto> ofList(List<Endereco> enderecos) {
        List<EnderecoResponseDto> enderecoRequestDtos = new ArrayList<>();
        for (Endereco endereco : enderecos) {
            enderecoRequestDtos.add(EnderecoResponseDto.builder()
                    .id(endereco.getId())
                    .cep(endereco.getCep())
                    .cidade(endereco.getCidade())
                    .logradouro(endereco.getLogradouro())
                    .numero(endereco.getNumero())
                    .principal(endereco.isPrincipal())
                    .build()
            );
        }
        return enderecoRequestDtos;
    }
}
