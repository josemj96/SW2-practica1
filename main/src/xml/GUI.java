package xml;

import clases.Producto;
import clases.Marca;
import java.util.Scanner;
import java.util.ArrayList;

public class GUI {
    Marshalling mrs = new Marshalling();
    CheckXSD vXSD = new CheckXSD();
    CheckDTD vDTD = new CheckDTD();
    VisualizadorObjetos vO = new VisualizadorObjetos();
    CrearObjetos co= new CrearObjetos();
    XQuery XQ= new XQuery();
    XPathBuscar XPS= new XPathBuscar();
    ArrayList<Producto> productoArrayList = new ArrayList();
    Producto producto;
    Marca marca = new Marca();

    private void crearXMLMarca(String Fichero, Marca marca){
        mrs.crearXMLMarca(Fichero, marca);
    }
    private void crearXMLProducto(String nombreProducto, String Fichero){
        mrs.crearXMLProducto(Fichero,vO.buscarProducto(nombreProducto,marca));
    }
    private Producto importarObjetoProducto(String Fichero){
        Producto producto = mrs.importarObjetoProducto(Fichero);
        return producto;
    }
    private Marca importarObjetoMarca(String Fichero){
        Marca marca = mrs.importarObjetoMarca(Fichero);
        return marca;
    }

}
