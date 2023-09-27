package beans;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public class Squadra {
	
	private String id;
	private String nome;
	private ArrayList<Allenatore> allenatori;
	private ArrayList<Giocatore> giocatori;
	private Calendario calendario;
	private HttpSession session;
	
	public Squadra(String nome, String id) {
		super();
		this.id = id;
		this.nome = nome;
		this.calendario = new Calendario();
		this.allenatori= new ArrayList<Allenatore>();
		this.giocatori= new ArrayList<Giocatore>();
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Allenatore> getAllenatori() {
		return allenatori;
	}

	public void setAllenatori(ArrayList<Allenatore> allenatori) {
		this.allenatori = allenatori;
	}

	public ArrayList<Giocatore> getGiocatori() {
		return giocatori;
	}

	public void setGiocatori(ArrayList<Giocatore> giocatori) {
		this.giocatori = giocatori;
	}

	public Calendario getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}
	
	public boolean aggiungiAllenatore(Allenatore a) {
		if(this.allenatori.size()==2)
			return false;
		
		this.allenatori.add(a);
		return true;
	}
	
	public boolean aggiungiGiocatore(Giocatore g) {
		if(this.giocatori.size()==21)
			return false;
		
		this.giocatori.add(g);
		return true;
	}
	
	public void eliminaGiocatore(Giocatore g) {
		this.giocatori.remove(g);
	}
	
	public void eliminaAllenatore(Allenatore a) {
		this.allenatori.remove(a);
	}
	
	public boolean esisteAllenatore(String idAllenatore) {
		for(Allenatore a: this.getAllenatori())
		{
			if(a.getId().equals(idAllenatore))
				return true;
		}
		return false;
	}
	
	public boolean esisteImpegno(String idImpegno) {
		//System.out.println(idImpegno);
		for(Impegno i: this.calendario.getImpegni())
		{
			System.out.println(i.getIdImpegno()+" trovato");
			if(i.getIdImpegno().equals(idImpegno))
				return true;
		}
		
		return false;
	}

	@Override
	public String toString() {
		return "Squadra [id=" + id + ", nome=" + nome + ", allenatori=" + allenatori + ", giocatori=" + giocatori
				+ ", session=" + session + "]";
	}
	
}
