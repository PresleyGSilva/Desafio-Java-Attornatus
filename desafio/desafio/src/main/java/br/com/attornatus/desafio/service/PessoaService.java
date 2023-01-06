package br.com.attornatus.desafio.service;

import br.com.attornatus.desafio.entity.Endereco;
import br.com.attornatus.desafio.entity.Pessoa;
import br.com.attornatus.desafio.repository.EnderecoRepository;
import br.com.attornatus.desafio.repository.PessoaRepository;
import br.com.attornatus.desafio.web.dto.EnderecoRequestDto;
import br.com.attornatus.desafio.web.dto.EnderecoResponseDto;
import br.com.attornatus.desafio.web.dto.PessoaRequestDto;
import br.com.attornatus.desafio.web.dto.PessoaResponseDto;
import jakarta.persistence.Transient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final EnderecoRepository enderecoRepository;

    @Transient
    public void criarPessoa(PessoaRequestDto pessoaRequestDto) {
        Pessoa pessoaGerenciada = pessoaRepository.save(Pessoa.of(pessoaRequestDto));

        log.info("criandoPessoa" + pessoaRequestDto);
        List<Endereco> enderecoList = new ArrayList<>();
        for (EnderecoRequestDto endereco : pessoaRequestDto.enderecos()) {
            enderecoList.add(Endereco.of(endereco, pessoaGerenciada));
        }
        List<Endereco> enderecoListGerenciado = enderecoRepository.saveAll(enderecoList);
        pessoaGerenciada.setEnderecos(enderecoListGerenciado);
    }

    public PessoaResponseDto listPessoaById(Long id) {
        log.info("listando Pessoa com id = " + id);
        val pessoa = pessoaRepository.findById(id);
        return pessoa.map(PessoaResponseDto::of).orElse(null);
    }


    public List<EnderecoResponseDto> getEnderecosByPessoaId(Long idPessoa) {
        log.info("listando enderecos da pessoa com id = " + idPessoa);
        List<Endereco> enderecos = enderecoRepository.findEnderecosByPessoaId(idPessoa);
        return EnderecoResponseDto.ofList(enderecos);

    }

    public List<PessoaResponseDto> listAll() {
        return pessoaRepository.findAll().stream().map(PessoaResponseDto::of).toList();
    }

    public void editarPessoa(PessoaRequestDto pessoaRequestDto, Long id) {
        Optional<Pessoa> pessoaGerenciada = pessoaRepository.findById(id);
        val pessoa = Pessoa.of(pessoaRequestDto);

        if (pessoaGerenciada.isPresent()) {
            pessoa.setEnderecos(pessoaGerenciada.get().getEnderecos());
            pessoa.setId(pessoaGerenciada.get().getId());
            pessoaRepository.save(pessoa);
        }

    }
}

