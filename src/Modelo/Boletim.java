package Modelo;

public class Boletim {
    private Matematica matematica = new Matematica();
    private Portugues portugues = new Portugues();
    private Biologia biologia = new Biologia();
    private Fisica fisica = new Fisica();
    private Quimica quimica = new Quimica();

    public Matematica getMatematica() {
        return matematica;
    }

    public Portugues getPortugues() {
        return portugues;
    }


    public Biologia getBiologia() {
        return biologia;
    }


    public Fisica getFisica() {
        return fisica;
    }


    public Quimica getQuimica() {
        return quimica;
    }


}
