package br.com.attornatus.desafio.web;

import br.com.attornatus.desafio.service.PessoaService;
import br.com.attornatus.desafio.web.dto.PessoaRequestDto;
import br.com.attornatus.desafio.web.dto.PessoaResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pessoas")
@RequiredArgsConstructor
public class PessoaController {
    private final PessoaService pessoaService;

    @PostMapping
    public void criarPessoa(@RequestBody PessoaRequestDto pessoaRequestDto) {
        pessoaService.criarPessoa(pessoaRequestDto);

    }

    @GetMapping("/{id}")
    public PessoaResponseDto listPessoa(@PathVariable("id") Long id) {
        return pessoaService.listPessoaById(id);

    }

    @GetMapping
    public List<PessoaResponseDto> listAll() {
        return pessoaService.listAll();
    }

    @PutMapping("{id}")
    public void editarPessoa(@RequestBody PessoaRequestDto pessoa, @PathVariable("id") Long id) {
        pessoaService.editarPessoa(pessoa, id);
    }


}
