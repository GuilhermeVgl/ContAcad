package poo.uniderp.contacad.services;

import java.util.ArrayList;

import poo.uniderp.contacad.domain.TurmaVO;
import poo.uniderp.contacad.repositories.TurmaVORepositorio;

public class TurmaVOService extends BaseGenericaService<TurmaVORepositorio, TurmaVO> {

    public TurmaVOService(){
        this.repo = new TurmaVORepositorio();
    }

    @Override
    public ArrayList<TurmaVO> Listar() {
        return this.repo.listarTurmas();
    }

    public TurmaVO buscarTurma(Integer codigoTurma) {
        return this.repo.buscarTurma(codigoTurma);
    }
}