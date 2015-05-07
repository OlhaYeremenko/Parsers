package builder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.jdom.JDOMException;
import org.xml.sax.SAXException;

import beer.Beer;

public abstract class AbstractBuilder {

	// protected так как к нему часто обращаются из подкласса
	  protected List<Beer> beers ; 
	  public AbstractBuilder() {
	    beers = new ArrayList<Beer>();
	  }
	  public AbstractBuilder(ArrayList<Beer> beers) {
	    this.beers = beers;
	  }
	  public List<Beer> getBeers() {
	    return beers;
	  }
	  abstract public void buildBeers(String fileName) throws JDOMException, IOException, ParserConfigurationException, SAXException;
}
