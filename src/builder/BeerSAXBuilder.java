package builder;

import java.io.IOException;
import java.util.ArrayList;

import org.jdom.JDOMException;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import factory.AbstractBuilder;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import beer.Beer.Char;
import beer.Beer.Ingredient;
import beer.Beer.Char.Filling;
import beer.Beer;
import beer.Beers;

public class BeerSAXBuilder extends AbstractBuilder {

	private DocumentBuilder docBuilder;

	Beer b;
	private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

	public BeerSAXBuilder() {
		this.beers = new Beers();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			docBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.err.println("Ошибка конфигурации парсера: " + e);
		}
	}

	public void buildBeers(String xmlFilePath) throws JDOMException,
			IOException, ParserConfigurationException, SAXException,
			JAXBException {

		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		DefaultHandler defaultHandler = new DefaultHandler() {

			boolean bBeer = false;
			boolean bName = false;
			boolean bType = false;
			boolean bAl = false;
			boolean bManufacturer = false;
			boolean bIngredient = false;
			boolean bAmount = false;
			boolean bNumberOfTurns = false;
			boolean bTransparency = false;
			boolean bFiltered = false;
			boolean bNutritional = false;
			boolean bFilling = false;
			boolean bMaterial = false;

			String Name = null;
			String Type = null;
			String Al = null;
			String Manufacturer = null;
			String Ingredient = null;
			String Amount = null;
			String NumberOfTurns = null;
			String Transparency = null;
			String Filtered = null;
			String Nutritional = null;
			String Filling = null;
			String Material = null;

			public void startElement(String uri, String localName,
					String qName, Attributes attributes) throws SAXException {

				Amount = attributes.getValue("amount");
				Material = attributes.getValue("material");

				if (qName.equalsIgnoreCase("NAME")) {
					bName = true;
				}
				if (qName.equalsIgnoreCase("TYPE")) {
					bType = true;
				}
				if (qName.equalsIgnoreCase("AL")) {
					bAl = true;
				}
				if (qName.equalsIgnoreCase("MANUFACTURER")) {
					bManufacturer = true;
				}
				if (qName.equalsIgnoreCase("INGREDIENT")) {
					bIngredient = true;
				}
				if (qName.equalsIgnoreCase("AMOUNT")) {
					bAmount = true;
				}
				if (qName.equalsIgnoreCase("NUMBEROFTURNS")) {
					bNumberOfTurns = true;
				}
				if (qName.equalsIgnoreCase("TRANSPARENCTY")) {
					bTransparency = true;
				}
				if (qName.equalsIgnoreCase("FILTERED")) {
					bFiltered = true;
				}
				if (qName.equalsIgnoreCase("NUTRITIONAL")) {
					bNutritional = true;
				}
				if (qName.equalsIgnoreCase("FILLING")) {
					bFilling = true;
				}
				if (qName.equalsIgnoreCase("MATERIAL")) {
					bMaterial = true;
				}

			}

			public void endElement(String uri, String localName, String qName)
					throws SAXException {
				Filling f = null;
				Char c = null;
				//System.out.println(Filling +" , "+Material+" , "+NumberOfTurns+" , "+Transparency+" , "+Filtered+" , "+Nutritional+" , "+Name+" , "+Type+" , "+Al+" , "+Manufacturer);
				//System.out.println(".............. ");
				if (Filling != null && Material != null
						&& NumberOfTurns != null 
						&& Filtered != null && Nutritional != null
						&& Name != null && Type != null && Al != null
						&& Manufacturer != null) {
					
					f = new Filling(Filling, Material);

					c = new Char(NumberOfTurns, Transparency, Filtered,
							Nutritional, f);

					b = new Beer(Name, Type, Al, Manufacturer, ingredients, c);
					beers.add(b);
				}

			}

			public void characters(char ch[], int start, int length)
					throws SAXException {
				if (bBeer) {
					b = new Beer();
					beers.add(b);
					bBeer = false;
				}


				if (bName) {
					Name = new String(ch, start, length);
					bName = false;

				}
				if (bType) {
					Type = new String(ch, start, length);
					bType = false;

				}
				if (bAl) {
					Al = new String(ch, start, length);
					bAl = false;

				}
				if (bManufacturer) {
					Manufacturer = new String(ch, start, length);
					bManufacturer = false;

				}
				if (bIngredient) {
					Ingredient = new String(ch, start, length);
					bIngredient = false;
					ingredients.add(new Ingredient("", Ingredient));
				}
				if (bAmount) {
					Amount = new String(ch, start, length);
					bAmount = false;

				}
				if (bNumberOfTurns) {
					NumberOfTurns = new String(ch, start, length);
					bNumberOfTurns = false;

				}
				if (bTransparency) {
					Transparency = new String(ch, start, length);
					bTransparency = false;

				}
				
				if (bFiltered) {
					Filtered = new String(ch, start, length);
					bFiltered = false;

				}

				if (bNutritional) {
					Nutritional = new String(ch, start, length);
					bNutritional = false;

				}
				if (bFilling) {
					Filling = new String(ch, start, length);
					bFilling = false;

				}

				if (bMaterial) {
					Material = new String(ch, start, length);
					bMaterial = false;

				}

				/*
				 * Char c = new Char(NumberOfTurns, Transparency, Filtered,
				 * Nutritional, new Filling(Filling, Material));
				 * 
				 * b=new Beer(Name, Type, Al, Manufacturer, ingredients, c);
				 */

			}

		};

		saxParser.parse("data.xml", defaultHandler);
	}

}
