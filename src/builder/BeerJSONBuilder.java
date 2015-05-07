package builder;
import java.io.FileReader;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import beer.Beers;

public class BeerJSONBuilder {
	
	public static void main(String[] args) {
	//	BeerDOMBuilder builder = new BeerDOMBuilder();
		//Beers beers = builder.parserArray();
		
		//ObjectWriter mapper = new ObjectWriter();
		//  mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
		 // mapper.withDefaultPrettyPrinter().writeValueAsString(beers);
		  
	//	 ObjectMapper mapper = new ObjectMapper();
		 
		  
		  
		  
		  // System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectMapper.readValue(json, Object.class)));
	     //   System.out.println(json);
		 // System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(beers));
		  
	/*	ObjectWriter ow =  new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(beers);
		System.out.println(json);*/
		/* ObjectMapper mapper = new ObjectMapper();
		    Beer myObject = mapper.readValue(new FileReader("input.json"), Beer.class);*/
	}
	

}
