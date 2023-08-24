package com.curso.springbootdi;
import java.util.Arrays;
import java.util.List;
import com.curso.springbootdi.models.domain.ItemFactura;
import com.curso.springbootdi.models.domain.Producto;
import com.curso.springbootdi.models.service.IServicio;
import com.curso.springbootdi.models.service.MiServicio;
import com.curso.springbootdi.models.service.MiServicioComplejo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Bean("miServicioSimple")
    public IServicio registrarMiServicioSimple(){
        return new MiServicio();
    }

    @Primary
    @Bean("miServicioComplejo")
    public IServicio registrarMiServicioComplejo(){
        return new MiServicioComplejo();
    }

    @Bean("itemsFactura")
    public List<ItemFactura> registrarItems(){
        Producto producto1 = new Producto("Camara",100);
        Producto producto2 = new Producto("Bici",200);

        ItemFactura linea1 = new ItemFactura(producto1,2);
        ItemFactura linea2 = new ItemFactura(producto2,4);

        return Arrays.asList(linea1,linea2);
    }

    @Bean("itemsFacturaOficina")
    @Primary
    public List<ItemFactura> registrarItemsOficina(){
        Producto producto1 = new Producto("Monitor",250);
        Producto producto2 = new Producto("Laptop",500);
        Producto producto3 = new Producto("Impresora",80);
        Producto producto4 = new Producto("Escritorio",300);

        ItemFactura linea1 = new ItemFactura(producto1,2);
        ItemFactura linea2 = new ItemFactura(producto2,1);
        ItemFactura linea3 = new ItemFactura(producto3,1);
        ItemFactura linea4 = new ItemFactura(producto4,1);

        return Arrays.asList(linea1,linea2, linea3, linea4);
    }
}
