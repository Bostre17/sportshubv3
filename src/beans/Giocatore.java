package beans;

import javax.servlet.http.HttpSession;

public class Giocatore extends Membro{
	
	
	int altezza;
	double puntiPartita;
	double assistPartita;
	double rimbalziPartita;
	
	public Giocatore(String username, String id, String nome, String cognome,int altezza, double puntiPartita, double assistPartita, double rimbalziPartita) {
		super(username, id, nome, cognome);
		this.altezza = altezza;
		this.puntiPartita = puntiPartita;
		this.assistPartita = assistPartita;
		this.rimbalziPartita = rimbalziPartita;
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
