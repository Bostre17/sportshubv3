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

import beans.Giocatore;
import beans.Societa;
import beans.Squadra;

public class aggiungiGiocatore  extends HttpServlet{
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
		
		//recupero l'id della squadra
		
		boolean res=false;
		ArrayList<Societa> listSocieta = (ArrayList<Societa>) this.getServletContext().getAttribute("listSocieta");
		
		for (Societa s: listSocieta)
		{
			if(s.getUsername().equals(idSocietà))
			{
				//String username, String id, String nome, String cognome,int altezza
				String usn= req.getParameter("username");
				String nome= req.getParameter("nome");
				String cognome= req.getParameter("cognome");
				Integer altezza=Integer.parseInt( req.getParameter("altezza"));
				String nomeSquadra=req.getParameter("nomeSquadra");//nome
				
				String id=(String) this.getServletContext().getAttribute("lastIdGiocatore");
		        Integer idInt=Integer.parseInt(id);
		        
		        idInt++;
		        //id=Integer.toString(idInt);
		        id= String.format("%08d", idInt);
		        this.getServletContext().setAttribute("lastIdGiocatore", id);
				//String id= req.getParameter("nomeSquadra");
				//per fare in modo che gli id siano tutti diversi direi di salavre una variabile id sul context che indica il primo id libero, man mano che si creano giocatori facciamo id+1 e la risalviamo sul contesto
				//perche passarlo della jsp è sbagliato in quanto sarebbe l'utente a metterlo e non c'è la garanzia che siano tutti diversi
				System.out.println(usn+nome+cognome+altezza+nomeSquadra+id);
				Giocatore g=new Giocatore(usn, id, nome, cognome, altezza);
				
				for(Squadra sq: s.getSquadre())
				{
					if(sq.getNome().equals(nomeSquadra))
					{
					    res=sq.aggiungiGiocatore(g);
					    break;
					}
				}
				break;
			}
		}
		//per capire poi una volta tornato sulla jsp se l'inserimento è anadto a buon fine
		session.setAttribute("result", res);
		
		//lo risalvo sul contesto dopo che ho aggiunto il giocatore
		if(res==true)
			this.getServletContext().setAttribute("listSocieta", listSocieta);
		
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/gestione-squadra-soc.jsp");
		rd.forward(req, resp);
		return;
		
		
		
	}
	

}
