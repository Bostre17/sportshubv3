package beans;

import java.time.LocalDateTime;

public abstract class Impegno {
    private String idImpegno;
    private String nomeSquadra;
    private LocalDateTime inizio;
    private LocalDateTime fine;

    public Impegno(String idImpegno, String nomeSquadra, LocalDateTime inizio, LocalDateTime fine) {
        this.idImpegno = idImpegno;
        this.nomeSquadra = nomeSquadra;
        this.inizio = inizio;
        this.fine = fine;
    }
    
    public String getIdImpegno() {
        return idImpegno;
    }
    public void setIdImpegno(String idImpegno) {
        this.idImpegno = idImpegno;
    }
    public String getNomeSquadra() {
        return nomeSquadra;
    }
    public void setNomeSquadra(String nomeSquadra) {
        this.nomeSquadra = nomeSquadra;
    }
    public LocalDateTime getInizio() {
        return inizio;
    }
    public void setInizio(LocalDateTime inizio) {
        this.inizio = inizio;
    }
    public LocalDateTime getFine() {
        return fine;
    }
    public void setFine(LocalDateTime fine) {
        this.fine = fine;
    }


  
   

    
}
