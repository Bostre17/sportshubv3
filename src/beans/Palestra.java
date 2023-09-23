package beans;

import javax.servlet.http.HttpSession;

public class Palestra {
	
	private String id;
	private String nome;
	private String indirizzo;
	private HttpSession session;
	
	public Palestra(String id, String nome, String indirizzo) {
		super();
		this.id = id;
		this.nome = nome;
		this.indirizzo = indirizzo;
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

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	@Override
	public String toString() {
		return "Palestra [id=" + id + ", nome=" + nome + ", indirizzo=" + indirizzo + "]";
	}
	
	
	
	
}