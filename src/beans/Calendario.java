package beans;

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
       for(Impegno i: this.impegni)
       {
    	   if(i.getIdImpegno().equals(idImpegno))
    		   this.impegni.remove(i);
       }
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

}
