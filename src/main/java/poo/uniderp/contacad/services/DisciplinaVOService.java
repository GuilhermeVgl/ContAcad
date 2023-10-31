package poo.uniderp.contacad.services;

import java.util.ArrayList;

import poo.uniderp.contacad.domain.DisciplinaVO;
import poo.uniderp.contacad.repositories.DisciplinaVORepositorio;

public class DisciplinaVOService extends BaseGenericaService<DisciplinaVORepositorio, DisciplinaVO> {

    public DisciplinaVOService(){
        this.repo = new DisciplinaVORepositorio();
    }

    @Override
    public ArrayList<DisciplinaVO> Listar() 
    {
        return this.repo.listarDisciplinas();
    }

    public DisciplinaVO buscarDisciplinaAluno(Integer codigoAluno) 
    {
        return this.repo.buscarDisciplinaAluno(codigoAluno);
    }
}