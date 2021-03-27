package xml;

import clases.Producto;
import clases.Marca;
import java.util.ArrayList;
import java.util.Scanner;

public class CrearObjetos {

    protected Producto crearProducto() {
        Scanner scanner = new Scanner(System.in);
        Producto producto = new Producto();
        System.out.println("Introduce el nombre del producto");
        producto.setNombre(scanner.nextLine());
        System.out.println("Introduce la fecha de publicación del producto separando los elementos con /");
        producto.setFechaDePublicacion(scanner.nextLine());
        System.out.println("Introduce el tipo de producto");
        producto.setTipo(scanner.nextLine());
        System.out.println("Introduce la descripción del producto");
        producto.setDescripcion(scanner.nextLine());
        System.out.println("Introduce el precio de la producto");
        producto.setPrecio(Double.parseDouble(scanner.nextLine()));

        return producto;
    }

    protected Marca crearMarca(ArrayList<Producto> productos) {
        Scanner scanner = new Scanner(System.in);
        Marca marca = new Marca();
        if (productos.isEmpty()) {

            System.out.println("Debes crear los productos antes");
            marca = null;
        } else {
            System.out.println("Introduce el nombre de la marca");
            marca.setNombre(scanner.nextLine());
            System.out.println("Se introducirán las productos en la Marca");
            marca.setProductos(productos);
        }
        return marca;
    }
}
