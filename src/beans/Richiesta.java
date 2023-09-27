package beans;

import java.time.LocalDateTime;
import javax.servlet.http.HttpSession;

public class Richiesta {
	
	private String id;
	private String tipo;
	private String titolo;
	private LocalDateTime inizio;
	private LocalDateTime fine;
	private HttpSession session;
	private String idAllenatore;
	
	public Richiesta(String idAllenatore, String id, String tipo, String titolo, LocalDateTime inizio, LocalDateTime fine) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.titolo = titolo;
		this.inizio = inizio;
		this.fine = fine;
		this.idAllenatore=idAllenatore;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
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

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}
	

	public String getIdAllenatore() {
		return idAllenatore;
	}

	public void setIdAllenatore(String idAllenatore) {
		this.idAllenatore = idAllenatore;
	}

	@Override
	public String toString() {
		return "Richiesta [id=" + id + ", tipo=" + tipo + ", titolo=" + titolo + ", inizio=" + inizio + ", fine=" + fine
				+ "]";
	}
	
}