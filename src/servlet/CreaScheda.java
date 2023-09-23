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

import beans.Cliente;
import beans.Esercizio;
import beans.Log;
import beans.Scheda;
import beans.Sessione;

public class CreaScheda extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private int nS=0;//numero Sessioni create per segnare id crescenti (non va mai decrementato)
	
	@Override
	public void init(ServletConfig conf)throws ServletException{
		super.init(conf);
		
		
		
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String nomeScheda=req.getParameter("nome");
		String cliente=req.getParameter("cliente");
		String difficolta=req.getParameter("difficolta");
		int numeroEs=Integer.parseInt(req.getParameter("numeroEs"));
		
		for(Object o: req.getParameterMap().entrySet()) {
			System.out.println("\n\n "+o.toString() );
		}
		
		List<Esercizio> esercizi=new ArrayList<Esercizio>();
		
		
		for (int i=0;i<numeroEs;i++) {
			
			String nomeEs=req.getParameter("nomeEs"+String.valueOf(i));
			
			int serie=Integer.parseInt(req.getParameter("serie"+String.valueOf(i)));
			int ripetizioni=Integer.parseInt(req.getParameter("ripetizioni"+String.valueOf(i)));
			int recupero=Integer.parseInt(req.getParameter("recupero"+String.valueOf(i)));
			esercizi.add(new Esercizio(nomeEs,serie,ripetizioni,3,"images/"+nomeEs+".jpg","descrizione",recupero));
		}
		Scheda sc=new Scheda(nomeScheda,esercizi,cliente,(String)session.getAttribute("username"),difficolta);
		System.out.println("Scheda creata"+sc.toString());
		List<Cliente> listClienti = (ArrayList<Cliente>) this.getServletContext().getAttribute("listClienti");
		for(Cliente c : listClienti) {
			if(c.getUsername().equals(cliente)) {
				c.aggiungiScheda(sc);
				
			}
			
		}
		this.getServletContext().setAttribute("listClienti", listClienti);
		
		Log.writeLog((String)session.getAttribute("username"), LocalDateTime.now(), "creazione nuova scheda per cliente ("+cliente+")");
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/PersonalTrainerHome.jsp");
		rd.forward(req, resp);
		return;
		
	}
}

