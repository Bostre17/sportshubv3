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
		g = new Gson();
		
		
	// Creazione e aggiunta attori alla servlet
		
		MostraCalendario calendario = new MostraCalendario();
		ArrayList<Societa> listSocieta = new ArrayList<Societa>();
		
		// Societa
		Societa societa1 = new Societa("dukes", "00000000","Dukes Sansepolcro");
		
		// Squadra
		Squadra squadra1 = new Squadra("pulcini", "00000000");
		
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
		
		// Aggiunta squadra a società
		societa1.aggiungiSquadra(squadra1);
		
		// Aggiunta società a lista società
		listSocieta.add(societa1);
		
		// Aggiunta lista società a servlet context
		this.getServletContext().setAttribute("listSocieta", listSocieta);

	}
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();
		
		// Creazione del formato per la data
		//DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		
		ArrayList<Societa> listSocieta = (ArrayList<Societa>) this.getServletContext().getAttribute("listSocieta");

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
	// Controlli tipo utente
		
		// Controllo tutte le società ed i suoi membri
		for(Societa so : listSocieta)
		{
			if(username.equals(so.getUsername()) && password.equals("societa"))
			{
				// Accesso Società
				session.setAttribute("societa", true);
				//Log.writeLog("admin", LocalDateTime.now(), "LogIn Admin");
				RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/home-admin.jsp");
				rd.forward(req, resp);
				return;
			}
			else if(username.contains(so.getUsername()))
			{
				// L'username contiene il nome della società
				// Controllo tutti gli allenatori e giocatori delle squadre

				session.setAttribute("credenzialiErrate", false);
				
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
							session.setAttribute("allenatore", true);
							session.setAttribute("username", a.getUsername());
							//Log.writeLog("admin", LocalDateTime.now(), "LogIn Admin");
							RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/home-allenatore.jsp");
							rd.forward(req, resp);
							return;
						}
					}
					for(Giocatore g : listGiocatori)
					{
						if(username.equals(g.getUsername()) && password.equals("giocatore"))
						{
							// Accesso Giocatore
							session.setAttribute("giocatore", true);
							session.setAttribute("username", g.getUsername());
							//Log.writeLog("admin", LocalDateTime.now(), "LogIn Admin");
							RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/index.jsp");
							rd.forward(req, resp);
							return;
						}
					}
				}
			}
		}

		session.setAttribute("credenzialiErrate", true);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/login.jsp");
		rd.forward(req, resp);
		return;
		
	}
	
	

}
