package service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.GenericModel;
import dao.DaoGenerico;
import dao.JpaUtil;

public class ServiceGenericoImpl implements ServiceGenerico {

	
	
	private String sql;

	public ServiceGenericoImpl() {


	}
	
	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvar(GenericModel modelo) {
		try {
			System.out.println(modelo.getNome());
			JpaUtil jp = new JpaUtil();
			jp.persistObject(modelo);
			return Response.ok().build();
		} catch (Exception ex) {
			Map<String, String> responseObj = new HashMap<String, String>();
			responseObj.put("erro", ex.getMessage());
			System.out.println(ex.getMessage());
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(responseObj).build();
		}
	}
	
	
}