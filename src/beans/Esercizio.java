package beans;

import java.io.Serializable;

public class Esercizio{
    /**
	 * 
	 */
	private String nome;
    private int numeroSerie;
    private int numeroRipetizioni;
    private int difficolta;
    private int recupero;
    private String urlImmagine;
    private String descrizione;

    public Esercizio()  {
    }

    public Esercizio(String nome, int numeroSerie, int numeroRipetizioni, int difficolta, String urlImmagine, String descrizione,int Recupero) {
        this.nome = nome;
        this.numeroSerie = numeroSerie;
        this.numeroRipetizioni = numeroRipetizioni;
        this.difficolta = difficolta;
        this.urlImmagine = urlImmagine;
        this.descrizione = descrizione;
        this.recupero=Recupero;
    }

    // Metodi getter e setter

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public int getNumeroRipetizioni() {
        return numeroRipetizioni;
    }

    public void setNumeroRipetizioni(int numeroRipetizioni) {
        this.numeroRipetizioni = numeroRipetizioni;
    }

    public int getDifficolta() {
        return difficolta;
    }

    public void setDifficolta(int difficolta) {
        this.difficolta = difficolta;
    }
    public int getRecupero() {
        return recupero;
    }

    public void setRecupero(int Recupero) {
        this.recupero = Recupero;
    }
    public String getUrlImmagine() {
        return urlImmagine;
    }

    public void setUrlImmagine(String urlImmagine) {
        this.urlImmagine = urlImmagine;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
