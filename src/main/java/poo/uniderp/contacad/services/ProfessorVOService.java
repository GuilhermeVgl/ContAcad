package poo.uniderp.contacad.services;

import java.util.ArrayList;

import poo.uniderp.contacad.domain.ProfessorVO;
import poo.uniderp.contacad.domain.RelProfessorTurma;
import poo.uniderp.contacad.repositories.ProfessorVORepositorio;

public class ProfessorVOService extends BaseGenericaService<ProfessorVORepositorio, ProfessorVO> {

    public ProfessorVOService(){
        this.repo = new ProfessorVORepositorio();
    }

    @Override
    public ArrayList<ProfessorVO> Listar() {
        return this.repo.listarProfessores();
    }

    public ProfessorVO getProfessorByCod(Integer professorCodigo) {
        return this.repo.getProfessorByCod(professorCodigo);
    }
}