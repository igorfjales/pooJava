package Controlador;

import Modelo.Aluno;
import Modelo.Endereco;
import Modelo.Professor;
import excecoes.DiretorException;


interface IControladorDiretor {

    void inserirAluno(Aluno a) throws DiretorException;

    void removerAlunoCodigo(String codigo) throws DiretorException;

    Aluno pesquisarAlunoCodigo(String codigo, String cpf) throws DiretorException;

    void inserirProfessor(Professor p) throws DiretorException;

    Professor pesquisarProfessorCodigo(String codigo, String cpf) throws DiretorException;

    void removerProfessorCodigo(String codigo) throws DiretorException;

    void aumentarSalarioP(String codigo) throws DiretorException;

    void aumentarSalarioP(String codigo, double quantidade) throws DiretorException;

    void trocarProfessor(String codigo, Professor novoProfessor) throws DiretorException;

    void removerEnderecoP(String codigo) throws DiretorException;

    void removerEnderecoA(String codigo) throws DiretorException;

    void trocarEnderecoA(String codigo, Endereco endereco) throws DiretorException;

    void trocarEnderecoP(String codigo, Endereco endereco) throws DiretorException;

    void inserirEnderecoAluno(Endereco endereco, String codigo) throws DiretorException;

    void inserirEnderecoProfessor(Endereco endereco, String codigo) throws DiretorException;
}
