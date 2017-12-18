package es.vcarmen.exameniu2017;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by matinal on 12/12/17.
 */

public class Catalogo {

    static List<Producto> productos = new ArrayList<Producto>();

    public Catalogo() {
    }

    public static List<Producto> getProductos() {
        return productos;
    }

    public static void addProducto(Producto producto){
        productos.add(producto);
    }

//    public static void rellenar(){
//        Producto producto = new Producto(
//               "Producto1",
//                "Descripción de producto 1",
//                5.68f,
//                "categoria",
//                true,
//                new Date()
//        );
//    }

}
