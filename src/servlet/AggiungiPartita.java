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

public class AggiungiPartita extends HttpServlet{
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
		String username = (String) session.getAttribute("username");
		ArrayList<Societa> listSocieta = (ArrayList<Societa>) this.getServletContext().getAttribute("listSocieta");
		boolean partita_casa=false;
		//String idImpegno=(String) req.getParameter("idImpegno");
		String nomeSquadra=(String) req.getParameter("nomeSquadra");
		String avversario=(String) req.getParameter("avversario");
		String competizione=(String) req.getParameter("competizione");
		String dataInizio= (String) req.getParameter("data");
		String oraInizio= (String) req.getParameter("oraInizio");
		String oraFine= (String) req.getParameter("oraFine");
		String casa= (String) req.getParameter("casa");
		if(casa.equalsIgnoreCase("casa"))
			partita_casa=true;
		
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
        String id=(String) this.getServletContext().getAttribute("lastIdImpegno");
        Integer idInt=Integer.parseInt(id);
        idInt++;
        id=Integer.toString(idInt);
        
        this.getServletContext().setAttribute("lastIdImpegno", id);
        
		Partita p = new Partita(id, nomeSquadra, inizio, fine, avversario, competizione, partita_casa);
		
		for(Societa s: listSocieta)
		{
			//System.out.println("primo ciclo");
			if(s.getUsername().equals(username))
			{
				//System.out.println("trovata la società");
				for(Squadra sq:s.getSquadre())
				{
					//System.out.println("secondo ciclo");
					if(sq.getNome().equalsIgnoreCase(nomeSquadra))
					{
						//System.out.println("DAJE------------------------------------------");
						sq.getCalendario().addImpegno(p);
						break;
					}
				}
			}
		}
		
		// Aggiunta lista società a servlet context
		this.getServletContext().setAttribute("listSocieta", listSocieta);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/gestioneCalendario.jsp");
		rd.forward(req, resp);
		return;
		
		
		
		
	}
	

}
