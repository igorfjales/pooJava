package UI;

import Constants.Constantes;
import Controlador.Fachada;
import Modelo.Diretor;
import Modelo.Endereco;
import excecoes.DonoException;

import java.util.Scanner;

public class UiDono {

    static Scanner s = new Scanner(System.in);

    void MenuDono() {
        int opcao;

        do {
            System.out.println("Digite: \n1: Para Inserir Diretor. \n2: Para Remover Diretor. " +
                    "\n3: Para pesquisar Diretor. \n4: Para Substituir Diretor." +
                    "\n5: Remover endereço de um diretor. \n6: Alterar endereço do Diretor. " +
                    "\n7: Para aualizar salário do Diretor.\n8: Aumentar salário do diretor em 10% " +
                    "\n9: Inserir o endereço de um diretor.  \n0: Para sair.");
            opcao = s.nextInt();

            switch (opcao) {

                case 1:
                    InserirDiretor();
                    break;
                case 2:
                    RemoverDiretorCodigo();
                    break;
                case 3:
                    PesquisarDiretorCodigo();
                    break;
                case 4:
                    SubstituirDiretor();
                    break;
                case 5:
                    RemoverEnderecoDiretor();
                    break;
                case 6:
                    TrocarEndD();
                    break;
                case 7:
                    AtualizarSalarioDiretorQnt();
                    break;
                case 8:
                    AtualizarSalarioDiretor();
                    break;
                case 9:
                    InserirEnderecoDiretor();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Digite uma opção valida.");
                    break;
            }
        } while (opcao != 0);
    }

    private void AtualizarSalarioDiretor() {
        try {
            System.out.println("Insira o código do professor para aumentar seu salário: ");
            String codigo = s.next();
            Fachada.getInstancia().aumentarSalarioD(codigo);
            System.out.println("Salário aumentado com Sucesso. \n");
        } catch (DonoException e) {
            System.out.println(e.getMessage());
        }
    }


    private void AtualizarSalarioDiretorQnt() {
        try {
            System.out.println("Digite o codigo do Diretor para atualizar o seu salário: ");
            String codigo = s.next();

            System.out.println("Digite o novo salário do Diretor: ");
            double novoSalário = s.nextDouble();

            Fachada.getInstancia().AtualizarSalarioDiretor(codigo, novoSalário);
            System.out.println("Salário atualizado com sucesso. \n");
        } catch (DonoException e) {
            System.out.println(e.getMessage());
        }
    }

    private void TrocarEndD() {
        try {
            System.out.println("Digite o codigo do Diretor que voce deseja trocar o endereço.");
            String codigo = s.next();
            Endereco end = new Endereco();

            System.out.println("Digite o novo endereço: \n");

            System.out.println("Digite o nome do bairro: ");
            end.setBairro(s.next());
            System.out.println("Digite o nome da rua: ");
            end.setRua(s.next());
            System.out.println("Digite o número");
            end.setNumero(s.next());
            System.out.println("Digite o complemento");
            end.setComplemento(s.next());
            System.out.println("Insira o CEP");
            end.setCep(s.next());

            Fachada.getInstancia().trocarEndD(codigo, end);
            System.out.println("Endereço atualizado com sucesso. \n");
        } catch (DonoException e) {
            System.out.println(e.getMessage());
        }

    }

    private void PesquisarDiretorCodigo() {
        try {
            System.out.println("Insira o código do Diretor: ");
            String codigo = s.next();
            System.out.println("Insira o cpf do Diretor: ");
            String cpf = s.next();
            Diretor d;
            d = Fachada.getInstancia().pesquisarDiretorCodigo(codigo, cpf);
            System.out.println("Nome: " + d.getNome());
            System.out.println("Idade: " + d.getIdade());
            System.out.println("Sexo: " + d.getSexo());
            System.out.println("Salário : " + d.getSalario());
            System.out.println("CPF: " + d.getCpf());
            System.out.println("Carga horária: " + d.getCargaH() + "\n");
            System.out.println("Endereço: " + "\n");
            if (d.getEndereco() != null) {
                System.out.println("Rua: " + d.getEndereco().getRua());
                System.out.println("Bairro: " + d.getEndereco().getBairro());
                System.out.println("Numero: " + d.getEndereco().getNumero());
                System.out.println("Complemento: " + d.getEndereco().getComplemento());
                System.out.println("Cep: " + d.getEndereco().getCep() + "\n");
            } else {
                System.out.println("Endereço não cadastrado. \n");
            }

        } catch (DonoException e) {
            System.out.println(e.getMessage());
        }
    }

