package br.com.atividade.atividadearquiterutaweb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {
    private Long id;
    private String nome;
    private String curso;
}
