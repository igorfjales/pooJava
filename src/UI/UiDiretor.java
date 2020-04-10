package UI;

import Constants.Constantes;
import Controlador.Fachada;
import Modelo.Aluno;
import Modelo.Endereco;
import Modelo.Professor;
import excecoes.DiretorException;

import java.util.Scanner;

class UiDiretor {
    private static Scanner s = new Scanner(System.in);

    void MenuDiretor() {
        int menu;
        do {
            System.out.println("Digite: \n1: Para inserir aluno. \n2: Para remover aluno pelo código. " +
                    "\n3: Para Pesquisar aluno pelo código e cpf." +
                    " \n4: Para inserir Professor. \n5: Para pesquisar professores pelo codigo e cpf. \n6: " +
                    "Para remover professor pelo codigo.\n7: Aumentar salário de um professor em 10%." +
                    "\n8: Aumentar Salário com quantidade.\n9: Trocar professor.\n10: Remover endereço de um aluno.\n11" +
                    ": Remover endereço de um professor.\n12: Alterar endereço de um professor.\n13:" +
                    " Alterar endereço de um Aluno.\n14: Inserir endereço de um aluno.\n15: Inserir endereço de um professor.\n0: Sair. ");
            menu = s.nextInt();

            switch (menu) {
                case 1:
                    InserirAluno();
                    break;
                case 2:
                    RemoverAlunoCodigo();
                    break;
                case 3:
                    PesquisarAlunoCodigo();
                    break;
                case 4:
                    InserirProfessor();
                    break;
                case 5:
                    PesquisarProfessorCodigo();
                    break;
                case 6:
                    RemoverProfessorCodigo();
                    break;
                case 7:
                    AumentarSalario();
                    break;
                case 8:
                    AumentarSalarioQnt();
                    break;
                case 9:
                    TrocarProfessor();
                    break;
                case 10:
                    RemoverEnderecoAluno();
                    break;
                case 11:
                    RemoverEnderecoProfessor();
                    break;
                case 12:
                    TrocarEndP();
                    break;
                case 13:
                    TrocarEndA();
                    break;
                case 14:
                    inserirEnderecoAluno();
                    break;
                case 15:
                    inserirEnderecoProfessor();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Digite uma opção válida:  ");
                    break;
            }
        } while (menu != 0);
    }

    private void TrocarEndA() {
        try {
            System.out.println("Digite o codigo do Aluno que voce deseja trocar o endereço.");
            String codigo = s.next();
            Endereco end = new Endereco();
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

            Fachada.getInstancia().trocarEnderecoA(codigo, end);
            System.out.println("Endereço alterado com sucesso. \n");
        } catch (DiretorException e) {
            System.out.println(e.getMessage());
        }
    }

    private void TrocarEndP() {
        try {
            System.out.println("Digite o codigo do Professor que voce deseja trocar o endereço.");
            String codigo = s.next();
            Endereco end = new Endereco();
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

            Fachada.getInstancia().trocarEnderecoP(codigo, end);
            System.out.println("Endereço alterado com sucesso. \n");
        } catch (DiretorException e) {
            System.out.println(e.getMessage());
        }
    }

    private void RemoverEnderecoAluno() {
        try {
            System.out.println("Digite o codigo do Aluno no qual deseja remover o endereço: ");
            String codigo = s.next();

            Fachada.getInstancia().removerEnderecoA(codigo);
            System.out.println("Endereço removido com sucesso. \n");
        } catch (DiretorException e) {
            System.out.println(e.getMessage());
        }
    }

    private void RemoverEnderecoProfessor() {
        try {
            System.out.println("Digite o codigo do Professor no qual deseja remover o endereço: ");
            String codigo = s.next();
            Fachada.getInstancia().removerEnderecoP(codigo);
            System.out.println("Endereço removido com sucesso. \n");
        } catch (DiretorException e) {
            System.out.println(e.getMessage());
        }
    }

