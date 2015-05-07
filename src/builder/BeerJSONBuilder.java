package builder;
import java.io.FileReader;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import beer.Beers;

public class BeerJSONBuilder {
	
	public static void main(String[] args) {
		BeerDOMBuilder builder = new BeerDOMBuilder();
		Beers beers = builder.parserArray();
		
	/*	ObjectWriter ow =  new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(beers);
		System.out.println(json);*/
		/* ObjectMapper mapper = new ObjectMapper();
		    Beer myObject = mapper.readValue(new FileReader("input.json"), Beer.class);*/
	}
	

}
