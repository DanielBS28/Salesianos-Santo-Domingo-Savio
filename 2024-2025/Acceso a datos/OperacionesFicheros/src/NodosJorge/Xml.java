package NodosJorge;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Xml {
	
	static ArrayList<Cliente> obtenerClientes(){
		ArrayList<Cliente> listaClientes = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document documento = null;

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            documento = builder.parse(new File("src/NodosJorge/Clientes.xml")); 
            NodeList listaNodosClientes = documento.getElementsByTagName("cliente");

            for (int i = 0; i < listaNodosClientes.getLength(); i++) {
                Node nodo = listaNodosClientes.item(i);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element nodoCliente = (Element) nodo;

                    int numeroDeCliente = Integer.parseInt(nodoCliente.getElementsByTagName("numerodecliente").item(0).getTextContent());
                    String nombre = nodoCliente.getElementsByTagName("Nombre").item(0).getTextContent();

                    Element nodoDireccion = (Element) nodoCliente.getElementsByTagName("Direccion").item(0);
                    String calle = nodoDireccion.getElementsByTagName("Calle").item(0).getTextContent();
                    String ciudad = nodoDireccion.getElementsByTagName("Ciudad").item(0).getTextContent();
                    String codigoPostal = nodoDireccion.getElementsByTagName("CodigoPostal").item(0).getTextContent();
                    String pais = nodoDireccion.getElementsByTagName("Pais").item(0).getTextContent();

                    Cliente cliente = new Cliente(numeroDeCliente, nombre, calle, ciudad, codigoPostal, pais);

                    listaClientes.add(cliente);
                }
            }

            for (Cliente c : listaClientes) {
                System.out.println(c);
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
		return listaClientes;
	}

    public static void main(String[] args) {

    	ArrayList<Cliente> listaClientes = obtenerClientes();
    	

        for (Cliente c : listaClientes) {
            System.out.println(c);
        }
        
        
    }
    
    /* FORMA RECURSIVA PARA SUBNODOS
     * 
     * public class Xml {

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
                    // Llamada recursiva para procesar todos los nodos, incluyendo anidados
                    procesarNodo(e);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    // Función recursiva para procesar nodos y sus hijos
    private static void procesarNodo(Node nodo) {
        // Si el nodo es de tipo elemento, procesamos su nombre y contenido
        if (nodo.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println("Etiqueta: " + nodo.getNodeName() + " ---> " + nodo.getTextContent());
        }

        // Procesar los hijos del nodo actual
        NodeList hijos = nodo.getChildNodes();
        for (int i = 0; i < hijos.getLength(); i++) {
            Node hijo = hijos.item(i);
            procesarNodo(hijo); // Llamada recursiva para procesar cada hijo
        }
    }
}
     */
    
    
}
