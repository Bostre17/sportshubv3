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

import beans.Richiesta;
import beans.Societa;
import beans.Squadra;


public class EliminaRichiesta  extends HttpServlet{
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
        richieste.remove(r);
        this.getServletContext().setAttribute("richieste", richieste);
        
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/gestione-calendario-soc.jsp");
		rd.forward(req, resp);
		return;
        
     /*   
		boolean res=false;
		ArrayList<Societa> listSocieta = (ArrayList<Societa>) this.getServletContext().getAttribute("listSocieta");
        String idImpegno=req.getParameter("id");
        String idSquadra=req.getParameter("idSquadra");

		for (Societa s: listSocieta)//non c'è la parte di squadra che un impegno si aggiunge alla società totale così che se ne rendano tutti conto
		{
            if(s.getId().compareTo(idSoc)==0) {
            	
                for(Squadra sq: s.getSquadre())
                {
                	if(sq.getId().equals(idSquadra))
                	{
                		sq.getCalendario().remove(idImpegno);
                		res=true;
                		break;
                	}
                }
            }
			
		}
		//per capire poi una volta tornato sulla jsp se l'inserimento è anadto a buon fine
		session.setAttribute("result", res);
		
		//lo risalvo sul contesto dopo che ho aggiunto il giocatore
		if(res==true)
			this.getServletContext().setAttribute("listSocieta", listSocieta);
		
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/calendario.jsp");
		rd.forward(req, resp);
		return;
		
		
		*/
	}
	

}
