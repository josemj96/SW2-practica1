package xml;

import clases.Marca;
import clases.Producto;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

public class Marshalling {

    private void comprobarFichero(File fichero){
        if (!fichero.exists()) {
        } else {
            fichero.delete();
            System.out.println("El archivo ya existía y se ha sobrescrito.");
        }
    }

    protected void crearXMLMarca(String nombreFichero, Marca marca) {
        try {
            FileWriter fichero = null;
            File file = new File("main/files/xml/" + nombreFichero);
            comprobarFichero(file);
        } catch (Exception ex){

            System.out.println("La consulta ha fallado");

        }
            try {
                FileWriter fichero = null;
                fichero = new FileWriter("main/files/xml/" + nombreFichero);
                JAXBContext context = JAXBContext.newInstance(Marca.class);
                Marshaller m = context.createMarshaller();
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                m.marshal(marca, fichero);
                fichero.close();


        } catch (Exception ex) {
            Logger.getLogger(Marshalling.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
