package br.com.attornatus.desafio.entity;

import br.com.attornatus.desafio.web.dto.PessoaRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "pessoa")
    private List<Endereco> enderecos = new ArrayList<>();

    public static Pessoa of(PessoaRequestDto pessoaRequestDto) {
        return Pessoa.builder()
                .nome(pessoaRequestDto.nome())
                .dataNascimento(pessoaRequestDto.dataNascimento())
                .build();
    }

}