    private void InserirEnderecoDiretor() {
        try {
            System.out.println("Digite o codigo do Diretor que voce deseja inserir o endereço.");
            String codigo = s.next();
            Endereco end = new Endereco();

            System.out.println("Digite o novo endereço: \n");

            System.out.println("Digite o nome do bairro: ");
            end.setBairro(s.next());
            System.out.println("Digite o nome da rua: ");
            end.setRua(s.next());
            System.out.println("Digite o número");
            end.setNumero(s.next());
            System.out.println("Digite o complemento");
            end.setComplemento(s.next());
            System.out.println("Insira o CEP");
            end.setCep(s.next());

            Fachada.getInstancia().inserirEnderecoDiretor(end, codigo);
            System.out.println("Enderço inserido com sucesso. \n");

        } catch (DonoException e) {
            System.out.println(e.getMessage());
        }
    }

    private void RemoverEnderecoDiretor() {
        try {
            System.out.println("Digite o codigo do Diretor no qual deseja remover o endereço: ");
            String codigo = s.next();
            Fachada.getInstancia().removerEnderecoD(codigo);
            System.out.println("Endereço removido com sucesso. \n");
        } catch (DonoException e) {
            System.out.println(e.getMessage());
        }
    }

    private void SubstituirDiretor() {
        try {

            System.out.println("Digite o codigo do diretor para que ele seja substituído: ");
            String codigo = s.next();

            Diretor novoDiretor = new Diretor();
            Endereco end = new Endereco();
            System.out.println("Digite as informações do novo Diretor. \n");

            System.out.println("Digite o nome: ");
            novoDiretor.setNome(s.next());

            System.out.println("Digite a idade: ");
            novoDiretor.setIdade(s.nextInt());

            System.out.println("Digite o sexo: ");
            novoDiretor.setSexo(s.next());

            System.out.println("Digite o cpf: ");
            novoDiretor.setCpf(s.next());
            novoDiretor.setSalario(Constantes.salarioDiretor);
            System.out.println("Digite a carga horária em horas: ");
            novoDiretor.setCargaH(s.nextInt());

            System.out.println("Digite o codigo do diretor: ");
            novoDiretor.setCodigo(s.next());

            System.out.println("Endereço: \n");

            System.out.println("Digite a rua: ");
            end.setRua(s.next());

            System.out.println("Digite o bairro: ");
            end.setBairro(s.next());

            System.out.println("Digite o número: ");
            end.setNumero(s.next());

            System.out.println("Digite o CEP: ");
            end.setCep(s.next());

            System.out.println("Digite o complemento: ");
            end.setComplemento(s.next());

            novoDiretor.setEndereco(end);


            Fachada.getInstancia().substituirDiretor(codigo, novoDiretor);
            System.out.println("Diretor substituído com sucesso. \n");
        } catch (DonoException e) {
            System.out.println(e.getMessage());
        }
    }

    private void RemoverDiretorCodigo() {
        String codigo;
        System.out.println("Digite o código do Diretor para ser removido: ");
        codigo = s.next();
        try {
            Fachada.getInstancia().removerDiretorCodigo(codigo);
            System.out.println("Diretor removido com sucesso. \n");
        } catch (DonoException e) {
            System.out.println(e.getMessage());
        }
    }


    Diretor InserirDiretor() {
        Diretor diretor = new Diretor();
        Endereco end = new Endereco();
        try {

            System.out.println("Digite o nome: ");
            diretor.setNome(s.next());

            System.out.println("Digite a idade: ");
            diretor.setIdade(s.nextInt());

            System.out.println("Digite o sexo: ");
            diretor.setSexo(s.next());

            System.out.println("Digite o cpf: ");
            diretor.setCpf(s.next());


            diretor.setSalario(Constantes.salarioDiretor);

            System.out.println("Digite a carga horária em horas: ");
            diretor.setCargaH(s.nextInt());

            System.out.println("Digite o codigo do diretor: ");
            diretor.setCodigo(s.next());

            System.out.println("Endereço: \n");

            System.out.println("Digite a rua: ");
            end.setRua(s.next());

            System.out.println("Digite o bairro: ");
            end.setBairro(s.next());

            System.out.println("Digite o número: ");
            end.setNumero(s.next());

            System.out.println("Digite o CEP: ");
            end.setCep(s.next());

            System.out.println("Digite o complemento: ");
            end.setComplemento(s.next());

            diretor.setEndereco(end);


            Fachada.getInstancia().inserirDiretor(diretor);
            System.out.println("Diretor inserido com sucesso. \n ");
        } catch (DonoException e) {
            System.out.println(e.getMessage());
        }

        return diretor;
    }
}
