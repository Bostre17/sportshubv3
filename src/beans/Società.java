package beans;

import java.util.ArrayList;


public class Società {

	private ArrayList<Palestra> palestre;
	private ArrayList<Squadra> squadre;
	private String nome;
	private Calendario calendario;
	public Società(String nome) {
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
	public Calendario getCalendario() {
		return calendario;
	}
	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}
	
	
	
	
	
	
}
