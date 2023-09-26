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

public class AggiungiImpegno  extends HttpServlet{
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
		String idSoc = (String) session.getAttribute("idSoc");
        
        
		boolean res=true;
		ArrayList<Societa> listSocieta = (ArrayList<Societa>) this.getServletContext().getAttribute("listSocieta");
        String idImpegno=req.getParameter("id");
        String nomeSquadra=req.getParameter("nomeSq");
        String dataInizio=req.getParameter("dInizio");
        String dataFine=req.getParameter("dFine");
        String oraInizio=req.getParameter("oInizio");
        String oraFine=req.getParameter("oFine");
        String tipo=req.getParameter("tipo");

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        // Effettuare il parsing della data e dell'ora dalla stringa
        LocalDateTime dateI = LocalDateTime.parse(dataInizio, dateFormatter);
        LocalDateTime timeI = LocalDateTime.parse(oraInizio, timeFormatter);
        LocalDateTime dateF = LocalDateTime.parse(dataFine, dateFormatter);
        LocalDateTime timeF = LocalDateTime.parse(oraFine, timeFormatter);

        // Combinare la data e l'ora per creare un oggetto LocalDateTime
        LocalDateTime dateTimeI = dateI.withHour(timeI.getHour()).withMinute(timeI.getMinute());
        LocalDateTime dateTimeF = dateF.withHour(timeF.getHour()).withMinute(timeF.getMinute());
        Impegno x;
        if(tipo.compareTo("P")==0){
        	String avversario=req.getParameter("avversario");
        	String competizione=req.getParameter("competizione");
            x=new Partita(idImpegno,nomeSquadra,dateTimeI,dateTimeF,avversario,competizione);
            
        }else{//facciamo che se parte da richiesta apre il form già fillato
            String tipologia=req.getParameter("tipologia");
            String titolo=req.getParameter("titolo");
            String idRichiedente=req.getParameter("idRic");
            x=new Allenamento(idImpegno,nomeSquadra,dateTimeI,dateTimeF,tipologia,titolo,idRichiedente);
        }

		for (Societa s: listSocieta)//non c'è la parte di squadra che un impegno si aggiunge alla società totale così che se ne rendano tutti conto
		{
            if(s.getId().compareTo(idSoc)==0) {
                for(Squadra sq: s.getSquadre()) 
                {
                	if(sq.getNome().equals(nomeSquadra))
                		sq.getCalendario().addImpegno(x);
                }
            }
			
		}
		//per capire poi una volta tornato sulla jsp se l'inserimento è anadto a buon fine
		session.setAttribute("result", res);
		
		//lo risalvo sul contesto dopo che ho aggiunto il giocatore
		if(res==true){
			this.getServletContext().setAttribute("listSocieta", listSocieta);
        }
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/calendario.jsp");
		rd.forward(req, resp);
		return;
		
		
		
	}
	

}
