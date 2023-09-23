package beans;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public class Squadra {
	
	private String id;
	private String nome;
	private ArrayList<String> allenatori;
	private ArrayList<String> giocatori;
	private Calendario calendario;
	private HttpSession session;
	
	public Squadra(String id, String nome, ArrayList<String> allenatori, ArrayList<String> giocatori,
			Calendario calendario) {
		super();
		this.id = id;
		this.nome = nome;
		this.allenatori = allenatori;
		this.giocatori = giocatori;
		this.calendario = calendario;
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

	public ArrayList<String> getAllenatori() {
		return allenatori;
	}

	public void setAllenatori(ArrayList<String> allenatori) {
		this.allenatori = allenatori;
	}

	public ArrayList<String> getGiocatori() {
		return giocatori;
	}

	public void setGiocatori(ArrayList<String> giocatori) {
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

	@Override
	public String toString() {
		return "Squadra [id=" + id + ", nome=" + nome + ", allenatori=" + allenatori + ", giocatori=" + giocatori
				+ ", session=" + session + "]";
	}
	
}
