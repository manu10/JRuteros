package servletsTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import classesDAO.AdminDAO;
import classesDAO.DifficultyDAO;
import classesDAO.FinalUserDAO;
import classesDAO.GeoPointDAO;
import classesDAO.TrailDAO;
import interfacesDAO.IActivityDAO;
import model.Activity;
import model.Admin;
import model.Difficulty;
import model.FinalUser;
import model.GeoPoint;
import model.Rating;
import model.Trail;
import persistencia.EntityManFact;
import persistencia.FactoryDAO;

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


		response.getWriter().append("TODO: Definir lo de borrado logico(agregando una variable de validez) o fisico (cascade) \n\n\n\n\n\n\n\n\n\n\n ");
		
		response.getWriter().append("Test de Admins: \n");
		String nameAdm;
		AdminDAO adminDao = FactoryDAO.getAdminDAO();
		for (int i=0;i<2;i++){
			nameAdm="admin"+i;
			response.getWriter().append("Creo un usuario con el nombre: "+nameAdm+" \n");		
			Admin admin = new Admin();
			admin.setName(nameAdm);
			response.getWriter().append("Persisto el Admin"+nameAdm+" \n");
			adminDao.create(admin);
		}
		response.getWriter().append("Obtengo todas los admins de la BBDD: \n");
		for (Admin admAux:adminDao.getAll()) {response.getWriter().append("Admin con id"+admAux.getId()+": " +admAux.getName()+"\n");}


		response.getWriter().append("\n\n\nTest de Activity: \n");

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

		response.getWriter().append("\nElimino la actividad "+act1.getName()+" y Obtengo todas la activities de la BBDD: \n");
		iActDAO.delete(act1);
		//TODO: probar update!!!!
		list = (ArrayList<Activity>) iActDAO.getAll();
		i=0;
		for (Activity actAux:list) {response.getWriter().append("Actividad "+i+++": " +actAux.getName()+"\n");}





		response.getWriter().append("\n\n\n\nTest de Difficulty: \n");

		Difficulty dif = new Difficulty();
		DifficultyDAO iDifDAO = FactoryDAO.getDifficultyDAO();

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

		response.getWriter().append("\n\n\n\nTest de Trail: \n");
		String name="Manuel"; 
		response.getWriter().append("Creo un usuario con el nombre: "+name+" \n");		
		FinalUser owner = new FinalUser();
		owner.setName(name);
		String description=" Un Gran Trail!! ";
		String trName="trail muy interesante!! :)";
		response.getWriter().append("Creo un Trail con nombre "+trName+" y descripcion: "+description+" \n");
		Trail tr = new Trail();
		tr.setName(trName);
		tr.setDescription(description);
		FinalUserDAO finUsrDao = FactoryDAO.getFinalUserDAO();
		response.getWriter().append("Persisto el usuario \n");
		finUsrDao.create(owner);
		response.getWriter().append("Asigno al trail recientemente creado: un activity, una difficulty y un owner(user) creados en sus correspondientes tests\n");
		tr.setActivity(act);
		tr.setDifficulty(dif);
		tr.setOwner(owner);

		TrailDAO trailDao = FactoryDAO.getTrailDAO();
		response.getWriter().append("Persisto el Trail \n");
		trailDao.create(tr);		
		response.getWriter().append("Obtengo todas los Trails de la BBDD: \n");
		ArrayList<Trail> list1 = (ArrayList<Trail>)trailDao.getAll();

		for (Trail trAux:list1) {response.getWriter().append("Trail con id: "+trAux.getId()+" => " +trAux.getName()+
				"\n El propietario de este trail es: "+trAux.getOwner().getName()+
				"\n La dificultad de este trail es: "+trAux.getDifficulty().getName()+
				"\n La activity de este trail es: "+trAux.getActivity().getName()+
				"\n\n"
				);}
		
		//TODO: Eliminar del trail!! Para probar el borrado en cascada!cascade=CascadeType.ALL o cascade={CascadeType.REFRESH, CascadeType.MERGE}

		
		
		String name2="Tomas"; 
		response.getWriter().append(" \n \n Creo un usuario con el nombre: "+name2+", ejecuto el metodo \"yoHiceRuta(ruta)\" y persisto \n");		
		FinalUser adventurer = new FinalUser();
		adventurer.setName(name2);
		adventurer.yoHiceRuta(tr);
		finUsrDao.create(adventurer);
		response.getWriter().append("\nEl usuario "+adventurer.getName()+" con id "+adventurer.getId()+" Recorrio los siguientes Trails : \n"); 
		for (Trail trAux:adventurer.getDone()) {response.getWriter().append(trAux.getName()+" (id="+trAux.getId()+")\n");}

		String name3="Tomas Disk"; 
		response.getWriter().append(" \n \n Creo un usuario con el nombre: "+name3+", ejecuto el metodo \"puntuarRuta(ruta,value)\" y persisto \n");		
		FinalUser adventurer2 = new FinalUser();
		finUsrDao.create(adventurer2);
		adventurer2.puntuarRuta(tr, 9);//TODO: Donde validamos??
		finUsrDao.update(adventurer2);
		tr= trailDao.getById(tr.getId());
		List<Rating> lista = (List<Rating>) tr.getRatings();
		//TODO: ARREGLAR, NO ENTENDEMOS PORQUE NO RECUPERA RATINGS!!!
		response.getWriter().append(" \n \n recupero las puntuaciones del trail "+tr.getId()+" Tamaño de la lista de ratings: "+lista.size()+"\n");
		for (Rating rtAux:tr.getRatings()) {response.getWriter().append(rtAux.getRateBy().getName()+ " puntuó con: "+rtAux.getValue()+")\n");}



		response.getWriter().append("\nLa Trail con id "+tr.getId()+" Fue recorrida por"+tr.getDone_by().size()+" usuarios: \n"); 
		for (FinalUser usrAux:tr.getDone_by()) {response.getWriter().append(usrAux.getName()+"(id="+usrAux.getId()+"\n");}


		response.getWriter().append(" \n \n recupero las "+owner.getMyTrails().size()+" Trails que pertenecen al usuario "+owner.getId()+"\n");
		for (Trail trAux:owner.getMyTrails()) {response.getWriter().append(trAux.getName());}

//		Esto esta comentado porque fallaba al agregar los cascade y esta prueba era para borrar en casacada los Geopoints
//		
//		response.getWriter().append("\n\n\n\nTest de GeoPoint y eliminacion de trail y geopoint en cascada: \n");
//
//		GeoPoint gp = new GeoPoint();
//		GeoPoint gp1 = new GeoPoint();
//		
//
//		gp.setLat(57.232323);
//		gp.setLon(47.23222);
//
//		gp1.setLat(67.232323);
//		gp1.setLon(47.23222);
//		tr= trailDao.getById(1L);
//		tr.getPoints().add(gp);
//		tr.getPoints().add(gp1);
//		response.getWriter().append("\n\nActualizamos un trail al que se le agrego una lista de GeoPoints \n");
//		trailDao.update(tr);
//		response.getWriter().append("Obtengo el trail"+tr.getId()+" \n");
//		tr=trailDao.getById(tr.getId());
//		for (GeoPoint gpAux:tr.getPoints()) {response.getWriter().append("geo point  "+gpAux.getId()+"\n");}
//		response.getWriter().append("\nElimino el Trail "+tr.getId()+" e intento obtener los geopoints (no deberia aparecer nada): \n");
//		trailDao.delete(tr);
//		response.getWriter().append(" cantidad de geo points en la BBDD:  "+FactoryDAO.getGeoPointDAO().getAll().size()+"\n");
//
//	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
