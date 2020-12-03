package tib;
//open-with-other "web browser"
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class MyDomParser {

	public static void main(String[] args) {
     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	try {
		 DocumentBuilder builder = factory.newDocumentBuilder();
		 Document doc = builder.parse("tib/weather.xml");
		 NodeList itemList = doc.getElementsByTagName("item");
		 for (int i = 0; i < itemList.getLength(); i++) {
		Node p = itemList.item(i);
		if (p.getNodeType()==Node.ELEMENT_NODE) {
			Element item = (Element) p;
          String category = item.getAttribute("category");
		NodeList typeList = item.getChildNodes();
		for (int j = 0; j < typeList.getLength(); j++) {
			Node n = typeList.item(j);
			if (n.getNodeType()==Node.ELEMENT_NODE) {
				Element weather = (Element) n;
			System.out.println("¿Âµµ´Â"+category+":"+item.getTagName()+":"+item.getTextContent());
			}
		}
		}
		}
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
