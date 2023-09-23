package beans;

import java.util.Objects;

public class Item implements Comparable{
	private String id;
	private String descrizione;
	private double prezzo;
	private int quantita;
	
	public Item(String id, String descrizione, double prezzo, int quantita) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.quantita = quantita;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", descrizione=" + descrizione + ", prezzo=" + prezzo + ", quantita=" + quantita
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(descrizione, id, prezzo, quantita);
	}

	@Override
	public int compareTo(Object obj) {
		Item i = (Item)obj;
		return this.getDescrizione().compareTo(i.getDescrizione());
	}
	

}