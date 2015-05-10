package factory;
import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom.JDOMException;
import org.xml.sax.SAXException;


public class Demo {

	public static void main(String[] args) throws JDOMException, IOException, ParserConfigurationException, SAXException, JAXBException {
		BeerBuilderFactory bFactory = new BeerBuilderFactory();
		AbstractBuilder builder = bFactory.createBeertBuilder("SAX");
		builder.buildBeers("data.xml");
		System.out.println(builder.getBeers());
		

	}

}
