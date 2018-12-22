package com.tecsup.javawebavanzado.sesion01.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tecsup.javawebavanzado.sesion01.jpa.Categoria;

public class CrearCategoria {
	static EntityManagerFactory emf;
	static EntityManager em;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		emf=Persistence.createEntityManagerFactory("JavaWebAvanzado_sesion01_JPA");
		em=emf.createEntityManager();
		
		try {
			//Empueza la transacc Tx:
			em.getTransaction().begin();
			
			Categoria emp =  new Categoria();
			
			emp.setNombre("Verduras2");
			//emp.setIdcategoria(8);
			emp.setDescripcion("Descripcion de verduras");
			//graba registro
			em.persist(emp);
			//confirma Tx
			em.getTransaction().commit();

		} catch (Exception e) {
			// Deshace Tx
			em.getTransaction().rollback();

			
		}finally {
			
		}
		
		em.close();
		emf.close();

	}

}
