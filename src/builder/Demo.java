package builder;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.jdom.JDOMException;
import org.xml.sax.SAXException;


public class Demo {

	public static void main(String[] args) throws JDOMException, IOException, ParserConfigurationException, SAXException {
		BeerBuilderFactory bFactory = new BeerBuilderFactory();
		AbstractBuilder builder = bFactory.createBeertBuilder("DOM");
		builder.buildBeers("data.xml");
		System.out.println(builder.getBeers());
		

	}

}
