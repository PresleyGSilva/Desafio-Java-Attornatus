package br.com.attornatus.desafio.web.dto;

import lombok.Builder;

@Builder
public record EnderecoRequestDto(String logradouro, String cep, String numero, String cidade, boolean principal) {
    
}
