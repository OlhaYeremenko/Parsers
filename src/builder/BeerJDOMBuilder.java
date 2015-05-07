package builder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import beer.Beer;
import beer.Beer.Char;
import beer.Beer.Char.Filling;
import beer.Beer.Ingredient;
import beer.Beers;

public class BeerJDOMBuilder {

	public static Beers beers = new Beers();
	public static ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	private static final String xmlFilePath = "data.xml";

	public static void main(String[] args) throws JDOMException, IOException {
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
		System.out.println(beers.toString());
	}

}
