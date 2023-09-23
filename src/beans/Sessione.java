package beans;

import java.util.*;
import java.time.*;

public class Sessione {
	private int id;
	private LocalDateTime LocalDateTime;
	private String nome;
	private int durata;
	private int massimoPartecipanti;
	private String pt;
	private List<String> clientiInscritti;
	public Sessione(int id, LocalDateTime LocalDateTime, String nome, int massimoPartecipanti,  String pt,int Durata) {
		super();
		this.id = id;
		this.LocalDateTime = LocalDateTime;
		this.nome = nome;
		this.massimoPartecipanti = massimoPartecipanti;
		this.pt = pt;
		this.clientiInscritti=new ArrayList<String>();
		this.durata=Durata;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getLocalDateTime() {
		return LocalDateTime;
	}
	public void setLocalDateTime(LocalDateTime LocalDateTime) {
		this.LocalDateTime = LocalDateTime;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getMassimoPartecipanti() {
		return massimoPartecipanti;
	}
	public void setMassimoPartecipanti(int massimoPartecipanti) {
		this.massimoPartecipanti = massimoPartecipanti;
	}
	public String getPt() {
		return pt;
	}
	public void setPt(String pt) {
		this.pt = pt;
	}
	public List<String> getClientiInscritti() {
		return clientiInscritti;
	}
	public void setClientiInscritti(List<String> clientiInscritti) {
		this.clientiInscritti = clientiInscritti;
	}
	
	public boolean addCliente(String username) {
		if(this.clientiInscritti.size()>=this.massimoPartecipanti) {
			return false;
			
		}
		this.clientiInscritti.add(username);
		return true;
	}
	public boolean cancellaCliente(String username) {
		return this.clientiInscritti.remove(username);
	}
	
	public int getDurata() {
		return durata;
	}
	public void setDurata(int Durata) {
		this.durata = Durata;
	}
	

}
