package br.com.sonner.restygwt.jacksonexample.server;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.sonner.restygwt.jacksonexample.client.ExampleDto;
import br.com.sonner.restygwt.jacksonexample.client.JacksonComplexObject;
import br.com.sonner.restygwt.jacksonexample.client.TipoUm;

@Path("/jacksonExample")
@Consumes({ MediaType.APPLICATION_JSON})
@Produces({ MediaType.APPLICATION_JSON})

public class JaxsonExampleResource  {
	
	
	@GET
	public JacksonComplexObject get(){
		JacksonComplexObject obj = generateJacksonObjects();

		return obj;
	}

	@GET
	@Path("/testeEnum")
	public List<TipoUm> getEnum(){
		List<TipoUm> l = new LinkedList<TipoUm>();
		l.add(TipoUm.PRIMEIRO);
		l.add(TipoUm.SEGUNDO);
		return l;
	}

	@GET
	@Path("/getExampleDto")
	public ExampleDto testExampleDto(){
		ExampleDto dto = new ExampleDto();
		return dto;
	}

	private JacksonComplexObject generateJacksonObjects() {
		JacksonComplexObject obj = new JacksonComplexObject();
		obj.setProp1(1);
		obj.setProp2("prop2-obj1");

		JacksonComplexObject other = new JacksonComplexObject();
		other.setProp1(2);
		other.setProp2("prop2-obj2");
		obj.setOther(other);
		other.setOther(obj);
		return obj;
	}
	
	@POST
	public JacksonComplexObject testPost(JacksonComplexObject  obj){
		return obj;
	}

	@POST
	@Path("/mapPath")
	public JacksonComplexObject testPostMap(Map<String,JacksonComplexObject> map){
		return map.get("um");
	}

	@POST
	@Path("/mapPathReturnMap")
	public Map<String,JacksonComplexObject> testPostMapReturnMap(Map<String,JacksonComplexObject> obj){
		return obj;
	}

	@PUT
	public JacksonComplexObject testPut(JacksonComplexObject obj){
		return obj;
	}

	@DELETE
	public JacksonComplexObject testDelete(Integer id){
		System.out.println("id passado para o metodo de delete"+id);
		return generateJacksonObjects();
	}
}
