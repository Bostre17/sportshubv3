package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import beans.Societa;
import beans.Squadra;

public class EliminaImpegno extends HttpServlet{

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
		String idImpegno=req.getParameter("idImpegno");
		
		for(Societa s: listSocieta)
		{
			if(s.getUsername().equals(username))
			{
				//System.out.println("trovato l'username");
				for(Squadra sq: s.getSquadre())
				{
					//System.out.println("secondo cic");
					if(sq.esisteImpegno(idImpegno))
					{
						//System.out.println("Esiste dio"+idImpegno);
						sq.getCalendario().remove(idImpegno);
						break;
					}
				}
			}
		}
		this.getServletContext().setAttribute("listSocieta", listSocieta);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/gestione-calendario-soc.jsp");
		rd.forward(req, resp);
		return;
		
		
	}
}
