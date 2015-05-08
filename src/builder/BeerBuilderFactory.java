package builder;

public class BeerBuilderFactory {

	private enum TypeParser {
		SAX, JDOM, DOM
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
		default:
			throw new EnumConstantNotPresentException(type.getDeclaringClass(),
					type.name());
		}
	}

}
