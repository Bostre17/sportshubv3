package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Calendario;
import beans.Giocatore;
import beans.Societa;
import beans.Squadra;



public class MostraCalendario extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//da fare onload
	private int nS=0;//numero Sessioni create per segnare id crescenti (non va mai decrementato)
	
	@Override
	public void init(ServletConfig conf)throws ServletException{
		super.init(conf);
		
		this.nS=(int) this.getServletContext().getAttribute("nS");
		
		
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session = req.getSession();
		String idSoc = (String) session.getAttribute("idSoc");
		String idSquadra= (String) session.getAttribute("idSquadra");
		Calendario res=null;
		Societa temp=null;
		String nomesq="no";
		ArrayList<Societa> listSocieta = (ArrayList<Societa>) this.getServletContext().getAttribute("listSocieta");
		for (Societa s: listSocieta){
			if(s.getId().equals(idSoc)){
				res=s.getCalendario();
				temp=s;
			}
		}
		for(Squadra sq : temp.getSquadre()){
			if(sq.getId().compareTo(idSquadra)==0) nomesq=sq.getNome();
		}
		if(nomesq.compareTo("no")!=0)// se ha una squadra settata pesca il calendario della rispettiva sq altrimenti soc
			res=new Calendario(res.getImpegniSquadra(nomesq));
		
		session.setAttribute("calendario", res);
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/home-società.jsp");
		rd.forward(req, resp);
		return;
		

			
			
			
	}
	
	
}
