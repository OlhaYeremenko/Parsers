package builder;

public class BeerBuilderFactory {

	private enum TypeParser {
		SAX, STAX, DOM
	}
	/*
	 * public AbstractBuilder createBuilder(String typeParser) { TypeParser type
	 * = TypeParser.valueOf(typeParser.toUpperCase()); switch (type) { case DOM:
	 * return new DOMBuilder(); case STAX: return new BeerStAXBuilder(); case
	 * SAX: return new BeerSAXBuilder(); default: throw new
	 * EnumConstantNotPresentException( type.getDeclaringClass(), type.name());
	 * }
	 */

}
