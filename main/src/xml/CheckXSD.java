package xml;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

public class CheckXSD {
    public static void main(String[] args) {
        File xmlFile = new File("main/files/xml/marca.xml");
        File xsdFile = new File("main/files/xsd/marca.xsd");
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(xsdFile);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile));
            System.out.println(xmlFile + " is valid against the " + xsdFile + " Schema");
        } catch (SAXException ex) {
            System.out.println(xmlFile + " is not valid against the " + xsdFile + " Schema");
            Logger.getLogger(CheckXSD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CheckXSD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
