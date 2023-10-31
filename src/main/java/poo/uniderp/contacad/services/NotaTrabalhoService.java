package poo.uniderp.contacad.services;

import java.util.ArrayList;

import poo.uniderp.contacad.domain.NotaTrabalho;
import poo.uniderp.contacad.repositories.NotaTrabalhoRepositorio;

public class NotaTrabalhoService extends BaseGenericaService<NotaTrabalhoRepositorio, NotaTrabalho> {

    public NotaTrabalhoService(){
        this.repo = new NotaTrabalhoRepositorio();
    }

    @Override
    public ArrayList<NotaTrabalho> Listar() {
        return null;
    }

    public NotaTrabalho getNotaTrabalhoAluno(Integer codigoAluno) {
        return this.repo.getNotaTrabalhoAluno(codigoAluno);
    }
}