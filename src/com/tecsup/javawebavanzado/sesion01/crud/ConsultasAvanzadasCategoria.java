package com.tecsup.javawebavanzado.sesion01.crud;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tecsup.javawebavanzado.sesion01.jpa.Categoria;

public class ConsultasAvanzadasCategoria {
	static EntityManagerFactory emf;
	static EntityManager em;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		emf = Persistence.createEntityManagerFactory("JavaWebAvanzado_sesion01_JPA");

		em = emf.createEntityManager();

		try {

			// UPPER

			Query qUpper = em.createQuery("select UPPER(e.nombre) from Categoria e");

			List<String> list = qUpper.getResultList();

			for (String e : list)
				System.out.println(" Name = " + e);

			// MAX
			Query qMax = em.createQuery("select MAX(e.idcategoria) from Categoria e");

			Integer result = (Integer) qMax.getSingleResult();

			System.out.println(" Max. Salary = " + result);

			// BETWEEN
			Query qBetween = em.createQuery("select e from Categoria e " + "where e.idcategoria between 101 and 105");

			List<Categoria> listEmp = (List<Categoria>) qBetween.getResultList();

			for (Categoria emp : listEmp) {
				System.out.println(" Categoria  Nombre = " + emp.getNombre());
				System.out.println(" Categoria  Descripcion = " + emp.getDescripcion());
			}

			// LIKE
			Query qLike = em.createQuery("select e from Categoria e " + "where e.nombre LIKE '%L%'");

			List<Categoria> listEmpLike = (List<Categoria>) qLike.getResultList();

			for (Categoria emp : listEmpLike) {
				System.out.println(" Categoria  Nombre = " + emp.getNombre());
				System.out.println(" Categoria  Descripcion = " + emp.getDescripcion());
			}

			// ORDER
			Query qOrder = em.createQuery("select e from Categoria e " + " ORDER BY e.nombre ASC ");

			List<Categoria> listEmpOrder = (List<Categoria>) qOrder.getResultList();

			for (Categoria emp : listEmpOrder) {
				System.out.println(" Categoria  ID = " + emp.getIdcategoria());
				System.out.println(" Categoria  Nombre = " + emp.getNombre());
				System.out.println(" Categoria  Descripcion = " + emp.getDescripcion());
			}

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
