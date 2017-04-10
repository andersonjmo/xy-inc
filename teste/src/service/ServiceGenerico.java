package service;


import java.util.List;

import javax.ws.rs.core.Response;

import model.GenericModel;



public interface ServiceGenerico {


	
	Response salvar(GenericModel modelo);
	
}
