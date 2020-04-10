package Repositorio;

import Modelo.Aluno;
import Modelo.Endereco;

public interface IRepAluno {

    void inserirAluno(Aluno a);

    Aluno pesquisarAlunoCodigo(String codigo);

    Aluno pesquisarAlunoCodigo(String codigo, String cpf);

    void removerAlunoCodigo(String codigo);

    boolean existeAluno(String codigo);

    void alterarNotas(String codigo, double nota, int unidade, int materia);

    Aluno checarNotas(String codigo);

    void removerEnderecoA(String codigo);

    boolean trocarEnderecoA(String codigo, Endereco endereco);

    boolean inserirEnderecoAluno(Endereco endereco, String codigo);

    void passarAlunosAno();

    boolean checarSerie(Aluno a);
}
