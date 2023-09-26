package beans;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

public class Partita extends Impegno {
    private int punteggioCasa;
    private int punteggioOspiti;
    private List<Statistica> stats;
    private String avversario;
    private String competizione;
    private List<Integer> quarti;
	private HttpSession session;
    

    public Partita(String idImpegno, String nomeSquadra, LocalDateTime inizio, LocalDateTime fine, String avversario, String competizione) {
        super(idImpegno, nomeSquadra, inizio, fine);
        this.avversario = avversario;
        this.competizione = competizione;
    }
    public int getPunteggioCasa() {
        return punteggioCasa;
    }
    public int getPunteggioOspiti() {
        return punteggioOspiti;
    }
    public List<Statistica> getStats() {
        return stats;
    }
    public String getAvversario() {
        return avversario;
    }
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	public String getCompetizione() {
		return competizione;
	}
	public void setCompetizione(String competizione) {
		this.competizione = competizione;
	}
	public List<Integer> getQuarti() {
		return quarti;
	}
	public void setQuarti(List<Integer> quarti) {
		this.quarti = quarti;
	}
	public void setPunteggioCasa(int punteggioCasa) {
		this.punteggioCasa = punteggioCasa;
	}
	public void setPunteggioOspiti(int punteggioOspiti) {
		this.punteggioOspiti = punteggioOspiti;
	}
	public void setStats(List<Statistica> stats) {
		this.stats = stats;
	}
	public void setAvversario(String avversario) {
		this.avversario = avversario;
	}
	@Override
	public String toString() {
		return "Partita [punteggioCasa=" + punteggioCasa + ", punteggioOspiti=" + punteggioOspiti + ", stats=" + stats
				+ ", avversario=" + avversario + ", competizione=" + competizione + ", quarti=" + quarti + ", session="
				+ session + "]";
	}

    
}
