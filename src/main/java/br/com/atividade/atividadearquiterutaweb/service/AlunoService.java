package br.com.atividade.atividadearquiterutaweb.service;

import br.com.atividade.atividadearquiterutaweb.model.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoService {
    private static List<Aluno> alunos = new ArrayList<Aluno>();

    public static Long obterUltimoId(){
        if(alunos.isEmpty()){
            return 0L;
        }

        return alunos.getLast().getId();
    }

    public static Aluno adicionar(Aluno aluno) {
        alunos.add(aluno);
        return aluno;
    }

    public static List<Aluno> listarTodos(){
        return alunos;
    }

    public static boolean remover(Long id){
        return alunos.removeIf(aluno -> aluno.getId().equals(id));
    }

    public static Aluno atualizar(Long id, String nome, String curso) {
        for(Aluno aluno : alunos){
            if(aluno.getId().equals(id)){
                if(!curso.isEmpty()){
                    aluno.setCurso(curso);
                }

                if(!nome.isEmpty()){
                    aluno.setNome(nome);
                }

                return aluno;
            }
        }

        return null;
    }

    public static Aluno buscarPorId(Long id){
        for(Aluno aluno : alunos){
            if(aluno.getId().equals(id)){
                return aluno;
            }
        }

        return null;
    }
}
