package com.tecsup.javawebavanzado.sesion01.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tecsup.javawebavanzado.sesion01.jpa.Categoria;
import com.tecsup.javawebavanzado.sesion01.jpa.Producto;

public class CrearProducto2 {

	private static final int CATEGORIA_LACTEOS = 2;
	static EntityManagerFactory emf;
	static EntityManager em;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		emf=Persistence.createEntityManagerFactory("JavaWebAvanzado_sesion01_JPA");
		em=emf.createEntityManager();
		
		try {
			//Empueza la transacc Tx:
			em.getTransaction().begin();
			Categoria cat= em.find(Categoria.class, CATEGORIA_LACTEOS);
			System.out.println(cat);
			
			
			Producto prod2 =  new Producto();
			prod2.setNombre("3NomNuevProduct");
			prod2.setDescripcion("DescripNuevoProducto");
			
			Producto prod3 =  new Producto();
			prod3.setNombre("4NomNuevProduct2");
			prod3.setDescripcion("DescripNuevoProducto2");
			
			cat.addProducto(prod2);
			cat.addProducto(prod3);
			
//			//graba registro
//			em.persist(prod2);
//			em.persist(prod3);
			//confirma Tx
			em.getTransaction().commit();

		} catch (Exception e) {
			// Deshace Tx
			em.getTransaction().rollback();

			
		}finally {
			em.close();
			emf.close();
			
		}
		


	}

}
