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
		
		// Aggiunta utenti alla servlet
		// Societa
		Societa societa1 = new Societa("andrei@povia", "AAAAABB","andrei");
		this.getServletContext().setAttribute("Societa1", societa1);
		
		// Creazione membri da fare in registrazione o quello che è
	
		// Creazione del formato per la data
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	}
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();
		//if(req.getParameter("azione")!= null && req.getParameter("azione").equals("registra")) {
		//	RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/registrazioneCliente.jsp");
		//	rd.forward(req, resp);
		//	return;
		//}
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		
		
		//CONTROLLO CHE UTENTE SIA SOCIETà
		Società societa1 = (Società) this.getServletContext().getAttribute("Societa1");
		if(username.equals(societa1.getUsername()) && password.equals("admin")) {
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
