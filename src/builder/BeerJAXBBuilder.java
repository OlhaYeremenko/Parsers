package builder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.xml.sax.SAXException;

import factory.AbstractBuilder;
import beer.Beer;
import beer.Beer.Char;
import beer.Beer.Ingredient;
import beer.Beer.Char.Filling;
import beer.Beers;

public class BeerJAXBBuilder extends AbstractBuilder {
	private DocumentBuilder docBuilder;
	
	public BeerJAXBBuilder() {
		this.beers = new Beers();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			docBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.err.println("Ошибка конфигурации парсера: " + e);
		}
	}

	public void buildBeers(String xmlFilePath) throws JDOMException,
			IOException, ParserConfigurationException, SAXException,
			JAXBException {
		File file = new File(xmlFilePath);
		JAXBContext jaxbContext = JAXBContext.newInstance(Beers.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		Beers beersList = (Beers) jaxbUnmarshaller.unmarshal(file);
		for (Beer b : beersList) {
			List<Ingredient> iList = new ArrayList<Ingredient>();
			Char c = new Char();
			for (Ingredient i : b.getIngredients()) {
				iList.add(new Ingredient(i.getIngredient(), i.getAmount()));
			}
			c = new Char(b.getChars().getNumberOfTurns(), b.getChars().getTransparency(),
					b.getChars().getFiltered(), b.getChars().getNutritional(),
					new Filling(b.getChars().getFill().getVolume(), b.getChars().getFill().getMaterial()));
			
			beers.add(new Beer(b.getName(), b.getType(), b.getAl(), b.getManufacturer(), iList, c));

		}

	}

}
