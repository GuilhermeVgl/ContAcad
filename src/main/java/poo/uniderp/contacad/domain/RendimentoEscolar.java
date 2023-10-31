package poo.uniderp.contacad.domain;

public class RendimentoEscolar extends BaseDadosComuns implements IImpressao{

    private Integer aluno;
    private Integer turma;
    private Double primeiraNotaProva;
    private Double segundaNotaProva;
    private Double mediaTrabalhos;
    private Double mediaGeralAluno;
    
    public RendimentoEscolar(
        Integer codigo, 
        Integer aluno, 
        Integer turma, 
        Double primeiraNotaProva,
        Double segundaNotaProva, 
        Double mediaTrabalhos, 
        Double mediaGeralAluno
        ) 
    {
        super(codigo);
        this.aluno = aluno;
        this.turma = turma;
        this.primeiraNotaProva = primeiraNotaProva;
        this.segundaNotaProva = segundaNotaProva;
        this.mediaTrabalhos = mediaTrabalhos;
        this.mediaGeralAluno = mediaGeralAluno;
    }

    public RendimentoEscolar() {}

    public Integer getAluno() {
        return aluno;
    }
    public void setAluno(Integer aluno) {
        this.aluno = aluno;
    }
    public Integer getTurma() {
        return turma;
    }
    public void setTurma(Integer turma) {
        this.turma = turma;
    }
    public Double getPrimeiraNotaProva() {
        return primeiraNotaProva;
    }
    public void setPrimeiraNotaProva(Double primeiraNotaProva) {
        this.primeiraNotaProva = primeiraNotaProva;
    }
    public Double getSegundaNotaProva() {
        return segundaNotaProva;
    }
    public void setSegundaNotaProva(Double segundaNotaProva) {
        this.segundaNotaProva = segundaNotaProva;
    }
    public Double getMediaTrabalhos() {
        return mediaTrabalhos;
    }
    public void setMediaTrabalhos(Double mediaTrabalhos) {
        this.mediaTrabalhos = mediaTrabalhos;
    }
    public Double getMediaGeralAluno() {
        return mediaGeralAluno;
    }
    public void setMediaGeralAluno(Double mediaGeralAluno) {
        this.mediaGeralAluno = mediaGeralAluno;
    }

    @Override
    public void Imprimir() {
        System.out.println("Turma do aluno: " + this.turma);
        System.out.println("Primeira nota prova: " + this.primeiraNotaProva);
        System.out.println("Segunda nota prova: " + this.segundaNotaProva);
        System.out.println("Media dos trabalhos do aluno: " + this.mediaTrabalhos);
        System.out.println("Media Geral do aluno: " + this.mediaGeralAluno);
    }
}
