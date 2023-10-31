package poo.uniderp.contacad.domain;

public class TurmaVO extends BaseDadosComuns  implements IImpressao{
    
    private Integer disciplina;
    private Integer professor;
    private Integer capacidadeDaTurma;
    
    public TurmaVO(
        Integer codigo, 
        Integer disciplina, 
        Integer professor, 
        Integer capacidadeDaTurma
        ) 
    {
        super(codigo);
        this.disciplina = disciplina;
        this.professor = professor;
        this.capacidadeDaTurma = capacidadeDaTurma;
    }

    public TurmaVO() {}

    public Integer getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(Integer disciplina) {
        this.disciplina = disciplina;
    }
    public Integer getProfessor() {
        return professor;
    }
    public void setProfessor(Integer professor) {
        this.professor = professor;
    }
    public Integer getCapacidadeDaTurma() {
        return capacidadeDaTurma;
    }
    public void setCapacidadeDaTurma(Integer capacidadeDaTurma) {
        this.capacidadeDaTurma = capacidadeDaTurma;
    }

    @Override
    public void Imprimir() {
        System.out.println("código: " + this.codigo);
        System.out.println("Disciplina: " + this.disciplina);
        System.out.println("Professor: " + this.professor);
        System.out.println("Capacidade da turma: " + this.capacidadeDaTurma);
    }
}
