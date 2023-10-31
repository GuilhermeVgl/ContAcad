package poo.uniderp.contacad.services;

import java.util.ArrayList;

import poo.uniderp.contacad.domain.RelProfessorTurma;
import poo.uniderp.contacad.repositories.RelProfessorTurmaRepositorio;

public class RelProfessorTurmaService extends BaseGenericaService<RelProfessorTurmaRepositorio, RelProfessorTurma> {

    public RelProfessorTurmaService(){
        this.repo = new RelProfessorTurmaRepositorio();
    }

    @Override
    public ArrayList<RelProfessorTurma> Listar() {
        return this.repo.listarRelacionamentos();
    }

    public ArrayList<RelProfessorTurma> listarTurmasProfessor(Integer professorCodigo) {
        return this.repo.listarTurmasProfessor(professorCodigo);
    }
}