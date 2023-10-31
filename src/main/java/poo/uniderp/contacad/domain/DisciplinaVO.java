package poo.uniderp.contacad.domain;

public class DisciplinaVO extends BaseDadosComuns {
    
    private String nome;
    private String ementa;

    public DisciplinaVO(
        Integer codigo, 
        String nome, 
        String ementa
        ) 
    {
        super(codigo);
        this.nome = nome;
        this.ementa = ementa;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmenta() {
        return ementa;
    }
    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public DisciplinaVO() {}
}
