package poo.uniderp.contacad.services;

import java.util.ArrayList;

public abstract class BaseGenericaService<TRepo, TDom> {
    
    protected TRepo repo;

    public abstract ArrayList<TDom> Listar();

    public BaseGenericaService(){}
}