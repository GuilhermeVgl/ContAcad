package poo.uniderp.contacad.domain;

public abstract class BaseDadosComuns {
    
    protected Integer codigo;
    
    public BaseDadosComuns(Integer codigo) {
        this.codigo = codigo;
    }

    public BaseDadosComuns() {}

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
   
}