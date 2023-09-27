package beans;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

public class Allenamento extends Impegno{
    
    private String titolo;
    private String idRichedente;
	private HttpSession session;
	
    public Allenamento(String idImpegno, String nomeSquadra, LocalDateTime inizio, LocalDateTime fine, 
            String titolo, String idRichedente) {
        super("A",idImpegno, nomeSquadra, inizio, fine);
        
        this.titolo = titolo;
        this.idRichedente = idRichedente;
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
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
    
}
