package beans;

import java.time.LocalDateTime;

public abstract class Impegno {
    private String idImpegno;
    private String nomeSquadra;
    private LocalDateTime inizio;
    private LocalDateTime fine;
    private String tipo;

    public Impegno(String tipo,String idImpegno, String nomeSquadra, LocalDateTime inizio, LocalDateTime fine) {
        this.idImpegno = idImpegno;
        this.nomeSquadra = nomeSquadra;
        this.inizio = inizio;
        this.fine = fine;
        this.tipo=tipo;
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

    
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Impegno [idImpegno=" + idImpegno + ", nomeSquadra=" + nomeSquadra + ", inizio=" + inizio + ", fine="
				+ fine + "]";
	}


  
   

    
}
