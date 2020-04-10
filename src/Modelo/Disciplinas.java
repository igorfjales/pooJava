package Modelo;


public abstract class Disciplinas {

    private Double[] nota = new Double[3];
    private Double media;
    private boolean aprovado;

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public Double[] getNota() {
        return nota;
    }

    public Double getNota1() {
        return nota[0];
    }

    public void setNota1(Double nota) {
        this.nota[0] = nota;
    }

    public Double getNota2() {
        return nota[1];
    }

    public void setNota2(Double nota) {
        this.nota[1] = nota;
    }

    public Double getNota3() {
        return nota[2];
    }

    public void setNota3(Double nota) {
        this.nota[2] = nota;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }
}
