package factory;

import builder.BeerDOMBuilder;
import builder.BeerJAXBBuilder;
import builder.BeerJDOMBuilder;
import builder.BeerSAXBuilder;

public class BeerBuilderFactory {

	private enum TypeParser {
		SAX, JDOM, DOM,JAXB
	}

	public AbstractBuilder createBeertBuilder(String typeParser) {
		TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
		switch (type) {
		case DOM:
			return new BeerDOMBuilder();
		case JDOM:
			return new BeerJDOMBuilder();
		case SAX:
			return new BeerSAXBuilder();
		case JAXB:
			return new BeerJAXBBuilder();
		default:
			throw new EnumConstantNotPresentException(type.getDeclaringClass(),
					type.name());
		}
	}

}
