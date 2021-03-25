package clases;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "marca")
@XmlAccessorType(XmlAccessType.FIELD)
public class Marca implements Serializable{


    private static final long serialVersionUID = -8956150563795146209L;
    @XmlElement
    private String Nombre;

    //@XmlElement(name = "producto")
    @XmlElementWrapper(name = "productos")
    private ArrayList<Producto> productos;
//    @XmlTransient
//    private Empresa empresa;

    public Marca() {
        super();
        productos = new ArrayList<>();
    }

    public String getNombre() {
        return Nombre;
    }


//    public Empresa getEmpresa() {
//        return empresa;
//    }
//
//    public void setEmpresa(Empresa empresa) {
//        this.empresa = empresa;
//    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public void addProducto(Producto e) {
        if(!productos.contains(e))
            productos.add(e);
    }

    public void removeProducto(Producto e) {
        productos.remove(e);
    }
}
