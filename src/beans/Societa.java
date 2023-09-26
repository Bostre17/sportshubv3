package beans;

import java.util.ArrayList;


public class Societa extends Utente{

	private ArrayList<Palestra> palestre;
	private ArrayList<Squadra> squadre;
	private String nome;
	
	
	public Societa(String username, String id, String nome) {
		super(username, id);
		this.nome = nome;
		this.palestre= new ArrayList<Palestra>();
		this.squadre= new ArrayList<Squadra>();
	}
	public ArrayList<Palestra> getPalestre() {
		return palestre;
	}
	public void setPalestre(ArrayList<Palestra> palestre) {
		this.palestre = palestre;
	}
	public ArrayList<Squadra> getSquadre() {
		return squadre;
	}
	public void setSquadre(ArrayList<Squadra> squadre) {
		this.squadre = squadre;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void aggiungiSquadra(Squadra s) {
		this.squadre.add(s);
	}
	
	public boolean rimuoviSquadra(Squadra s) {
		return this.squadre.remove(s);
	}
	
	public void aggiungiPalesta(Palestra p) {
		this.palestre.add(p);
	}
	
	public boolean rimuoviPalestra(Palestra p) {
		return this.palestre.remove(p);
	}
	
	
	
	
	
	
}
