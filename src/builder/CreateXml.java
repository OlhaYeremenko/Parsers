package builder;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class CreateXml {
	public static void main(String[] args) {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory
					.newDocumentBuilder();

			// �������� �������
			Document document = documentBuilder.newDocument();
			Element rootElement = document.createElement("beers");
			document.appendChild(rootElement);

			// Child's ��������� ��������
			Element beer = document.createElement("beer");
			rootElement.appendChild(beer);

			Attr name = document.createAttribute("name");
			name.appendChild(document.createTextNode("name"));
			beer.setAttributeNode(name);

			Element type = document.createElement("type");
			type.appendChild(document.createTextNode("type"));
			beer.appendChild(type);

			Element al = document.createElement("al");
			al.setNodeValue("true");
			beer.appendChild(al);

			// �Manufacturer � �����-�������������;
			Element manufacturer = document.createElement("manufacturer");
			manufacturer.appendChild(document.createTextNode("manufacturer"));
			beer.appendChild(manufacturer);

			// �Ingredients (������ ���� ���������) � �����������: ����, �����,
			// �����, ����� � �. �.;
			Element ingredients = document.createElement("ingredients");
			ingredients.appendChild(document.createTextNode("ingredients"));
			beer.appendChild(ingredients);
			

			// �Chars (������ ���� ���������) � ��������������: ����������
			// �������� (���� �����������), ������������ (� ���������),
			// ������������� ���� ���, ������� �������� (����), ������ �������
			// (����� � �������� ��������).
			Element chars = document.createElement("chars");
			chars.appendChild(document.createTextNode("chars"));
			beer.appendChild(chars);

			// ������ ������� ������� � XML ����
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File("beer.xml"));

			transformer.transform(domSource, streamResult);
			System.out.println("���� ��������!");
		} catch (ParserConfigurationException pce) {
			System.out.println(pce.getLocalizedMessage());
			pce.printStackTrace();
		} catch (TransformerException te) {
			System.out.println(te.getLocalizedMessage());
			te.printStackTrace();
		}
	}

}
