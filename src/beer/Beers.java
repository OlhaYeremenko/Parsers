package beer;

import java.util.ArrayList;

public class Beers {

	
	
	private ArrayList<Beer> list = new ArrayList<Beer>();
	
	public ArrayList<Beer> getList() {
		return list;
	}


	public void setList(ArrayList<Beer> list) {
		this.list = list;
	}

	public Beers() {
	}
	

	public Beers(ArrayList<Beer> list) {
		this.list = list;
	}


	public boolean add(Beer b) {
	return list.add(b);
	}
	@Override
	public String toString() {
	return "Beers " + list ;
	}
}
