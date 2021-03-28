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
    XPathBuscar XPB= new XPathBuscar();
    ArrayList<Producto> productoArrayList = new ArrayList();
    Producto producto;
    Marca marca = new Marca();

    private void crearXMLMarca(String Fichero, Marca marca){

        mrs.crearXMLMarca(Fichero, marca);
    }
    private void crearXMLProducto(String nombreProducto, String Fichero){
       System.out.println(marca.getNombre());
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

    public void Menu(){
        Scanner scanner = new Scanner(System.in);
        Integer opcion = -1;
        Integer salir = 0;
        String respuesta ;


        while(opcion != salir){
            System.out.println("Elige una opción, pulsa 0 para salir");
            System.out.println("1= Importar marca, 2=Exportar marca, 3=Importar Producto, 4=Exportar Producto, 5=Crear la marca, 6=Crear producto, 7=Lista de productos , 8=Listar los productos de la marca");
            System.out.println("9=Xpath con la consulta que tu quieras, 10=XPath que cuenta productos cuyo precio <30, 11=XPath de producto con fecha de publicacion 23-07-1996");
            System.out.println("12=Xquery que dice si son distintos a la fecha de publicación 26-10-1998, 13=Xquery que te hace una lista de los productos, 14=XQuery que busca los productos cuyo tipo es Complemento");
            System.out.println("15=Validar DTD, 16=Validar XSD");
            opcion = Integer.parseInt(scanner.nextLine());
            switch(opcion){
                case 0:
                    System.out.println("Saliendo del programa");
                    break;
                case 1:
                    // Importar marca
                    System.out.println("Introduce el nombre del fichero sin la extensión .xml");
                    respuesta = scanner.nextLine();
                    marca= importarObjetoMarca(respuesta + ".xml");
                    productoArrayList=marca.getProductos();
                    vO.listarMarcas(marca);
                    break;
                case 2:
                    //Exportar marca
                    System.out.println("Introduce el nombre del fichero sin la extensión .xml");
                    respuesta = scanner.nextLine();
                    if(respuesta.equals("marca")!= true){
                        crearXMLMarca(respuesta + ".xml",marca);
                    }else{
                        System.out.println("Ese nombre esta prohibido");
                    }

                    break;
                case 3:
                    // Importar Producto
                    System.out.println("Introduce el nombre del fichero sin la extensión del producto");
                    respuesta = scanner.nextLine();
                    producto= importarObjetoProducto(respuesta+ ".xml");
                    productoArrayList.add(producto);
                    vO.listarProductos(producto);
                    break;

                case 4:
                    // Exportar Producto
                    System.out.println("En esta opcion creará el nombre del xml del producto.");
                    System.out.println("Introduce el nombre del producto a exportar");
                    respuesta = scanner.nextLine();
                    crearXMLProducto(respuesta,respuesta+".xml");
                    break;

                case 5:
                    //Crear la Marca
                    marca=co.crearMarca(productoArrayList);
                    vO.listarMarcas(marca);
                    break;
                case 6:
                    //Crear los productos
                    producto=co.crearProducto();
                    productoArrayList.add(producto);
                    vO.listarProductos(producto);
                    break;
                case 7:
                    // Lista de productos
                    for(Producto ele:productoArrayList){
                        System.out.println(ele.getNombre());
                    }
                    break;
                case 8:
                    //Listar los productos de la marca
                    vO.listarMarcas(marca);
                    break;

                case 9:
                    //XPath con la consulta que tú quieras
                    System.out.println("Introduce la consulta de XPath que quieras hacer");
                    respuesta = scanner.nextLine();
                    XPB.Buscador(respuesta);
                    break;

                case 10:
                    //XPath que cuenta productos cuyo precio <30
                    System.out.println("Se están buscando los productos cuyo precio <30");
                    XPB.XpathBuscarTotalProductosPrecioMenor();
                    break;

                case 11:
                    //XPath de producto con fecha de publicacion 23-07-1996
                    System.out.println("Se están buscando los productos con fecha de publicacion 23-07-1996");
                    XPB.XpathBuscarPorFechaDePublicacion();
                    break;

                case 12:
                    //XQuery que dice si los productos son distintos a la fecha de publicación 26-10-1998
                    System.out.println("Se están buscando si los productos son distintos a la fecha de publicación 26-10-1998");
                    XQ.productosPorFechaDePublicacion();
                    break;

                case 13:
                    //XQuery que te hace una lista de los productos
                    System.out.println("Se está haciendo una lista de los productos");
                    XQ.productosPorNombre();
                    break;

                case 14:
                    //XQuery que busca los productos cuyo tipo es Complemento
                    System.out.println("Se está haciendo una lista de los productos cuyo tipo es Complemento");
                    XQ.productosPorTipo();
                    break;

                case 15:
                    // Validacion DTD
                    System.out.println("¿Es valido el xml con su dtd? "+  vDTD.validarXML( "main/files/xml/marca.xml"));
                    break;

                case 16:
                    // Validación XSD
                    System.out.println("Introduce el nombre del XML a validar sin extension: ");
                    respuesta = scanner.nextLine();
                    System.out.println("¿Es valido el xml con su xsd? "+  vXSD.validarXSD("main/files/xsd/marca.xsd", "main/files/xml/"+respuesta+".xml"));
                    break;

                default:
                    System.out.println("Error, introduzca un numero del cero al 16");

            }
        }
    }


}
