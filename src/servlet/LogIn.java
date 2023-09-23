package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;


import beans.*;

public class LogIn extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Gson g;

	@Override
	public void init(ServletConfig conf)throws ServletException{
		super.init(conf);
		g=new Gson();
		
		//AGGIUNGI ACCOUNT ALLA SERVLET
		//-AMMINISTRATORE
		Amministratore admin = new Amministratore("admin", "admin");
		this.getServletContext().setAttribute("Amministratore", admin);
		
		// Creazione esercizi
		Esercizio esercizio1 = new Esercizio("Panca piana", 3, 10, 1, "images/Panca.jpg", "Panca piana, focus pettorale",90);
		Esercizio esercizio2 = new Esercizio("Spinte verticali", 4, 12, 2, "images/Spinte.jpg", "Spinte verticali, focus spalle",90);

		// Creazione schede
		Scheda scheda1 = new Scheda("Scheda 1", Arrays.asList(esercizio1, esercizio2), "","pt1","easy");
		Scheda scheda2 = new Scheda("Scheda 2", Arrays.asList(esercizio1, esercizio2), "","pt1","medium");
		// Creazione del formato per la data
		

		// Creazione del formato per la data
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// Creazione della data di nascita
		LocalDate dataNascita = LocalDate.parse("01/01/2001", formatoData);
		// Creazione clienti
		Cliente cliente1 = new Cliente("cl1", "cl1", Arrays.asList(scheda1), "Nome Cliente 1", "Cognome Cliente 1", dataNascita,"Attivo");
		Cliente cliente2 = new Cliente("cl2", "cl2", Arrays.asList(scheda1,scheda2), "Nome Cliente 2", "Cognome Cliente 2", dataNascita,"Attivo");

		// Creazione lista clienti
		List<Cliente> listClienti = new ArrayList<>();
		listClienti.add(cliente1);
		listClienti.add(cliente2);

		// Impostazione attributo nel contesto dell'applicazione
		this.getServletContext().setAttribute("listClienti", listClienti);
		
		
		//creazione presonal trainer 
		dataNascita = LocalDate.parse("07/08/1958", formatoData);
		PersonalTrainer pt1 = new PersonalTrainer("pt1", "pt1", "Bruce", "Dickinson", dataNascita);
		dataNascita = LocalDate.parse("03/08/1963", formatoData);
		PersonalTrainer pt2 = new PersonalTrainer("pt2", "pt2", "James", "Hetfield", dataNascita);
		List<PersonalTrainer> listPT=new ArrayList<PersonalTrainer>();
		listPT.add(pt1);
		listPT.add(pt2);
		this.getServletContext().setAttribute("listPT", listPT);
	
	
		
		//creazione sessioni iniziali
		int nS=0;
		List<Sessione> sessioni;
		sessioni=new ArrayList<Sessione>();
		Sessione s1=new Sessione(nS,LocalDateTime.of(2023,7,14,19,00),"sessione 1",2,"pt1",60);
		nS+=1;
		Sessione s2=new Sessione(nS,LocalDateTime.of(2023,7,14,14,00),"sessione 2",5,"pt2",60);
		nS+=1;
		sessioni.add(s1);
		sessioni.add(s2);
		this.getServletContext().setAttribute("sessioni", sessioni);
		this.getServletContext().setAttribute("nS", nS);
	
	
	}
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();
		if(req.getParameter("azione")!= null && req.getParameter("azione").equals("registra")) {
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/registrazioneCliente.jsp");
			rd.forward(req, resp);
			return;
		}
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		
		
		//CONTROLLO CHE UTENTE SIA ADMIN
		Amministratore admin = (Amministratore) this.getServletContext().getAttribute("Amministratore");
		if(username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
			session.setAttribute("admin", true);
			Log.writeLog("admin", LocalDateTime.now(), "LogIn Admin");
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/admin.jsp");
			rd.forward(req, resp);
			return;
		}
		
		
		
		//Controllo se è un cliente
		List<Cliente> listClienti=(ArrayList<Cliente>) this.getServletContext().getAttribute("listClienti");
		for(Cliente cl : listClienti) {
			if(username.equals(cl.getUsername()) && password.equals(cl.getPassword()) && cl.getStato().equals("Attivo")) {
				session.setAttribute("Cliente", true);
				session.setAttribute("username", cl.getUsername());
				Log.writeLog(cl.getUsername(), LocalDateTime.now(), "LogIn Cliente");
				RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/HomeCliente.jsp");
				rd.forward(req, resp);
				return;
			}
		}
		
		
		
		
		//controllo se è un personal trainer
		List<PersonalTrainer> listPT=(ArrayList<PersonalTrainer>) this.getServletContext().getAttribute("listPT");
		for(PersonalTrainer pt : listPT) {
			if(username.equals(pt.getUsername()) && password.equals(pt.getPassword())) {
				session.setAttribute("PersonalTrainer", true);
				session.setAttribute("username", pt.getUsername());
				Log.writeLog(pt.getUsername(), LocalDateTime.now(), "LogIn PersonalTrainer");
				RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/PersonalTrainerHome.jsp");
				rd.forward(req, resp);
				return;
			}
		}
		
		
		
		
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(req, resp);
		return;
		
	}
	
	

}
