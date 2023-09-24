package beans;

public class Giocatore extends Membro{
	
	private int altezza;
	private double puntiPartita;
	private double assistPartita;
	private double rimbalziPartita;
	
	public Giocatore(String username, String id, String nome, String cognome,int altezza) {
		super(username, id, nome, cognome);
		this.altezza = altezza;
	}

	public int getAltezza() {
		return altezza;
	}

	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}

	public double getPuntiPartita() {
		return puntiPartita;
	}

	public void setPuntiPartita(double puntiPartita) {
		this.puntiPartita = puntiPartita;
	}

	public double getAssistPartita() {
		return assistPartita;
	}

	public void setAssistPartita(double assistPartita) {
		this.assistPartita = assistPartita;
	}

	public double getRimbalziPartita() {
		return rimbalziPartita;
	}

	public void setRimbalziPartita(double rimbalziPartita) {
		this.rimbalziPartita = rimbalziPartita;
	}
	
	

}
