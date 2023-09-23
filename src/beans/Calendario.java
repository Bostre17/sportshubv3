package beans;

import java.util.ArrayList;
import java.util.List;

public class Calendario {
    private List<Impegno> giorni;
    
    public Calendario(List<Impegno> giorni) {
        this.giorni = new ArrayList<>(giorni);
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
    public  List<Impegno> getImpegniSquadra(String nomeSquadra){
        ArrayList<Impegno> res= new ArrayList<>();
        for (int i=0; i<giorni.size();i++){
            if(giorni.get(i).getNomeSquadra().compareTo(nomeSquadra)==0){
                res.add(giorni.get(i));
            }
        }
        return res;
    }

}
