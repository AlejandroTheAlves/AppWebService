package br.com.opet.tmm.appwebservice;

/**
 * Created by Diego on 03/05/2017.
 */

public class Tempo {
    private String cidade;
    private double temperatura;
    private String clima;

    public Tempo() {
    }

    public Tempo(String cidade, double temperatura, String clima) {
        this.cidade = cidade;
        this.temperatura = temperatura;
        this.clima = clima;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }
}
