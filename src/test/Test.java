package test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import entidades.Operadora;
import entidades.Tipo;
import entidades.Usuario;

public class Test {

	public static void main(String[] args) {
		
		EntityManager em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		
		Operadora movistar = new Operadora();
		movistar.setOpeNombre("Movistar");
		
		Operadora claro = new Operadora();
		claro.setOpeNombre("Claro");
		
		Operadora cnt = new Operadora();
		cnt.setOpeNombre("CNT");
		
		try {
			em.getTransaction().begin();
			em.persist(movistar);
			em.persist(claro);
			em.persist(cnt);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		
		Tipo movil = new Tipo();
		movil.setTipNombre("Movil");
		
		Tipo convencional = new Tipo();
		convencional.setTipNombre("Convencional");
		
		try {
			em.getTransaction().begin();
			em.persist(movil);
			em.persist(convencional);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		
//		Usuario roby = new Usuario();
//		roby.setUsuNombre("roby");
//		roby.setUsuCedula("0302568720");
//		roby.setUsuCorreo("rserpa@est.ups.edu.ec");
//		
//		Usuario luis = new Usuario();
//		luis.setUsuNombre("luis");
//		luis.setUsuCedula("0123456789");
//		luis.setUsuCorreo("luis@est.ups.edu.ec");
//		
//		try {
//			em.getTransaction().begin();
//			em.persist(roby);
//			em.persist(luis);
//			em.getTransaction().commit();
//		} catch (Exception e) {
//			em.getTransaction().rollback();
//			e.printStackTrace();
//		}
		
		System.out.println("Se creo correctamente :)");
	}

}
