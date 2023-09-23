package beans;

import java.time.LocalDateTime;
import java.util.List;

public class Partita extends Impegno {
    private int punteggioCasa;
    private int punteggioOspiti;
    private List<Statistica> stats;
    private String avversario;
    private String competizione;
    private List<Integer> quarti;

    

    public Partita(String idImpegno, String nomeSquadra, LocalDateTime inizio, LocalDateTime fine, int punteggioCasa,
            int punteggioOspiti, List<Statistica> stats, String avversario, String competizione, List<Integer> quarti) {
        super(idImpegno, nomeSquadra, inizio, fine);
        this.punteggioCasa = punteggioCasa;
        this.punteggioOspiti = punteggioOspiti;
        this.stats = stats;
        this.avversario = avversario;
        this.competizione = competizione;
        this.quarti = quarti;
    }
    public int getPunteggioCasa() {
        return punteggioCasa;
    }
    public int getPunteggioOspiti() {
        return punteggioOspiti;
    }
    public List<Statistica> getStats() {
        return stats;
    }
    public String getAvversario() {
        return avversario;
    }

    
}
