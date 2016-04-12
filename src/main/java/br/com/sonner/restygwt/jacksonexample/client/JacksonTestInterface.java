package br.com.sonner.restygwt.jacksonexample.client;

import java.util.List;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

@Path("/jacksonExample")
public interface JacksonTestInterface extends RestService{

	
	@GET
	public void testGet(MethodCallback<JacksonComplexObject> cb);

	@GET
	@Path("/testeEnum")
	public void testGetEnum(MethodCallback<List<TipoUm>> cb);

	@GET
	@Path("/getExampleDto")
	public void testExampleDto(MethodCallback<ExampleDto> cb);

	@POST
	public void testPost(JacksonComplexObject obj, MethodCallback<JacksonComplexObject> cb);

	@POST
	@Path("/mapPath")
	public void testPostMap(Map<String,JacksonComplexObject> obj, MethodCallback<JacksonComplexObject> cb);
//
	@POST
	@Path("/mapPathReturnMap")
	public void testPostMapReturnMap(Map<String,JacksonComplexObject> obj, MethodCallback<Map<String,JacksonComplexObject>> cb);

	@PUT
	public void testPut(JacksonComplexObject obj, MethodCallback<JacksonComplexObject> cb);

	@DELETE
	public void testDelete(Integer id, MethodCallback<JacksonComplexObject> cb);

}
