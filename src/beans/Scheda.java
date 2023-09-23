package beans;

import java.io.Serializable;
import java.util.List;

public class Scheda{
    /**
	 * 
	 */
	private String nome;
    private List<Esercizio> listaEsercizi;
    private String idCliente;
    private String PersonalTrainer;
    private String difficolta;
    @Override
	public String toString() {
		return "Scheda [nome=" + nome + ", listaEsercizi=" + listaEsercizi + ", idCliente=" + idCliente
				+ ", PersonalTrainer=" + PersonalTrainer + ", difficolta=" + difficolta + "]";
	}

	public Scheda() {
    }

    public Scheda(String nome, List<Esercizio> listaEsercizi, String idCliente,String PersonalTrainer,String difficolta) {
        this.nome = nome;
        this.listaEsercizi = listaEsercizi;
        this.idCliente = idCliente;
        this.PersonalTrainer=PersonalTrainer;
        this.difficolta=difficolta;
    }

    // Metodi getter e setter
    public String getDifficolta()
    {
    	return difficolta;
    }
    public void setDifficolta(String d)
    {
    difficolta=d;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getPersonalTrainerScheda() {
        return PersonalTrainer;
    }

    public void setPTScheda(String PT) {
        this.PersonalTrainer = PT;
    }

    public List<Esercizio> getListaEsercizi() {
        return listaEsercizi;
    }

    public void setListaEsercizi(List<Esercizio> listaEsercizi) {
        this.listaEsercizi = listaEsercizi;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
}
