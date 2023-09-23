package beans;

public abstract class Membro extends Utente{
	
	
	String nome;
	String cognome;
	
	public Membro(String username, String id, String nome, String cognome) {
		super(username, id);
		this.nome = nome;
		this.cognome = cognome;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	@Override
	public String toString() {
		return "Membro [nome=" + nome + ", cognome=" + cognome + "]";
	}
	
}
