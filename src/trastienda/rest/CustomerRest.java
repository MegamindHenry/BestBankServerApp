package trastienda.rest;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import trastienda.dao.CustomerDAO;
import trastienda.excepcion.DAOExcepcion;
import trastienda.modelo.Customer;


@Path("/Customer")
public class CustomerRest {
	
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String login(@FormParam("username") String username, 
							@FormParam("password") String password) {

		System.out.println("Doing Login......(): " + username);

		JSONObject jsonObj = new JSONObject();
		
		try {
			CustomerDAO dao = new CustomerDAO();
			
			Customer vo = new Customer();
		
			vo = dao.login(username, password);
			
			System.out.println(vo.getFirstName());
			jsonObj.put("estado", "CORRECTO");
						
		} catch (DAOExcepcion e) {
			jsonObj.put("estado", "FALLIDO");
			System.out.println(e.getMessage());
		}
		return jsonObj.toString();
	}
	
	
}
