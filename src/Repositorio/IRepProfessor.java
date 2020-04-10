package Repositorio;

import Modelo.Endereco;
import Modelo.Professor;

public interface IRepProfessor {

    void inserirProfessor(Professor p);

    Professor pesquisarProfessorCodigo(String codigo);

    Professor pesquisarProfessorCodigo(String codigo, String cpf);

    boolean existeProfessor(String codigo);

    void removerProfessorCodigo(String codigo);

    void aumentarSalario(String codigo);

    void aumentarSalario(String codigo, double quantidade);

    void trocarProfessor(String codigo, Professor novoProfessor);

    void removerEnderecoP(String codigo);

    boolean trocarEnderecoP(String codigo, Endereco endereco);

    boolean inserirEnderecoProfessor(Endereco endereco, String codigo);
}
