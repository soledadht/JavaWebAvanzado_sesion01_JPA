package com.tecsup.javawebavanzado.sesion01.crud;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tecsup.javawebavanzado.sesion01.jpa.Categoria;


public class BuscarCategoria {

	static EntityManagerFactory emf;
	static EntityManager em;
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		emf = Persistence.createEntityManagerFactory("JavaWebAvanzado_sesion01_JPA");

		em = emf.createEntityManager();

		try {

			Categoria emp = em.find(Categoria.class, 8);

			System.out.println(emp.getNombre());
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			// TODO: handle finally clause
			em.close();
			emf.close();
		}

	}




}
