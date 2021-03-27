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

    protected void crearXMLMarca(String Fichero, Marca marca) {
        try {
            FileWriter fichero = null;
            File file = new File("main/files/xml/" + Fichero);
            comprobarFichero(file);
        } catch (Exception ex){

            System.out.println("La consulta ha fallado");

        }
            try {
                FileWriter fichero = null;
                fichero = new FileWriter("main/files/xml/" + Fichero);
                JAXBContext context = JAXBContext.newInstance(Marca.class);
                Marshaller m = context.createMarshaller();
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                m.marshal(marca, fichero);
                fichero.close();


        } catch (Exception ex) {
            Logger.getLogger(Marshalling.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected Marca importarObjetoMarca(String Fichero){
        Marca marca = new Marca();
        try {

            File file = new File("main/files/xml/" + Fichero);
            JAXBContext jaxbContext = JAXBContext.newInstance(Marca.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            marca = (Marca) jaxbUnmarshaller.unmarshal(file);




        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return marca;
    }

    protected void crearXMLProducto(String Fichero, Producto producto) {
            try {
                FileWriter fichero = null;
                File file = new File("main/files/xml/" + Fichero);
                comprobarFichero(file);
            } catch (Exception ex) {

                System.out.println("La consulta ha fallado");
            }
            try {
                FileWriter fichero = null;
                JAXBContext context = JAXBContext.newInstance(Producto.class);
                Marshaller m = context.createMarshaller();
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                m.marshal(producto, fichero);
                fichero.close();
            } catch (Exception ex) {
                Logger.getLogger(Marshalling.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    protected Producto importarObjetoProducto(String Fichero){
        Producto producto= new Producto();
        try {

            File file = new File("main/files/xml/" + Fichero);
            JAXBContext jaxbContext = JAXBContext.newInstance(Producto.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            producto = (Producto) jaxbUnmarshaller.unmarshal(file);




        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return producto;
    }
}
