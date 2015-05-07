package beer;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.jdom.JDOMException;
import org.xml.sax.SAXException;

import builder.AbstractBuilder;
import builder.BeerBuilderFactory;


public class Demo {

	public static void main(String[] args) throws JDOMException, IOException, ParserConfigurationException, SAXException {
		BeerBuilderFactory bFactory = new BeerBuilderFactory();
		AbstractBuilder builder = bFactory.createBeertBuilder("jdom");
		builder.buildBeers("data.xml");
		System.out.println(builder.getBeers());
		

	}

}
