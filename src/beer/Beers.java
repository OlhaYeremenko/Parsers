package beer;

import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "beers")
public class Beers implements Iterable<Beer> {

	
	
	private ArrayList<Beer> list = new ArrayList<Beer>();
	
	public ArrayList<Beer> getList() {
		return list;
	}

	@XmlElement(name = "beer")
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


	@Override
	public Iterator<Beer> iterator() {
       
	        Iterator<Beer> iBeer = list.iterator();
	        return iBeer; 
	}
}
