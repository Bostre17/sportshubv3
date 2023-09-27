package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
		String idImpegno=(String) req.getAttribute("idImpegno");
		String nomeSquadra=(String) req.getAttribute("idImpegno");
		String avversario=(String) req.getAttribute("avversario");
		String competizione=(String) req.getAttribute("competizione");
		String dataInizio= (String) req.getAttribute("dataInizio");
		String oraInizio= (String) req.getAttribute("oraInizio");
		String casa= (String) req.getAttribute("casa");
		if(casa.equalsIgnoreCase("casa"))
			partita_casa=true;
		String oraFine= (String) req.getAttribute("oraFine");
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
		Partita p = new Partita(idImpegno, nomeSquadra, inizio, fine, avversario, competizione, partita_casa);
		
		for(Societa s: listSocieta)
		{
			if(s.getUsername().equals(username))
			{
				for(Squadra sq:s.getSquadre())
				{
					if(sq.getNome().equals(nomeSquadra))
					{
						sq.getCalendario().addImpegno(p);
						break;
					}
				}
			}
		}
		
		
		
		
	}
	

}