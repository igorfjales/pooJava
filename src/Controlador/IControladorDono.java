package Controlador;

import Modelo.Diretor;
import Modelo.Endereco;
import excecoes.DonoException;

public interface IControladorDono {

    void inserirDiretor(Diretor diretor) throws DonoException;

    void removerDiretorCodigo(String diretor) throws DonoException;

    void substituirDiretor(String codigo, Diretor novoDiretor) throws DonoException;

    void removerEnderecoD(String codigo) throws DonoException;

    Diretor pesquisarDiretorCodigo(String codigo, String cpf) throws DonoException;

    void trocarEndD(String codigo, Endereco endereco) throws DonoException;

    void inserirEnderecoDiretor(Endereco endereco, String codigo) throws DonoException;

    void AtualizarSalarioDiretor(String codigo, Double novoSalario) throws DonoException;

    void aumentarSalarioD(String codigo) throws DonoException;
}
