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
}
