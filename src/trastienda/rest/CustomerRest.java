package trastienda.rest;

import net.sf.json.JSONObject;
import trastienda.dao.CustomerDAO;
import trastienda.excepcion.DAOExcepcion;
import trastienda.modelo.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/Customer")
public class CustomerRest {
	
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String login(@FormParam("username") String username, 
							@FormParam("password") String password) {

		System.out.println("procesing login!!!: " + username);

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
