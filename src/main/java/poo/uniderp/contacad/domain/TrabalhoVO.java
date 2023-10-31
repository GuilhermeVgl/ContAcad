package poo.uniderp.contacad.domain;

public class TrabalhoVO extends BaseDadosComuns {
    
    private Integer disciplina;
    private String descricao;
    
    public TrabalhoVO(
        Integer codigo, 
        Integer disciplina, 
        String descricao
        ) 
    {
        super(codigo);
        this.disciplina = disciplina;
        this.descricao = descricao;
    }

    public TrabalhoVO() {}

    public Integer getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(Integer disciplina) {
        this.disciplina = disciplina;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
