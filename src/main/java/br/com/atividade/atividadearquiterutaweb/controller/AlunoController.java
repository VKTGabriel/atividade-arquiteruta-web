package br.com.atividade.atividadearquiterutaweb.controller;

import br.com.atividade.atividadearquiterutaweb.model.Aluno;
import br.com.atividade.atividadearquiterutaweb.model.dto.AlunoDTO;
import br.com.atividade.atividadearquiterutaweb.model.dto.ValidaEnum;
import br.com.atividade.atividadearquiterutaweb.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @PostMapping
    public ResponseEntity<Aluno> adicionar(@RequestBody AlunoDTO alunoDto) {
        if (alunoDto.invalidar(ValidaEnum.CRIAR)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Aluno aluno = alunoDto.mapear();
        return ResponseEntity.status(HttpStatus.CREATED).body(AlunoService.adicionar(aluno));
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> listar() {
        List<Aluno> lista = AlunoService.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscar(@PathVariable Long id) {
        Aluno resposta = AlunoService.buscarPorId(id);
        return (resposta != null) ? ResponseEntity.status(HttpStatus.OK).body(resposta) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody AlunoDTO alunoDto) {
        if (alunoDto.invalidar(ValidaEnum.ATUALIZAR)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        Aluno resposta = AlunoService.atualizar(id, alunoDto.getNome(), alunoDto.getCurso());
        return (resposta != null) ? ResponseEntity.status(HttpStatus.OK).body(resposta) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return (AlunoService.remover(id)) ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
