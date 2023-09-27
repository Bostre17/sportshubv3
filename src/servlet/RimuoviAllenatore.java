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

public class RimuoviAllenatore  extends HttpServlet{
	
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
		String nome_societa = (String) session.getAttribute("nome_societa");
		
		//recupero l'id della squadra
		boolean res=false;
		ArrayList<Societa> listSocieta = (ArrayList<Societa>) this.getServletContext().getAttribute("listSocieta");
		
		for (Societa s: listSocieta)
		{
			if(s.getNome().equals(nome_societa))
			{
				String id_allenatore= req.getParameter("id");
				
				for(Squadra sq: s.getSquadre())
				{
					if(sq.esisteAllenatore(id_allenatore))
					{
					    sq.eliminaAllenatore(id_allenatore);
					    break;
					}
				}
				break;
			}
		}
		//per capire poi una volta tornato sulla jsp se l'inserimento è anadto a buon fine
		session.setAttribute("result", res);
		
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/gestione-squadra-soc.jsp");
		rd.forward(req, resp);
		return;
		
		
		
	}
	
	
}
