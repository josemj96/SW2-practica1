package xml;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XPathBuscar {

    public void XpathBuscarTotalProductosPrecioMenor () {

        File xmlFile = new File("main/files/xml/marca.xml");

        String expressionXPath = "count(//marca/productos/productos[precio < 30.0])";
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            XPath xpath = XPathFactory.newInstance().newXPath();
            Double resultado = (Double) xpath.evaluate(expressionXPath, doc, XPathConstants.NUMBER);
            System.out.println("El  número total de productos con precio menor a 30 euros es : " + resultado);

        } catch (Exception ex) {
            System.out.println("La consulta ha fallado");
        }

    }

    public void XpathBuscarPorFechaDePublicacion () {

        File xmlFile = new File("main/files/xml/marca.xml");

        String expressionXPath = "//marca/productos/productos[@fechaDePublicacion = \"23/07/1996\"]";
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            XPath xpath = XPathFactory.newInstance().newXPath();
            String resultado = (String) xpath.evaluate(expressionXPath, doc, XPathConstants.NUMBER);
            System.out.println("El producto con la fecha de publicación 23/07/1996 es : " + resultado);

        } catch (Exception ex) {
            System.out.println("La consulta ha fallado");
        }

    }
}
