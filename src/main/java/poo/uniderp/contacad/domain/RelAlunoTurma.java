package poo.uniderp.contacad.domain;

public class RelAlunoTurma implements IImpressao{

    private Integer codigo;
    private Integer alunoCodigo;
    private Integer turmaCodigo;

    public RelAlunoTurma(
        Integer codigo,
        Integer alunoCodigo, 
        Integer turmaCodigo
        ) 
    {
        this.codigo = codigo;
        this.alunoCodigo = alunoCodigo;
        this.turmaCodigo = turmaCodigo;
    }

    public RelAlunoTurma () {}

    public Integer getAlunoCodigo() {
        return alunoCodigo;
    }
    public void setAlunoCodigo(Integer alunoCodigo) {
        this.alunoCodigo = alunoCodigo;
    }
    public Integer getTurmaCodigo() {
        return turmaCodigo;
    }
    public void setTurmaCodigo(Integer turmaCodigo) {
        this.turmaCodigo = turmaCodigo;
    }
    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public void Imprimir() {
    }
}
