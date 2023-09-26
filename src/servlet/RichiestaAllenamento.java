package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Richiesta;




public class RichiestaAllenamento extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//da fare onload SEMPRE così anche con gli aggiungi e rimuovi basta fare forward e ricaricare la pagina
	private int nS=0;//numero Sessioni create per segnare id crescenti (non va mai decrementato)
	
	@Override
	public void init(ServletConfig conf)throws ServletException{
		super.init(conf);
		
		this.nS=(int) this.getServletContext().getAttribute("nS");
		
		
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ArrayList<Richiesta> richieste = (ArrayList<Richiesta>) this.getServletContext().getAttribute("richieste");
		String idRichiesta=req.getParameter("id");
        String titolo=req.getParameter("");
        String dataInizio=req.getParameter("dInizio");
        String dataFine=req.getParameter("dFine");
        String oraInizio=req.getParameter("oInizio");
        String oraFine=req.getParameter("oFine");
        String tipo=req.getParameter("tipo");

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        // Effettuare il parsing della data e dell'ora dalla stringa
        LocalDateTime dateI = LocalDateTime.parse(dataInizio, dateFormatter);
        LocalDateTime timeI = LocalDateTime.parse(oraInizio, timeFormatter);
        LocalDateTime dateF = LocalDateTime.parse(dataFine, dateFormatter);
        LocalDateTime timeF = LocalDateTime.parse(oraFine, timeFormatter);

        // Combinare la data e l'ora per creare un oggetto LocalDateTime
        LocalDateTime dateTimeI = dateI.withHour(timeI.getHour()).withMinute(timeI.getMinute());
        LocalDateTime dateTimeF = dateF.withHour(timeF.getHour()).withMinute(timeF.getMinute());
		Richiesta x= new Richiesta(idRichiesta, tipo,titolo, dateTimeI, dateTimeF);
		richieste.add(x);
	
		this.getServletContext().setAttribute("richieste", richieste);
        
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/calendario.jsp");
		rd.forward(req, resp);
		return;
		
		
		
	}
	
	
}
