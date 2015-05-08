package builder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom.JDOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import beer.Beer;
import beer.Beer.Char;
import beer.Beer.Char.Filling;
import beer.Beer.Ingredient;
import beer.Beers;

public class BeerDOMBuilder extends AbstractBuilder {
	private DocumentBuilder docBuilder;
	// private List<Beer> beers;
	private Beers beer;

	public BeerDOMBuilder() {
		this.beers = new Beers();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			docBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.err.println("Ошибка конфигурации парсера: " + e);
		}
	}

	public void buildBeers(String xmlFilePath) throws JDOMException,
			IOException, ParserConfigurationException, SAXException {
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		try {
			File xmlFile = new File(xmlFilePath);
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory
					.newDocumentBuilder();
			Document document = documentBuilder.parse(xmlFile);
			document.getDocumentElement().normalize();
			NodeList nodeList = document
					.getElementsByTagName(document.getDocumentElement()
							.getChildNodes().item(1).getNodeName());

			for (int tmp = 0; tmp < nodeList.getLength(); tmp++) {
				Node node = nodeList.item(tmp);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;

					String name = element.getElementsByTagName("name").item(0)
							.getChildNodes().item(0).getNodeValue();

					String type = element.getElementsByTagName("type").item(0)
							.getChildNodes().item(0).getNodeValue();

					String al = element.getElementsByTagName("al").item(0)
							.getChildNodes().item(0).getNodeValue();

					String manufacturer = element
							.getElementsByTagName("manufacturer").item(0)
							.getChildNodes().item(0).getNodeValue();

					NodeList ingrs = element
							.getElementsByTagName("ingredients").item(0)
							.getChildNodes();
					ingredients.clear();
					for (int i = 0; i < ingrs.getLength(); i++) {
						String ingr = element
								.getElementsByTagName("ingredient").item(i)
								.getTextContent();

						String amount = element
								.getElementsByTagName("ingredient").item(i)
								.getAttributes().item(0).getTextContent();
						Ingredient i1 = new Ingredient(ingr, amount);
						ingredients.add(i1);
					}

					String numberOfTurns = element
							.getElementsByTagName("numberOfTurns").item(0)
							.getChildNodes().item(0).getNodeValue();
					String transparency = element
							.getElementsByTagName("transparency").item(0)
							.getChildNodes().item(0).getNodeValue();

					String filtered = element.getElementsByTagName("filtered")
							.item(0).getChildNodes().item(0).getNodeValue();

					String nutritional = element
							.getElementsByTagName("nutritional").item(0)
							.getChildNodes().item(0).getNodeValue();

					String amount = element.getElementsByTagName("filling")
							.item(0).getChildNodes().item(0).getNodeValue();

					String material = element.getElementsByTagName("filling")
							.item(0).getAttributes().item(0).getNodeValue();

					Filling f = new Filling(amount, material);
					Char c = new Char(numberOfTurns, transparency, filtered,
							nutritional, f);
					Beer beer = new Beer(name, type, al, manufacturer,
							ingredients, c);
					beers.add(beer);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}

	}
}
