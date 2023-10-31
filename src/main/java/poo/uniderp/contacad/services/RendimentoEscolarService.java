package poo.uniderp.contacad.services;

import java.util.ArrayList;

import poo.uniderp.contacad.domain.RendimentoEscolar;
import poo.uniderp.contacad.repositories.RendimentoEscolarRepositorio;

public class RendimentoEscolarService extends BaseGenericaService<RendimentoEscolarRepositorio, RendimentoEscolar> {

    public RendimentoEscolarService(){
        this.repo = new RendimentoEscolarRepositorio();
    }

    @Override
    public ArrayList<RendimentoEscolar> Listar() {
        return this.repo.ReadAll();
    }

    public RendimentoEscolar consultarNotasAluno(Integer codigoAluno) {
        return this.repo.consultarNotasAluno(codigoAluno);
    }
}