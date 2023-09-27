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
import java.time.Month;
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

public class Login extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Gson g;

	@Override
	public void init(ServletConfig conf)throws ServletException{
		super.init(conf);
		g = new Gson();
		
		
	// Creazione e aggiunta attori alla servlet
		ArrayList<Societa> listSocieta = new ArrayList<Societa>();
		
		// Societa
		Societa societa1 = new Societa("dukes", "00000000","Dukes Sansepolcro");
		
		// Squadra
		Squadra squadra1 = new Squadra("Pulcini", "00000000");
		
		// Allenatore
		Allenatore allenatore1 = new Allenatore("lebron.james.pulcini.dukes", "00000000", "Lebron", "James");
	
		// Giocatore
		Giocatore giocatore1 = new Giocatore("lorenzo.severini.pulcini.dukes", "00000000","Lorenzo", "Severini", 195);
		Giocatore giocatore2 = new Giocatore("leonardo.gennaioli.pulcini.dukes", "00000001","Leonardo", "Gennaioli", 180);
		Giocatore giocatore3 = new Giocatore("matteo.bostrenghi.pulcini.dukes", "00000002","Matteo", "Bostrenghi", 180);

		// Aggiunta allenatori e giocatori a squadra
		squadra1.aggiungiAllenatore(allenatore1);
		squadra1.aggiungiGiocatore(giocatore1);
		squadra1.aggiungiGiocatore(giocatore2);
		squadra1.aggiungiGiocatore(giocatore3);
		
		
		//creazione impegni
		LocalDateTime inizioPartita1 = LocalDateTime.of(2023, 9, 26, 18, 0);
		LocalDateTime finePartita1 = LocalDateTime.of(2023, 9, 26, 20, 0);
		Partita p1= new Partita("00000000", "Pulcini", inizioPartita1, finePartita1, "Orlando Tragic", "CUSB", true);
		p1.setPunteggioCasa(91);
		p1.setPunteggioOspiti(90);
		
		LocalDateTime inizioPartita2 = LocalDateTime.of(2023, 9, 20, 18, 0);
		LocalDateTime finePartita2 = LocalDateTime.of(2023, 9, 20, 20, 0);
		Partita p2= new Partita("00000001", "Pulcini", inizioPartita2, finePartita2, "Lakers", "CUSB", false);
		p2.setPunteggioCasa(50);
		p2.setPunteggioOspiti(130);
		squadra1.getCalendario().addImpegno(p1);
		squadra1.getCalendario().addImpegno(p2);

		
		// Aggiunta squadra a società
		societa1.aggiungiSquadra(squadra1);
		
		// Aggiunta società a lista società
		listSocieta.add(societa1);
		
		LocalDateTime inizio = LocalDateTime.of(2023, 11, 18, 18, 0);
		LocalDateTime fine = LocalDateTime.of(2023, 11, 18, 20, 0);
		ArrayList<Richiesta> richieste = new ArrayList<Richiesta>();
		
		Richiesta r1= new Richiesta("00000000", "00000000","A","Allenamento", inizio, fine);
		richieste.add(r1);
		this.getServletContext().setAttribute("richieste", richieste);
		
		
		// Aggiunta lista società a servlet context
		this.getServletContext().setAttribute("listSocieta", listSocieta);

	}
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();
		
		// Creazione del formato per la data
		//DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		

		session.setAttribute("credenzialiErrate", 0);
		
		ArrayList<Societa> listSocieta = (ArrayList<Societa>) this.getServletContext().getAttribute("listSocieta");

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		session.setAttribute("username", username);
	// Controlli tipo utente
		
		// Controllo tutte le società ed i suoi membri
		for(Societa so : listSocieta)
		{
			if(username.equals(so.getUsername()) && password.equals("societa"))
			{
				// Accesso Società
				session.setAttribute("societa", 1);
				session.setAttribute("arrivederci", 0);
				session.setAttribute("username_societa", so.getUsername());
				session.setAttribute("nome_societa", so.getNome());
				//Log.writeLog("admin", LocalDateTime.now(), "LogIn Admin");
				RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/home-soc.jsp");
				rd.forward(req, resp);
				return;
			}
			else if(username.contains(so.getUsername()))
			{
				// L'username contiene il nome della società
				// Controllo tutti gli allenatori e giocatori delle squadre

				session.setAttribute("credenzialiErrate", 0);
				
				ArrayList<Squadra> listSquadre = so.getSquadre();
				
				for(Squadra sq : listSquadre)
				{
					ArrayList<Allenatore> listAllenatori = sq.getAllenatori();
					ArrayList<Giocatore> listGiocatori = sq.getGiocatori();

					for(Allenatore a : listAllenatori)
					{
						if(username.equals(a.getUsername()) && password.equals("allenatore"))
						{
							// Accesso Allenatore
							session.setAttribute("allenatore", 1);
							session.setAttribute("username", a.getUsername());
							session.setAttribute("arrivederci", 0);
							session.setAttribute("nome_allenatore", a.getNome());
							session.setAttribute("cognome_allenatore", a.getCognome());
							session.setAttribute("nome_squadra", sq.getNome());
							session.setAttribute("nome_societa", so.getNome());
							session.setAttribute("username_societa", so.getUsername());
							//Log.writeLog("admin", LocalDateTime.now(), "LogIn Admin");
							RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/home-all.jsp");
							rd.forward(req, resp);
							return;
						}
					}
					for(Giocatore g : listGiocatori)
					{
						if(username.equals(g.getUsername()) && password.equals("giocatore"))
						{
							// Accesso Giocatore
							session.setAttribute("giocatore", 1);
							session.setAttribute("username", g.getUsername());
							session.setAttribute("arrivederci", 0);
							session.setAttribute("nome_giocatore", g.getNome());
							session.setAttribute("cognome_giocatore", g.getCognome());
							session.setAttribute("nome_squadra", sq.getNome());
							session.setAttribute("nome_societa", so.getNome());
							session.setAttribute("username_societa", so.getUsername());
							//Log.writeLog("admin", LocalDateTime.now(), "LogIn Admin");
							RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/home-gio.jsp");
							rd.forward(req, resp);
							return;
						}
					}
				}
			}
		}

		session.setAttribute("credenzialiErrate", 1);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/login.jsp");
		rd.forward(req, resp);
		return;
		
	}
	
	

}
