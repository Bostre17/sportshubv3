package beans;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
	private List<Item> prodotti = new ArrayList<Item>();

	public List<Item> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Item> prodotti) {
		this.prodotti = prodotti;
	}

	public Catalogo() {
		super();
	}

	public boolean add(Item i)
	{
		return this.prodotti.add(i);
	}
	
	public boolean remove(Item i)
	{
		return this.prodotti.remove(i);
	}
	
	public Item remove(int index)
	{
		return this.prodotti.remove(index);
	}
	
	
	public Item getItemFromCatalogue(Item it)
	{
		for(Item i : this.prodotti)
		{
			if(i.compareTo(it)==0)
				return i;
		}
		return null;
	}
	
}
