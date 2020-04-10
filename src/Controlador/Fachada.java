package Controlador;

import Modelo.*;
import excecoes.*;

public class Fachada implements IControladorDiretor, IControladorProfessor, IControladorAluno, IControladorSala, IControladorDono {

    private static Fachada instancia;
    private final IControladorProfessor controladorProfessor;
    private final IControladorDiretor controladorDiretor;
    private final IControladorAluno controladorAluno;
    private final IControladorSala controladorSala;
    private final IControladorDono controladorDono;

    private Fachada() {
        controladorDiretor = ControladorDiretor.getInstancia();
        controladorProfessor = ControladorProfessor.getInstancia();
        controladorAluno = ControladorAluno.getInstancia();
        controladorSala = ControladorSala.getInstancia();
        controladorDono = ControladorDono.getInstancia();
    }

    public static Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    @Override
    public void inserirAluno(Aluno a) throws DiretorException {
        controladorDiretor.inserirAluno(a);
    }

    @Override
    public void removerAlunoCodigo(String codigo) throws DiretorException {
        controladorDiretor.removerAlunoCodigo(codigo);
    }

    //OVERLOAD
    public Aluno pesquisarAlunoCodigo(String codigo) throws ProfessorException {
        return controladorProfessor.pesquisarAlunoCodigo(codigo);
    }

    public Aluno pesquisarAlunoCodigo(String codigo, String cpf) throws DiretorException {
        return controladorDiretor.pesquisarAlunoCodigo(codigo, cpf);
    }

    //OVERLOAD
    public Professor pesquisarProfessorCodigo(String codigo, String cpf) throws DiretorException {
        return controladorDiretor.pesquisarProfessorCodigo(codigo, cpf);
    }

    public Professor pesquisarProfessorCodigo(String codigo) throws AlunoException {
        return controladorAluno.pesquisarProfessorCodigo(codigo);
    }

    //OVERLOAD
    public void aumentarSalarioP(String codigo) throws DiretorException {
        controladorDiretor.aumentarSalarioP(codigo);
    }

    public void aumentarSalarioP(String codigo, double quantidade) throws DiretorException {
        controladorDiretor.aumentarSalarioP(codigo, quantidade);
    }

    @Override
    public void trocarProfessor(String codigo, Professor novoProfessor) throws DiretorException {
        controladorDiretor.trocarProfessor(codigo, novoProfessor);
    }

    //OVERLOAD
    public void removerTrabalho(String codigo) throws ProfessorException {
        controladorProfessor.removerTrabalho(codigo);
    }

    public void removerTrabalho(int prazo) throws ProfessorException {
        controladorProfessor.removerTrabalho(prazo);
    }

    @Override
    public void inserirProfessor(Professor p) throws DiretorException {
        ControladorDiretor.getInstancia().inserirProfessor(p);
    }

    @Override
    public void removerProfessorCodigo(String codigo) throws DiretorException {
        controladorDiretor.removerProfessorCodigo(codigo);
    }

    @Override
    public void alterarNotas(String codigo, double nota, int unidade, int materia) throws ProfessorException {
        controladorProfessor.alterarNotas(codigo, nota, unidade, materia);

    }

    @Override
    public void mandarTrabalho(Trabalho trabalho) throws ProfessorException {
        controladorProfessor.mandarTrabalho(trabalho);
    }

    @Override
    public Boletim checarNotas(int materia, String codigo) throws AlunoException {
        return controladorAluno.checarNotas(materia, codigo);
    }

    @Override
    public Trabalho mostrarTrabalhos(String codigo) throws AlunoException, ProfessorException {
        return controladorAluno.mostrarTrabalhos(codigo);
    }

    @Override
    public int alugarSala(int codigo) throws SalaException {
        return controladorSala.alugarSala(codigo);
    }

    public void inserirDiretor(Diretor diretor) throws DonoException {
        controladorDono.inserirDiretor(diretor);
    }

    public void removerDiretorCodigo(String codigo) throws DonoException {
        controladorDono.removerDiretorCodigo(codigo);
    }

    @Override
    public void substituirDiretor(String codigo, Diretor novoDiretor) throws DonoException {
        controladorDono.substituirDiretor(codigo, novoDiretor);
    }


    @Override
    public void removerEnderecoP(String codigo) throws DiretorException {
        controladorDiretor.removerEnderecoP(codigo);
    }

    public void removerEnderecoD(String codigo) throws DonoException {
        controladorDono.removerEnderecoD(codigo);
    }

    @Override
    public Diretor pesquisarDiretorCodigo(String codigo, String cpf) throws DonoException {
        return controladorDono.pesquisarDiretorCodigo(codigo, cpf);
    }

    @Override
    public void trocarEndD(String codigo, Endereco endereco) throws DonoException {
        controladorDono.trocarEndD(codigo, endereco);
    }

    public void removerEnderecoA(String codigo) throws DiretorException {
        controladorDiretor.removerEnderecoA(codigo);
    }

    @Override
    public void trocarEnderecoA(String codigo, Endereco endereco) throws DiretorException {
        controladorDiretor.trocarEnderecoA(codigo, endereco);
    }

    public void trocarEnderecoP(String codigo, Endereco endereco) throws DiretorException {
        controladorDiretor.trocarEnderecoP(codigo, endereco);
    }

    public void substituirT(Trabalho t) throws ProfessorException {
        controladorProfessor.substituirT(t);
    }

    public void inserirEnderecoDiretor(Endereco endereco, String codigo) throws DonoException {
        controladorDono.inserirEnderecoDiretor(endereco, codigo);
    }

    @Override
    public void AtualizarSalarioDiretor(String codigo, Double novoSalario) throws DonoException {
        controladorDono.AtualizarSalarioDiretor(codigo, novoSalario);
    }

    public void aumentarSalarioD(String codigo) throws DonoException {
        controladorDono.aumentarSalarioD(codigo);
    }

    public void inserirEnderecoProfessor(Endereco endereco, String codigo) throws DiretorException {
        controladorDiretor.inserirEnderecoProfessor(endereco, codigo);
    }

    public void inserirEnderecoAluno(Endereco endereco, String codigo) throws DiretorException {
        controladorDiretor.inserirEnderecoAluno(endereco, codigo);
    }

    public void passarAlunosAno() {
        controladorProfessor.passarAlunosAno();
    }

    public void devolverSala(int codigo) throws SalaException {
        controladorSala.devolverSala(codigo);
    }
}

