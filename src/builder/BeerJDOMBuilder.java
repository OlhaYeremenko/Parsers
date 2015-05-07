package builder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import beer.Beer;
import beer.Beer.Char;
import beer.Beer.Char.Filling;
import beer.Beer.Ingredient;
import beer.Beers;

public class BeerJDOMBuilder extends AbstractBuilder {
	private DocumentBuilder docBuilder;
	private List<Beer> beers;

	public BeerJDOMBuilder() {
		this.beers = new ArrayList<Beer>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			docBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.err.println("Ошибка конфигурации парсера: " + e);
		}
	}

	public void buildBeers(String xmlFilePath) throws JDOMException,
			IOException {
		ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
		SAXBuilder saxBuilder = new SAXBuilder();
		File xmlFile = new File(xmlFilePath);
		Document document = (Document) saxBuilder.build(xmlFile);
		Element rootElement = document.getRootElement();

		List<Element> listElement = rootElement.getChildren();
		String name = null, type = null, al = null, manufacturer = null, ingr = null, amount = null, numberOfTurns = null, transparency = null, filtered = null, nutritional = null, filling = null, material = null;
		Char c = null;
		for (Element e : listElement) {
			List<Element> listchild = e.getChildren();
			for (Element ec : listchild) {
				switch (ec.getName()) {
				case "name":
					name = ec.getValue().toString();
					break;
				case "type":
					type = ec.getValue().toString();
					break;
				case "al":
					al = ec.getValue().toString();
					break;
				case "manufacturer":
					manufacturer = ec.getValue().toString();
					break;
				case "ingredients":
					List<Element> listIngr = ec.getChildren();
					for (Element ei : listIngr) {
						amount = ei.getAttributeValue("amount");
						ingr = ei.getValue();
						ingredients.add(new Ingredient(ingr, amount));
					}
					break;
				case "chars":
					numberOfTurns = ec.getChild("numberOfTurns").getValue();
					transparency = ec.getChild("transparency").getValue();
					filtered = ec.getChild("filtered").getValue();
					nutritional = ec.getChild("nutritional").getValue();
					filling = ec.getChild("filling").getValue();
					material = ec.getChild("filling").getAttributes().get(0)
							.toString();
					c = new Char(numberOfTurns, transparency, filtered,
							nutritional, new Filling(filling, material));
					break;
				default:
					System.out.println("hello");
				}
			}
			if (c != null) {
				beers.add(new Beer(name, type, al, manufacturer, ingredients, c));
			}
		}

	}

}
