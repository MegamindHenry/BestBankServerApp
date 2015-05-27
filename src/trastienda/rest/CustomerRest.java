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

		JSONObject jsonObj = new JSONObject();

		try {
			CustomerDAO dao = new CustomerDAO();
            Customer vo = dao.login(username, password);
            if(vo.getUsername() != null) {
                dao.addCount(username, 0);
                jsonObj.put("response", "success");
            } else {
                Integer count = dao.getCounterByUsername(username);
                count++;
                dao.addCount(username, count);
                if(count > 2) {
                    dao.changeStatus(username, 1);
                    jsonObj.put("response", "lock");
                } else {
                    jsonObj.put("response", "fail");
                }
            }

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
            jsonObj.put("response", "error");
		}
		return jsonObj.toString();
	}


}
