package br.com.attornatus.desafio.entity;

import br.com.attornatus.desafio.web.dto.EnderecoRequestDto;
import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "cep")
    private String cep;

    @Column(name = "numero")
    private String numero;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "principal")
    private boolean principal;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public static Endereco of(EnderecoRequestDto enderecoRequestDto, Pessoa pessoa) {
        return Endereco.builder()
                .cep(enderecoRequestDto.cep())
                .cidade(enderecoRequestDto.cidade())
                .numero(enderecoRequestDto.numero())
                .logradouro(enderecoRequestDto.logradouro())
                .principal(enderecoRequestDto.principal())
                .pessoa(pessoa)
                .build();
    }

}
