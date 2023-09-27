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

public class InserisciRisultato  extends HttpServlet{
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
		String societa= (String) session.getAttribute("username_societa");
		String squadra= (String) session.getAttribute("nome_squadra");
		
		String id = req.getParameter("id");
		Integer punteggio_casa = Integer.parseInt(req.getParameter("punteggioCasa"));
		Integer punteggio_osp = Integer.parseInt(req.getParameter("punteggioOspiti"));
		ArrayList<Societa> listSocieta = (ArrayList<Societa>) this.getServletContext().getAttribute("listSocieta");

		session.setAttribute("inserimento-errato", 1);
		
		if(id.length() != 8)
		{
			this.getServletContext().setAttribute("listSocieta", listSocieta);
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/inserisci-risultati-all.jsp");
			rd.forward(req, resp);
			return;
		}
		
		for(Societa s: listSocieta)
		{
			if(s.getUsername().equals(societa))
			{
				for(Squadra sq: s.getSquadre())
				{
					if(sq.getNome().equals(squadra))
					{
						for(Impegno i : sq.getCalendario().getImpegni())
						{
							if(i.getIdImpegno().equals(id))
							{
								if(i instanceof Partita)
								{
									session.setAttribute("inserimento-errato", 0);
									((Partita) i).setPunteggioCasa(punteggio_casa);
									((Partita) i).setPunteggioOspiti(punteggio_osp);
								}
								else
								{
									session.setAttribute("inserimento-errato", 1);
									RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/inserisci-risultati-all.jsp");
									rd.forward(req, resp);
								}
							}
						}
					}
				}
			}
				
		}
		this.getServletContext().setAttribute("listSocieta", listSocieta);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/inserisci-risultati-all.jsp");
		rd.forward(req, resp);
		return;
		
	}
	

}
