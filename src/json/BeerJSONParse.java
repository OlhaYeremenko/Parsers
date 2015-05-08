package json;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.jdom.JDOMException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.xml.sax.SAXException;

import beer.Beer;
import beer.Beer.Char;
import beer.Beer.Char.Filling;
import beer.Beer.Ingredient;
import beer.Beers;
import builder.BeerDOMBuilder;

public class BeerJSONParse {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws JDOMException, IOException,
			ParserConfigurationException, SAXException {

		BeerDOMBuilder builder = new BeerDOMBuilder();

		builder.buildBeers("data.xml");
		// System.out.println(builder.getBeers());

		toJson("beer.json", builder.getBeers());

		ArrayList<Beer> beersJson = new ArrayList<Beer>();

		fromJson("data.json", beersJson);
		System.out.println(beersJson.toString());
		beersJson.clear();

	}

	@SuppressWarnings("unchecked")
	public static void toJson(String path, Beers beers) {
		try (FileWriter writer = new FileWriter(path)) {

			JSONObject main = new JSONObject();
			JSONArray beersO = new JSONArray();
			JSONObject beersListObj = new JSONObject();
			for (Beer beer : beers) {
				JSONObject beerObj = new JSONObject();
				beerObj.put("name", beer.getName());
				beerObj.put("type", beer.getType());
				beerObj.put("Al", beer.getAl());
				beerObj.put("manufacturer", beer.getManufacturer());

				JSONObject ingredients = new JSONObject();
				JSONObject ingredient = new JSONObject();
				for (Ingredient i : beer.getIngredients()) {
					ingredient.put("amount", i.getAmount());
					ingredient.put("value", i.getIngredient());
					ingredients.put("ingerient", ingredient);

				}
				beerObj.put("ingredients", ingredients);

				JSONObject chars = new JSONObject();

				chars.put("numberOfTurns", beer.getChars().getNumberOfTurns());

				chars.put("transparency", beer.getChars().getTransparency());
				chars.put("filtered", beer.getChars().getFiltered());
				chars.put("nutritional", beer.getChars().getNutritional());

				JSONObject filling = new JSONObject();
				filling.put("material", beer.getChars().getFill().getMaterial());
				filling.put("volume", beer.getChars().getFill().getVolume());
				chars.put("filling", filling);

				beerObj.put("chars", chars);

				beersListObj.put("Beer", beerObj);
				beersO.add(beersListObj);
			}
			main.put("Beers", beersListObj);
			writer.write(main.toString());
			System.out.println("File completed!");
		} catch (Exception e) {
			System.out.println("No");
		}

	}

	public static void fromJson(String path, ArrayList<Beer> beers) {

		try {
			List<Beer> bList = new ArrayList<Beer>();
			List<Ingredient> ingrList = null;
			String Name;
			String Type;
			String Al;
			String Manufacturer;
			String Value = null;
			String Amount = null;
			String NumberOfTurns;
			String Transparency;
			String Filtered;
			String Nutritional;
			String Material;
			String Volume;
			FileReader reader = new FileReader(path);
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			JSONArray beerArr = (JSONArray) jsonObject.get("beer");

			for (int i = 0; i < beerArr.size(); i++) {
				JSONObject innerObj = (JSONObject) beerArr.get(i);

				Name = (String) innerObj.get("name");
				Type = (String) innerObj.get("type");
				Al = (String) innerObj.get("al");
				Manufacturer = (String) innerObj.get("manufacturer");

				JSONArray ingredients = (JSONArray) innerObj.get("ingredients");

				ingrList = new ArrayList<Ingredient>();
				ingrList.clear();
				for (int j = 0; j < ingredients.size(); j++) {

					JSONObject ingrObj = (JSONObject) ingredients.get(j);
					Amount = (String) ingrObj.get("amount");
					Value = (String) ingrObj.get("text");
					ingrList.add(new Ingredient(Value, Amount));

				}

				JSONObject chars = (JSONObject) innerObj.get("chars");
				NumberOfTurns = (String) chars.get("numberOfTurns");
				Transparency = (String) chars.get("transparency");
				Filtered = (String) chars.get("filtered");
				Nutritional = (String) chars.get("nutritional");

				JSONObject filling = (JSONObject) chars.get("filling");
				Volume = (String) filling.get("text");
				Material = (String) filling.get("material");

				beers.add(new Beer(Name, Type, Al, Manufacturer, ingrList,
						new Char(NumberOfTurns, Transparency, Filtered,
								Nutritional, new Filling(Volume, Material))));
				System.out.println(beers);

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
