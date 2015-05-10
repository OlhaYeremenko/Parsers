package factory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom.JDOMException;
import org.xml.sax.SAXException;

import beer.Beer;
import beer.Beers;

public abstract class AbstractBuilder {

	protected Beers beers;

	public AbstractBuilder() {
		beers = new Beers();
	}

	public AbstractBuilder(Beers beers) {
		this.beers = beers;
	}

	public Beers getBeers() {
		return beers;
	}

	abstract public void buildBeers(String fileName) throws JDOMException,
			IOException, ParserConfigurationException, SAXException,
			JAXBException;
}
