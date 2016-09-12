package services;






import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import model.GeoPoint;


@Path("/rutas/1")
public class RESTService {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	RESTService mRESTService;
	private static List<GeoPoint> list= new ArrayList<>();
	
	public RESTService() {
		
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<GeoPoint> getPoints() {
		return list;
	}

	

	@POST
//	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void addGeoPoint(@FormParam("lat") String lat,
			@FormParam("lon") String lon,
			@Context HttpServletResponse servletResponse) throws IOException {
		GeoPoint geoP = new GeoPoint();
		geoP.setLat(Double.parseDouble(lat));
		geoP.setLon(Double.parseDouble(lon));
		list.add(geoP);
//		servletResponse.sendRedirect("./animals/");
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public boolean deleteGeoPoint(@FormParam("id") String id) {
		if (id.equals("")){
			list.clear();
			return true;
		}
		int idInt=Integer.valueOf(id);
		return eliminarGeoPoint(list,idInt);		
		//El ID es el ID !! No la posicion!! Por eso no elimina 
	}

	private boolean eliminarGeoPoint(List<GeoPoint> list2, int idInt) {
		int index=0;
		for (GeoPoint gp :list2){
			if (gp.getId()==idInt){
				list.remove(index);
				return true;
			}
			index++;
		}
		return false;
	}

}