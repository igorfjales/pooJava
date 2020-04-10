package Modelo;


public class Professor extends Funcionario {
    private String disciplina;

    public void AumentarSalario() {
        setSalario(getSalario() + (getSalario() * 0.1));
    }

    public void AumentarSalario(double quantidade) {
        setSalario(getSalario() + quantidade);
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

}
