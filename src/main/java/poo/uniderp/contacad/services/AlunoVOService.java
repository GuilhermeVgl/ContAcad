package poo.uniderp.contacad.services;

import java.util.ArrayList;

import poo.uniderp.contacad.domain.AlunoVO;
import poo.uniderp.contacad.repositories.AlunoVORepositorio;

public class AlunoVOService extends BaseGenericaService<AlunoVORepositorio, AlunoVO> {

    public AlunoVOService(){
        this.repo = new AlunoVORepositorio();
    }

    @Override
    public ArrayList<AlunoVO> Listar() {
        return this.repo.listarAlunos();
    }
}