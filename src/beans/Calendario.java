package beans;

import java.util.ArrayList;
import java.util.List;

public class Calendario {
    private List<Impegno> giorni;
    
    public Calendario() {
        this.giorni = new ArrayList<>();
    }
    public Calendario(List<Impegno> giorni) {
        this.giorni = new ArrayList<>(giorni);
    }
    public void addImpegno(Impegno i){ 
        this.giorni.add(i);
    }
    public void remove(String idImpegno){
        for(int i=0;i<this.giorni.size();i++){
            if(this.giorni.get(i).getIdImpegno().compareTo(idImpegno)==0) this.giorni.remove(i);
        }
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
