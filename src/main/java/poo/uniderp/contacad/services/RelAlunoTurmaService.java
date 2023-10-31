package poo.uniderp.contacad.services;

import java.util.ArrayList;

import poo.uniderp.contacad.domain.RelAlunoTurma;
import poo.uniderp.contacad.repositories.RelAlunoTurmaRepositorio;

public class RelAlunoTurmaService extends BaseGenericaService<RelAlunoTurmaRepositorio, RelAlunoTurma> {

    public RelAlunoTurmaService(){
        this.repo = new RelAlunoTurmaRepositorio();
    }

    @Override
    public ArrayList<RelAlunoTurma> Listar() {
        return null;
    }

    public ArrayList<RelAlunoTurma> listarAlunosDaTurma(Integer codigoTurma) {
        return this.repo.listarAlunosTurma(codigoTurma);
    }

    public RelAlunoTurma getTurmaAluno(Integer codigoAluno) {
        return this.repo.getTurmaAluno(codigoAluno);
    }
}