    private void TrocarProfessor() {
        try {

            System.out.println("Digite o codigo do Professor para que ele seja substituído: ");
            String codigo = s.next();

            Professor novoProfessor = new Professor();
            Endereco end = new Endereco();
            System.out.println("Digite as informações do Professor que irá substituir. \n");

            System.out.println("Digite o nome: ");
            novoProfessor.setNome(s.next());

            System.out.println("Digite a idade: ");
            novoProfessor.setIdade(s.nextInt());

            System.out.println("Digite o sexo: ");
            novoProfessor.setSexo(s.next());

            System.out.println("Digite o cpf: ");
            novoProfessor.setCpf(s.next());

            System.out.println("Digite a disciplina de ensino: ");
            novoProfessor.setDisciplina(s.next());

            novoProfessor.setSalario(Constantes.salario);

            System.out.println("Digite a carga horária em horas: ");
            novoProfessor.setCargaH(s.nextInt());

            System.out.println("Digite o codigo do diretor: ");
            novoProfessor.setCodigo(s.next());

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

            novoProfessor.setEndereco(end);


            Fachada.getInstancia().trocarProfessor(codigo, novoProfessor);
            System.out.println("Professor substituído com sucesso. \n");
        } catch (DiretorException e) {
            System.out.println(e.getMessage());
        }
    }

    private void RemoverProfessorCodigo() {
        String codigo;
        System.out.println("Digite o código do professor para ser removido: ");
        codigo = s.next();

        try {
            Fachada.getInstancia().removerProfessorCodigo(codigo);
            System.out.println("Professor removido com sucesso. \n ");
        } catch (DiretorException e) {
            System.out.println(e.getMessage());

        }
    }

    private void PesquisarProfessorCodigo() {
        try {
            System.out.println("Insira o código do professor: ");
            String codigo = s.next();
            System.out.println("Insira o cpf do professor: ");
            String cpf = s.next();
            Professor p;
            p = Fachada.getInstancia().pesquisarProfessorCodigo(codigo, cpf);
            System.out.println(p.getCodigo());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Idade: " + p.getIdade());
            System.out.println("Sexo: " + p.getSexo());
            System.out.println("Disciplina de ensino: " + p.getDisciplina());
            System.out.println("Salário : " + p.getSalario());
            System.out.println("CPF: " + p.getCpf());
            System.out.println("Carga horária: " + p.getCargaH() + "\n");
            System.out.println("Endereço: " + "\n");
            if (p.getEndereco() != null) {
                System.out.println("Rua: " + p.getEndereco().getRua());
                System.out.println("Bairro: " + p.getEndereco().getBairro());
                System.out.println("Numero: " + p.getEndereco().getNumero());
                System.out.println("Complemento: " + p.getEndereco().getComplemento());
                System.out.println("Cep: " + p.getEndereco().getCep() + "\n");
            } else {
                System.out.println("Endereço não cadastrado. \n");
            }
        } catch (DiretorException e) {
            System.out.println(e.getMessage());
        }
    }

    private void RemoverAlunoCodigo() {
        String codigo;
        System.out.println("Digite o código do aluno para ser removido: ");
        codigo = s.next();
        try {
            Fachada.getInstancia().removerAlunoCodigo(codigo);
            System.out.println("Aluno removido com sucesso. \n");
        } catch (DiretorException e) {
            System.out.println(e.getMessage());
        }
    }

    private void InserirAluno() {
        Aluno a = new Aluno();
        Endereco end = new Endereco();
        System.out.println("Digite o nome do aluno: ");
        a.setNome(s.next());

        System.out.println("Digite a idade do aluno: ");
        a.setIdade(s.nextInt());

        System.out.println("Digite o gênero do aluno: ");
        a.setSexo(s.next());

        System.out.println("Digite o CPF do aluno: ");
        a.setCpf(s.next());

        System.out.println("Digite a série que o aluno vai cursar no Ensino Médio: ");
        a.setSerie(s.nextInt());

        System.out.println("Digite o código que o aluno usará: ");
        a.setCodigo(s.next());

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

        a.setEndereco(end);

        try {
            Fachada.getInstancia().inserirAluno(a);
            System.out.println("Alundo inserido com sucesso. \n");
        } catch (DiretorException e) {
            System.out.println(e.getMessage());
        }
    }

