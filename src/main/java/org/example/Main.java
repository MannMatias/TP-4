package org.example;

import org.hibernate.envers.Audited;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Crear el EntityManagerFactory y EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // Iniciar transacción
        entityManager.getTransaction().begin();

        // Crear entidades
        Domicilio domicilio1 = Domicilio.builder()
                .nombreCalle("Donado")
                .numero(787)
                .build();

        Cliente cliente1 = Cliente.builder()
                .dni(45720510L)
                .apellido("Mann")
                .nombre("Matias")
                .build();

        Factura factura1 = Factura.builder()
                .fecha("20/04/2004")
                .numero(1)
                .total(2500)
                .build();

        DetalleFactura detalle1 = DetalleFactura.builder()
                .cantidad(5)
                .subtotal(750)
                .build();

        DetalleFactura detalle2 = DetalleFactura.builder()
                .cantidad(10)
                .subtotal(1500)
                .build();

        DetalleFactura detalle3 = DetalleFactura.builder()
                .cantidad(4)
                .subtotal(2000)
                .build();

        Articulo art1 = Articulo.builder()
                .cantidad(15)
                .denominacion("Gatorade de Manzana")
                .precio(1200)
                .build();

        Articulo art2 = Articulo.builder()
                .cantidad(20)
                .denominacion("Alfajor Tatin")
                .precio(800)
                .build();

        Articulo art3 = Articulo.builder()
                .cantidad(12)
                .denominacion("Chicles Beldent")
                .precio(1000)
                .build();

        Categoria bebidas = Categoria.builder()
                .denominacion("Bebidas")
                .build();

        Categoria alfajores = Categoria.builder()
                .denominacion("Alfajores")
                .build();

        Categoria chicles = Categoria.builder()
                .denominacion("Chicles")
                .build();

        Categoria beldent = Categoria.builder()
                .denominacion("Beldent")
                .build();

        //Setters

        //Domicilio1
        domicilio1.setCliente(cliente1);
        //Cliente1
        cliente1.setDomicilio(domicilio1);
        cliente1.setFacturas(Set.of(factura1));
        //Factura1
        factura1.setCliente(cliente1);
        factura1.setDetalles(Set.of(detalle1,detalle2,detalle3));
        //Detalle1
        detalle1.setFactura(factura1);
        detalle1.setArticulo(art1);
        //Detalle2
        detalle2.setFactura(factura1);
        detalle2.setArticulo(art2);
        //Detalle3
        detalle3.setFactura(factura1);
        detalle3.setArticulo(art3);
        //Articulo1
        art1.setDetalle(Set.of(detalle1));
        art1.setCategorias(Set.of(bebidas));
        //Articulo2
        art2.setDetalle(Set.of(detalle2));
        art2.setCategorias(Set.of(alfajores));
        //Articulo3
        art3.setDetalle(Set.of(detalle3));
        art3.setCategorias(Set.of(beldent,chicles));

        /*
        Domicilio domicilio1 = entityManager.find(Domicilio.class,1L);
        domicilio1.setNombreCalle("Adolfo Calle");
        domicilio1.setNumero(871);
        entityManager.merge(domicilio1);
        */




        // Cerrar el EntityManager y EntityManagerFactory
        entityManager.persist(factura1);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
