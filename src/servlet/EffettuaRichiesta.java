package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import beans.Partita;
import beans.Richiesta;
import beans.Societa;
import beans.Squadra;

public class EffettuaRichiesta extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Gson g;
	
	
	@Override
	public void init(ServletConfig conf)throws ServletException{
		super.init(conf);
		g = new Gson();
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		//recupero l'id della società dalla sessione par capire a quale società appartiene la squadra a cui devo aggiungere un giocatore
		String id=(String) req.getParameter("id");
		//String idImpegno=(String) req.getParameter("idImpegno");
		String tipo=(String) req.getParameter("tipo");
		String dataInizio= (String) req.getParameter("data");
		String oraInizio= (String) req.getParameter("oraInizio");
		String oraFine= (String) req.getParameter("oraFine");
		String titolo= (String) req.getParameter("titolo");
		System.out.println(id+tipo+dataInizio+oraInizio+oraFine+titolo);
		// Definisci il formato per la data e l'ora
		 
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        // Effettua il parsing delle stringhe in oggetti LocalDateTime
        LocalDateTime date = LocalDate.parse(dataInizio, dateFormatter).atStartOfDay();
        LocalDateTime time = LocalTime.parse(oraInizio, timeFormatter).atDate(date.toLocalDate());
        LocalDateTime time2 = LocalTime.parse(oraFine, timeFormatter).atDate(date.toLocalDate());

        // Combina la data e l'ora in un oggetto LocalDateTime
        LocalDateTime inizio = date.with(time.toLocalTime());
        LocalDateTime fine = date.with(time2.toLocalTime());
        String idrichiesta=(String) this.getServletContext().getAttribute("lastIdRichieste");
        System.out.println(idrichiesta+inizio+fine);
        Integer idInt=Integer.parseInt(idrichiesta);
        idInt++;
        //id=Integer.toString(idInt);
        idrichiesta= String.format("%08d", idInt);

        ArrayList<Richiesta> richieste= (ArrayList<Richiesta>) this.getServletContext().getAttribute("richieste");
        Richiesta r= new Richiesta(id,idrichiesta,tipo,titolo,inizio,fine);
        richieste.add(r);
		
		// Aggiunta lista società a servlet context
        this.getServletContext().setAttribute("lastIdRichiesta", idrichiesta);
		this.getServletContext().setAttribute("Richiesta", richieste);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/gestione-calendario-all.jsp");
		rd.forward(req, resp);
		return;
		
		
		
		
	}
	

}
