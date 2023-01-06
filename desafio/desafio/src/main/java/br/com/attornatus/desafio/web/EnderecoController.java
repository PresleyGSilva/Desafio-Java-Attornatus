package br.com.attornatus.desafio.web;

import br.com.attornatus.desafio.service.PessoaService;
import br.com.attornatus.desafio.web.dto.EnderecoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/enderecos")
@RequiredArgsConstructor
public class EnderecoController {
    private final PessoaService pessoaService;

    @GetMapping("/pessoa/{id}")
    @ResponseBody
    public List<EnderecoResponseDto> getEnderecos(@PathVariable Long id) {
        return pessoaService.getEnderecosByPessoaId(id);
    }


}
