package XMLJar;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Xml {

	public static void main(String[] args) {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		Document documento = null;
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			documento = builder.parse(new File("src/XMLJar/Book.xml"));
			NodeList listaLibros = documento.getElementsByTagName("book");

			for (int i = 0; i < listaLibros.getLength(); i++) {
				Node nodo = listaLibros.item(i);
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) nodo;
					NodeList hijos = e.getChildNodes();
					for (int j = 0; j < hijos.getLength(); j++) {

						Node hijo = hijos.item(j);
						if (hijo.getNodeType() == Node.ELEMENT_NODE) {
							System.out.println("Etiqueta " + hijo.getNodeName() + "--->" + hijo.getTextContent());
						}
					}
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
	
}
