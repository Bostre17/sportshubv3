package beans;

import java.time.LocalDateTime;

public class Allenamento extends Impegno{
    private String tipologia;
    private String titolo;
    private String idRichedente;
    public Allenamento(String idImpegno, String nomeSquadra, LocalDateTime inizio, LocalDateTime fine, String tipologia,
            String titolo, String idRichedente) {
        super(idImpegno, nomeSquadra, inizio, fine);
        this.tipologia = tipologia;
        this.titolo = titolo;
        this.idRichedente = idRichedente;
    }
    public String getTipologia() {
        return tipologia;
    }
    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }
    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public String getIdRichedente() {
        return idRichedente;
    }
    public void setIdRichedente(String idRichedente) {
        this.idRichedente = idRichedente;
    }
    
}
