package xml;

import clases.Producto;
import clases.Marca;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VisualizadorObjetos {

    protected void listarProductos(Producto producto) {
        if (producto != null) {
            System.out.println("Este es el nombre del producto elegido :" + producto.getNombre());
            System.out.println("Esta es la fecha de publicación del producto elegido :" + producto.getFechaDePublicacion());
            System.out.println("El tipo de producto es :" + producto.getTipo());
            System.out.println("la descripción del producto es :" + producto.getDescripcion());
            System.out.println("El precio del producto es :" + producto.getPrecio());
        }

    }

    protected void listarMarcas(Marca marca) {
        if (marca != null) {
            System.out.println("Este es el nombre de la marca :" + marca.getNombre());
            System.out.println("Estos son sus productos:");
            for (Producto producto : marca.getProductos()) {
                System.out.println(producto.getNombre());
            }
        }

    }

    protected Producto buscarProducto(String nombreProducto, Marca marca) {

        for (Producto producto : marca.getProductos()) {

            if (producto.getNombre().equals(nombreProducto)) {
                return producto;
            }
        }
        System.out.println("No existe el producto");
        return null;
    }

}
