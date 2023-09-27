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

import beans.Allenatore;
import beans.Giocatore;
import beans.Societa;
import beans.Squadra;

public class RimuoviGiocatore extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Gson g;
	
	
	@Override
	public void init(ServletConfig conf)throws ServletException{
		super.init(conf);
		g = new Gson();
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("pavel");
		HttpSession session = req.getSession();
		//recupero l'id della società dalla sessione par capire a quale società appartiene la squadra a cui devo aggiungere un giocatore
		String idSocietà = (String) session.getAttribute("username_societa");
		System.out.println("pavel");
		String id=req.getParameter("id");//nome
		System.out.println(id);
		
		
		ArrayList<Societa> listSocieta = (ArrayList<Societa>) this.getServletContext().getAttribute("listSocieta");
		
		for (Societa s: listSocieta)
		{
			if(s.getUsername().equals(idSocietà))
			{
				for(Squadra sq: s.getSquadre())
				{
					    for(Giocatore g: sq.getGiocatori())
					    {
					    	if(g.getId().equals(id))
					    	{
					    		sq.eliminaGiocatore(g);
					    		break;
					    	}
					    }
				}
				break;
			}
		}
		
		this.getServletContext().setAttribute("listSocieta", listSocieta);
		
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/gestione-squadra-soc.jsp");
		rd.forward(req, resp);
		return;
		
		
		
	}
	
	

}
