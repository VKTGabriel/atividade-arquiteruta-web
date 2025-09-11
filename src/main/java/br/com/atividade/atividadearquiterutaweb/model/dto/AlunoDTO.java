package br.com.atividade.atividadearquiterutaweb.model.dto;

import br.com.atividade.atividadearquiterutaweb.model.Aluno;
import br.com.atividade.atividadearquiterutaweb.service.AlunoService;

public record AlunoDTO(
        String nome,
        String curso) {

    public Aluno mapear(){
        Aluno aluno = new Aluno();
        aluno.setId(AlunoService.obterUltimoId() + 1);
        aluno.setNome(this.nome);
        aluno.setCurso(this.curso);

        return aluno;
    }

    public boolean invalidar(ValidaEnum verificador){
        if (verificador == ValidaEnum.CRIAR) {
            return this.nome.isEmpty() || this.curso.isEmpty();
        }
        return this.nome.isEmpty() && this.curso.isEmpty();
    }

    public String getNome() {
        return this.nome;
    }

    public String getCurso() {
        return this.curso;
    }
}
