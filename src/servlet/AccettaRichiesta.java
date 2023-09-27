package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
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

import beans.Allenamento;
import beans.Giocatore;
import beans.Impegno;
import beans.Partita;
import beans.Richiesta;
import beans.Societa;
import beans.Squadra;

public class AccettaRichiesta  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Gson g;
	
	
	@Override
	public void init(ServletConfig conf)throws ServletException{
		super.init(conf);
		g = new Gson();
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //per farla più easy inserisci/elimina impegno generale, non distinto da partita e allenamento
        //una società a sinistra vede le richieste con tutte le loro specifiche e poi aggiunge a mano tutto nel form
        //molto più semplice se facciamo distizione con gli allenamenti e mettiamo che li inserisce in autoamtico dalla richiesta 
        //viene infinito
		HttpSession session = req.getSession();
		//recupero l'id della società dalla sessione par capire a quale società appartiene la squadra a cui devo aggiungere un giocatore
		String username = (String) session.getAttribute("username");
		
		String idRichiesta = req.getParameter("idRichiesta");
		ArrayList<Societa> listSocieta = (ArrayList<Societa>) this.getServletContext().getAttribute("listSocieta");
		ArrayList<Richiesta> richieste = (ArrayList<Richiesta>) this.getServletContext().getAttribute("richieste");
		Richiesta r = null;
		for(Richiesta ric: richieste)
			if(ric.getId().equals(idRichiesta))
			{
				r=ric;
				break;
			}
        
		for(Societa s: listSocieta)
		{
			if(s.getUsername().equals(username))
			{
				for(Squadra sq: s.getSquadre())
				{
					if(sq.esisteAllenatore(r.getIdAllenatore()))
					{
						sq.getCalendario().aggiungiRichiesta(r, sq.getNome());
						richieste.remove(r);
						break;
					}
				}
			}
				
		}
		this.getServletContext().setAttribute("richieste", richieste);
		this.getServletContext().setAttribute("listSocieta", listSocieta);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/gestione-calendario-soc.jsp");
		rd.forward(req, resp);
		return;
	}
	

}
