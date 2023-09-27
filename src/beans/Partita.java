package beans;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class Partita extends Impegno {
    private int punteggioCasa;
    private int punteggioOspiti;
    private ArrayList<Statistica> stats;
    private String avversario;
    private String competizione;
    private ArrayList<Integer> quarti;
    private boolean partita_casa;
	private HttpSession session;
    

    public Partita(String idImpegno, String nomeSquadra, LocalDateTime inizio, LocalDateTime fine, String avversario, String competizione, boolean partita_casa) {
        super("P",idImpegno, nomeSquadra, inizio, fine);
        this.partita_casa = partita_casa;
        this.avversario = avversario;
        this.competizione = competizione;
        this.stats = new ArrayList<Statistica>();
        this.quarti = new ArrayList<Integer>();
    }
    public int getPunteggioCasa() {
        return punteggioCasa;
    }
    public int getPunteggioOspiti() {
        return punteggioOspiti;
    }
    public ArrayList<Statistica> getStats() {
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
	public ArrayList<Integer> getQuarti() {
		return quarti;
	}
	public void setQuarti(ArrayList<Integer> quarti) {
		this.quarti = quarti;
	}
	public void setPunteggioCasa(int punteggioCasa) {
		this.punteggioCasa = punteggioCasa;
	}
	public void setPunteggioOspiti(int punteggioOspiti) {
		this.punteggioOspiti = punteggioOspiti;
	}
	public void setStats(ArrayList<Statistica> stats) {
		this.stats = stats;
	}
	public void setAvversario(String avversario) {
		this.avversario = avversario;
	}
	@Override
	public String toString() {
		if(this.punteggioCasa!=0)
			return "Partita [punteggioCasa=" + punteggioCasa + ", punteggioOspiti=" + punteggioOspiti + ", avversario="
				   + avversario + ", competizione=" + competizione + ", inizio= "+super.getInizio() +", fine="+super.getFine() +"]";
		else
			return "Partita [avversario="+ avversario + ", competizione=" + competizione + ", inizio= "+super.getInizio() +", fine="+super.getFine() +"]";
			
	}
	public boolean isPartita_casa() {
		return partita_casa;
	}
	public void setPartita_casa(boolean partita_casa) {
		this.partita_casa = partita_casa;
	}
	

    
}
