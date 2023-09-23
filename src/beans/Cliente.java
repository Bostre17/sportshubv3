package beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

public class Cliente{
    /**
	 * 
	 */
	private String username;
    private String password;
    private List<Scheda> listaSchede;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String Stato; //attivo bloccato sospeso
    
    public Cliente(String username, String password) {
        this.username = username;
        this.password = password;
        this.listaSchede = new ArrayList<>();
        this.Stato="bloccato";
    }
    public Cliente(String username, String password,String nome,String cognome) {
        this.username = username;
        this.password = password;
        this.cognome=cognome;
        this.nome=nome;
        this.listaSchede = new ArrayList<>();
        this.Stato="bloccato";
    }
    public Cliente(String username, String password, List<Scheda> listaSchede, String nome, String cognome, LocalDate dataNascita,String stato) {
        this.Stato=stato;
    	this.username = username;
        this.password = password;
        this.listaSchede = listaSchede;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
    }
    public String getStato() {
        return Stato;
    }

    public void setStato(String stato) {
        this.Stato = stato;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Scheda> getListaSchede() {
        return listaSchede;
    }

    public void setListaSchede(List<Scheda> listaSchede) {
        this.listaSchede = listaSchede;
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

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }
    public void aggiungiScheda(Scheda s) {
    	ArrayList<Scheda> s1= new ArrayList<Scheda>();
    	for(Scheda ss: this.getListaSchede()) {
    		s1.add(ss);
    	}
    	s1.add(s);
    	this.listaSchede=s1;
    	return;
    }
    @Override
    public String toString() {
        return "Cliente [username=" + username + ", password=" + password + ", listaSchede=" + listaSchede
                + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita + "]";
    }
}
