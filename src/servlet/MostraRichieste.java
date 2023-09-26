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



public class MostraRichieste extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//da fare onload SEMPRE così anche con gli aggiungi e rimuovi basta fare forward e ricaricare la pagina
	private int nS=0;//numero Sessioni create per segnare id crescenti (non va mai decrementato)
	
	@Override
	public void init(ServletConfig conf)throws ServletException{
		super.init(conf);
		
		this.nS=(int) this.getServletContext().getAttribute("nS");
		
		
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ArrayList Richieste=new ArraListreq.getServletContext().getAttribute("richieste");
	}
	
	
}
