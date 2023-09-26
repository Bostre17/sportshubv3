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
        
    }

    public Impegno getImpegno(String id){
        for (int i=0; i<giorni.size();i++){
            if(giorni.get(i).getIdImpegno().compareTo(id)==0){
                return giorni.get(i);
            }
        }
        return null;

    }
    public List<Impegno> selectMese(String mese){
        ArrayList<Impegno> res= new ArrayList<>();
        for (int i=0; i<giorni.size();i++){
            if(giorni.get(i).getInizio().getMonth().toString().compareTo(mese)==0){
                res.add(giorni.get(i));
            }
        }
        return res;
    }
    public  List<Impegno> getImpegniSquadra(){
        
        return this.giorni;
    }

}
