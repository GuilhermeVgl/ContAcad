package poo.uniderp.contacad.repositories;

import java.util.ArrayList;

public abstract class BaseGenericaCRUD<TFakeDB, TDom> {

    protected TFakeDB db;

     protected ArrayList<TDom> dataset;

    public abstract TDom Read(int codigo);

    public ArrayList<TDom> ReadAll() {
        return this.dataset;
    }
}