    private void InserirProfessor() {
        try {

            Professor p = new Professor();
            Endereco end = new Endereco();
            System.out.println("Digite o nome do professor: ");
            p.setNome(s.next());

            System.out.println("Digite o sexo: ");
            p.setSexo(s.next());

            System.out.println("Digite a idade: ");
            p.setIdade(s.nextInt());

            System.out.println("Digite o CPF: ");
            p.setCpf(s.next());

            System.out.println("Digite a sua disciplina de ensino: ");
            p.setDisciplina(s.next());

            System.out.println("Digite sua carga horária em horas: ");
            p.setCargaH(s.nextInt());

            System.out.println("Digite o código que o professor utilizará: ");
            p.setCodigo(s.next());
            p.setSalario(Constantes.salario);

            System.out.println("Digite o nome do bairro: ");
            end.setBairro(s.next());
            System.out.println("Digite o nome da rua: ");
            end.setRua(s.next());
            System.out.println("Digite o número: ");
            end.setNumero(s.next());
            System.out.println("Digite o complemento: ");
            end.setComplemento(s.next());
            System.out.println("Insira o CEP: ");
            end.setCep(s.next());

            p.setEndereco(end);

            Fachada.getInstancia().inserirProfessor(p);
            System.out.println("Professor inserido com sucesso. \n");
        } catch (DiretorException e) {
            System.out.println(e.getMessage());
        }


    }

    private void PesquisarAlunoCodigo() {
        try {
            System.out.println("Insira o código: ");
            String codigo = s.next();
            System.out.println("Insira o cpf: ");
            Aluno a;
            a = Fachada.getInstancia().pesquisarAlunoCodigo(codigo, s.next());
            System.out.println("Codigo: " + a.getCodigo());
            System.out.println("Nome: " + a.getNome());
            System.out.println("Idade: " + a.getIdade());
            System.out.println("Sexo: " + a.getSexo());
            System.out.println("Serie: " + a.getSerie());
            System.out.println("CPF: " + a.getCpf() + "\n");
            System.out.println("Endereço: " + "\n");
            if (a.getEndereco() != null) {
                System.out.println("Rua: " + a.getEndereco().getRua());
                System.out.println("Bairro: " + a.getEndereco().getBairro());
                System.out.println("Numero: " + a.getEndereco().getNumero());
                System.out.println("Complemento: " + a.getEndereco().getComplemento());
                System.out.println("Cep: " + a.getEndereco().getCep() + "\n");
            } else {
                System.out.println("Endereço não cadastrado. \n");
            }
        } catch (DiretorException e) {
            System.out.println(e.getMessage());
        }
    }

    private void AumentarSalario() {
        try {
            System.out.println("Insira o código do professor para aumentar seu salário: ");
            String codigo = s.next();
            Fachada.getInstancia().aumentarSalarioP(codigo);
            System.out.println("Salário aumentado com Sucesso. \n");
        } catch (DiretorException e) {
            System.out.println(e.getMessage());
        }
    }

    private void AumentarSalarioQnt() {
        try {
            System.out.println("Insira o código do professor para aumentar seu salário: ");
            String codigo = s.next();
            System.out.println("Insira a quantidade desejada: ");
            double quantidade = s.nextDouble();
            Fachada.getInstancia().aumentarSalarioP(codigo, quantidade);
            System.out.println("Salário aumentado com sucesso. \n");
        } catch (DiretorException e) {
            System.out.println(e.getMessage());
        }
    }

    private void inserirEnderecoProfessor() {
        try {
            System.out.println("Digite o codigo do professor que voce deseja inserir o endereço.");
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

            Fachada.getInstancia().inserirEnderecoProfessor(end, codigo);
            System.out.println("Endereço inserido com sucesso. \n");
        } catch (DiretorException e) {
            System.out.println(e.getMessage());
        }
    }

    private void inserirEnderecoAluno() {
        try {
            System.out.println("Digite o codigo do aluno que voce deseja inserir o endereço.");
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

            Fachada.getInstancia().inserirEnderecoAluno(end, codigo);
            System.out.println("Endereço inserido com sucesso. \n");
        } catch (DiretorException e) {
            System.out.println(e.getMessage());
        }
    }
}
