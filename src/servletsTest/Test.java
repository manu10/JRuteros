package servletsTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import classesDAO.DifficultyDAO;
import classesDAO.FinalUserDAO;
import classesDAO.TrailDAO;
import cosas.EntityManFact;
import cosas.FactoryDAO;
import interfacesDAO.IActivityDAO;
import model.Activity;
import model.Difficulty;
import model.FinalUser;
import model.Trail;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Test de Activity: \n");
		
		Activity act = new Activity();
		IActivityDAO iActDAO = FactoryDAO.getActivityDAO();//Obtengo el DAO de Activity

		String mNameActivity="Cabalgata";
		response.getWriter().append("Creo una nueva Activity y seteo el nombre"+mNameActivity+"\n");
		act.setName(mNameActivity);
		response.getWriter().append("Guardo la activity en la BBDD \n");
		iActDAO.create(act);
		Activity act1= new Activity();
		mNameActivity="Caminata";
		response.getWriter().append("Creo una nueva Activity y seteo el nombre"+mNameActivity+"\n");
		act1.setName(mNameActivity);
		response.getWriter().append("Guardo la activity en la BBDD \n");
		iActDAO.create(act1);
		response.getWriter().append("Obtengo todas la activities de la BBDD: \n");
		ArrayList<Activity> list = (ArrayList<Activity>) iActDAO.getAll();
		int i=0;
		for (Activity actAux:list) {response.getWriter().append("Actividad "+i+++": " +actAux.getName()+"\n");}

		response.getWriter().append("\nBusco la actividad \"Cabalgata\" y encuentro: "+iActDAO.getActivityByName("Cabalgata").getName());

		//TODO: Conectar a la BBDD que nos provee la catedra!
		//TODO: Preguntar: porque se rompe cuando actualizo mas rapido de que se termine de hacer la consulta, se puede solucionar?
		response.getWriter().append("\nElimino la actividad "+act1.getName()+" y Obtengo todas la activities de la BBDD: \n");
		iActDAO.delete(act1);
		list = (ArrayList<Activity>) iActDAO.getAll();
		i=0;
		for (Activity actAux:list) {response.getWriter().append("Actividad "+i+++": " +actAux.getName()+"\n");}
		//TODO: PROBAR RELACION CON TRAIL!
		
		
		
		
response.getWriter().append("\n\n\n\nTest de Difficulty: \n");
		
		Difficulty dif = new Difficulty();
		DifficultyDAO iDifDAO = FactoryDAO.getDifficultyDAO();//Obtengo el DAO de Difficulty

		String mNameDifficulty="Dificil";
		response.getWriter().append("Creo una nueva Difficulty y seteo el nombre"+mNameDifficulty+"\n");
		dif.setName(mNameDifficulty);
		response.getWriter().append("Guardo la Difficulty en la BBDD \n");
		iDifDAO.create(dif);
		Difficulty dif1= new Difficulty();
		mNameDifficulty="Facil";
		response.getWriter().append("Creo una nueva Difficulty y seteo el nombre"+mNameDifficulty+"\n");
		dif1.setName(mNameDifficulty);
		response.getWriter().append("Guardo la Difficulty en la BBDD \n");
		iDifDAO.create(dif1);
		response.getWriter().append("Obtengo todas la Difficulties de la BBDD: \n");
		ArrayList<Difficulty> list0 = (ArrayList<Difficulty>) iDifDAO.getAll();
		int i0=0;
		for (Difficulty difAux:list0) {response.getWriter().append("Difficulty "+i0+++": " +difAux.getName()+"\n");}
		response.getWriter().append("\nElimino la Difficulty "+dif1.getName()+" y Obtengo todas la Difficulties de la BBDD: \n");
		iDifDAO.delete(dif1);
		list0 = (ArrayList<Difficulty>) iDifDAO.getAll();
		i0=0;
		for (Difficulty difAux:list0) {response.getWriter().append("Difficulty "+i0+++": " +difAux.getName()+"\n");}
		
		//TODO: PROBAR RELACION CON TRAIL!
response.getWriter().append("\n\n\n\nTest de Trail: \n");
		
		FinalUser owner = new FinalUser();
		owner.setName("Manuel");
		Trail tr = new Trail();
		FinalUserDAO finUsrDao = FactoryDAO.getFinalUserDAO();
		finUsrDao.create(owner);
		tr.setActivity(act);
		tr.setDifficulty(dif);
		tr.setOwner(owner);
		
		TrailDAO trailDao = FactoryDAO.getTrailDAO();
		tr.setName("trail muy interesante!! :)");
		trailDao.create(tr);
		
		response.getWriter().append("Obtengo todas la Trails de la BBDD: \n");
		ArrayList<Trail> list1 = (ArrayList<Trail>)trailDao.getAll();
		i0=0;
		for (Trail trAux:list1) {response.getWriter().append("Trail "+i0+++": " +trAux.getName()+"\n El propietario de este trail es: "+trAux.getOwner().getName());}

		
		/*
	 Acceso a la Base de Datos

     (Sólo disponible desde la Sala 8)

     Servidor: mysql.java.linti.unlp.edu.ar
     Base de datos: jyaa_sala_bd#      
     Usuario: jyaa_sala_usr# 
     Clave: <solicitar al ayudante>

     #=número de grupo; En nuestro caso => 5

     phpmyadmin --> http://java.linti.unlp.edu.ar/phpmyadmin
		 * 
		 */

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
