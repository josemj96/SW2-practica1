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
            try {
                fichero = new FileWriter("main/files/xml/" + Fichero);


                try {
                    JAXBContext context = JAXBContext.newInstance(Marca.class);
                    Marshaller m = context.createMarshaller();
                    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                    m.marshal(marca, fichero);

                } catch (PropertyException ex) {
                    Logger.getLogger(Marshalling.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JAXBException ex) {
                    Logger.getLogger(Marshalling.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(Marshalling.class.getName()).log(Level.SEVERE, null, ex);
            }
            fichero.close();
        } catch (IOException ex) {
            Logger.getLogger(Marshalling.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected Marca importarObjetoMarca(String Fichero){
        Marca marca = new Marca();
        try {

            File file = new File("./main/files/xml/" + Fichero);
            JAXBContext jaxbContext = JAXBContext.newInstance(Marca.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            marca = (Marca) jaxbUnmarshaller.unmarshal(file);


        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return marca;
    }

    protected void crearXMLProducto(String Fichero, Producto producto) {
        System.out.println(producto);
        if(producto!=null){
            try {
                FileWriter fichero = null;
                File file = new File("main/files/xml/" + Fichero);
                comprobarFichero(file);
                try {
                    fichero = new FileWriter("main/files/xml/" + Fichero);


                    try {
                        JAXBContext context = JAXBContext.newInstance(Producto.class);
                        Marshaller m = context.createMarshaller();
                        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                        m.marshal(producto, fichero);

                    } catch (PropertyException ex) {
                        Logger.getLogger(Marshalling.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (JAXBException ex) {
                        Logger.getLogger(Marshalling.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Marshalling.class.getName()).log(Level.SEVERE, null, ex);
                }
                fichero.close();
            } catch (IOException ex) {
                Logger.getLogger(Marshalling.class.getName()).log(Level.SEVERE, null, ex);
            }
    }else{

        System.out.println("No se pudo crear el xml");

    }
}
    protected Producto importarObjetoProducto(String Fichero){
        Producto producto= new Producto();
        try {

            File file = new File("main/files/xml/" + Fichero);
            JAXBContext jaxbContext = JAXBContext.newInstance(Producto.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            producto = (Producto) jaxbUnmarshaller.unmarshal(file);

            System.out.println(producto.getNombre() + " " +producto.getFechaDePublicacion()
                    + " "+ producto.getTipo()+ " "+ producto.getDescripcion() + " " + producto.getPrecio());


        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return producto;
    }
}
