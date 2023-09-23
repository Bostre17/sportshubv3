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

import beans.Log;
import beans.Sessione;

public class Calendario extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private int nS=0;//numero Sessioni create per segnare id crescenti (non va mai decrementato)
	
	@Override
	public void init(ServletConfig conf)throws ServletException{
		super.init(conf);
		
		this.nS=(int) this.getServletContext().getAttribute("nS");
		
		
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		if(req.getParameter("tipo").equals("aggiungiSessione")) {
			String nome=req.getParameter("nome");
			int numero=Integer.parseInt(req.getParameter("numero"));
			int durata=Integer.parseInt(req.getParameter("durata"));
			System.out.println(req.getParameter("data"));
			System.out.println("\n\nData: "+req.getParameter("data")+"T10:"+req.getParameter("orario"));
			LocalDateTime date=LocalDateTime.parse(req.getParameter("data")+"T10:"+req.getParameter("orario"));
			
			Sessione s=new Sessione(this.nS,date,nome,numero,(String) session.getAttribute("username"),durata);
			this.nS+=1;
			
			List<Sessione> sessioni=(ArrayList<Sessione>) this.getServletContext().getAttribute("sessioni");
			sessioni.add(s);
			this.getServletContext().setAttribute("sessioni", sessioni);
			System.out.println("\n\nSESSIONE AGGIUNTA\n\n"+(String) session.getAttribute("username"));
			Log.writeLog((String) session.getAttribute("username"), LocalDateTime.now(), "crea una sessione");
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/CreazioneSessione.jsp");
			rd.forward(req, resp);
			return;
		}
		if(req.getParameter("tipo").equals("eliminaSessione")) {
			
			int id=Integer.parseInt(req.getParameter("id"));
		
			
			
			
			List<Sessione> sessioni=(ArrayList<Sessione>) this.getServletContext().getAttribute("sessioni");
			int toDelate=-1;
			for(int i=0;i<sessioni.size();i++) {
				if(sessioni.get(i).getId()==id) {
					toDelate=i;
					break;
				}
			}
			if(toDelate>-1) {
				sessioni.remove(toDelate);
			}
			
			this.getServletContext().setAttribute("sessioni", sessioni);

			Log.writeLog((String) session.getAttribute("username"), LocalDateTime.now(), "elimina una sessione");

			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/CreazioneSessione.jsp");
			rd.forward(req, resp);
			return;
		}
		if(req.getParameter("tipo").equals("iscrizione")) {
			
			int id=Integer.parseInt(req.getParameter("id"));
		
			
			
			
			List<Sessione> sessioni=(ArrayList<Sessione>) this.getServletContext().getAttribute("sessioni");
			for(Sessione s : sessioni) {
				if(s.getId()==id) {
					s.addCliente((String)session.getAttribute("username"));
				}
			}
			this.getServletContext().setAttribute("sessioni", sessioni);
			Log.writeLog((String) session.getAttribute("username"), LocalDateTime.now(), "si iscrive ad una sessione");
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/CalendarioCliente.jsp");
			rd.forward(req, resp);
			return;
		}
		if(req.getParameter("tipo").equals("disiscrizione")) {
			
			int id=Integer.parseInt(req.getParameter("id"));
		
			
			
			
			List<Sessione> sessioni=(ArrayList<Sessione>) this.getServletContext().getAttribute("sessioni");
			for(Sessione s : sessioni) {
				if(s.getId()==id) {
					s.cancellaCliente((String)session.getAttribute("username"));
				}
			}
			this.getServletContext().setAttribute("sessioni", sessioni);
			Log.writeLog((String) session.getAttribute("username"), LocalDateTime.now(), "si discrive da una sessione");
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/StoricoCliente.jsp");
			rd.forward(req, resp);
			return;
		}
		System.out.println("\n\nERRORE RICHIESTA A CALENDARIO \n"+req.getParameter("tipo")+"\n");
		
		
	}
	
	
}
