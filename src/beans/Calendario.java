package beans;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Calendario {
    private ArrayList<Impegno> impegni;
    
    public Calendario() {
        this.impegni = new ArrayList<>();
    }
    
    public void addImpegno(Impegno i){ 
        this.impegni.add(i);
    }
    public void remove(String idImpegno){
    	//System.out.println("numero di impegni "+this.impegni.size());
    	
    	for(int i=0; i<this.impegni.size();i++)
    	{
    		if(this.impegni.get(i).getIdImpegno().equals(idImpegno))
    			this.impegni.remove(i);
    	}
    	
    	/*
    	for(Impegno i: this.impegni)
        {
    		if(i.getIdImpegno().equals(idImpegno))
    			this.impegni.remove(i);
        }
        */
    }

    public Impegno getImpegno(String idImpegno){
    	for(Impegno i: this.impegni)
        {
     	   if(i.getIdImpegno().equals(idImpegno))
     		   return i;
        }
        return null;

    }
   
    public  ArrayList<Impegno> getImpegni(){
        
        return this.impegni;
    }
    
    public void aggiungiRichiesta(Richiesta r, String nomeSquadra) {
    	
    	Allenamento a= new Allenamento(r.getId(),nomeSquadra, r.getInizio(), r.getFine(), r.getTitolo(), r.getIdAllenatore());
    	this.impegni.add(a);
    	
    }

}
