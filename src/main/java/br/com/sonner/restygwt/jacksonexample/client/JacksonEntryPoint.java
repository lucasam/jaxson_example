package br.com.sonner.restygwt.jacksonexample.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class JacksonEntryPoint implements EntryPoint {
	public void onModuleLoad() {

		GWT.log("executando entrypoint para jackson");
		Defaults.setServiceRoot("/rest");
		VerticalPanel painelMaster = new VerticalPanel();
		
		RootPanel.get().add(painelMaster);
		
		JacksonTestInterface client = GWT.create(JacksonTestInterface.class);
		VerticalPanel v = new VerticalPanel();
		RootPanel.get().add(v);
		testGet(client,v);
		testPost(client,v);
		testPostMap(client,v);
		testPostMapReturnMap(client,v);
		testPut(client,v);
		testDelete(client,v);
		testEnum(client,v);
		testExampleDto(client,v);
	}

	private void testExampleDto(JacksonTestInterface client, final VerticalPanel v) {
		v.add(new Label("Fazendo testExampleDto"));
		client.testExampleDto(new MethodCallback<ExampleDto>() {

			@Override
			public void onFailure(Method method, Throwable exception) {
				fodeu("testEnum",v, exception);
			}

			@Override
			public void onSuccess(Method method, ExampleDto response) {
				v.add(new Label("testExampleDto Sucesso"));
			}
			
		});
	}

	private void testEnum(JacksonTestInterface client, final VerticalPanel v) {
		v.add(new Label("Fazendo testEnum"));
		client.testGetEnum(new MethodCallback<List<TipoUm>>() {

			@Override
			public void onFailure(Method method, Throwable exception) {
				fodeu("testEnum",v, exception);
			}

			@Override
			public void onSuccess(Method method, List<TipoUm> response) {
				v.add(new Label("testEnum Sucesso"));
			}
		});
	}

	private void testDelete(JacksonTestInterface client, final VerticalPanel v) {
		v.add(new Label("Fazendo testDelete"));
		client.testDelete(1, new MethodCallback<JacksonComplexObject>() {
			
			@Override
			public void onSuccess(Method method, JacksonComplexObject response) {
				v.add(new Label("testDelete Sucesso"));
			}
			
			@Override
			public void onFailure(Method method, Throwable exception) {
				fodeu("testDelete",v, exception);
			}
		});
		
	}

	private void testPut(JacksonTestInterface client, final  VerticalPanel v) {
		v.add(new Label("Fazendo testPut"));
		client.testPut(creteJacksonObject(), new MethodCallback<JacksonComplexObject>() {
			
			@Override
			public void onSuccess(Method method, JacksonComplexObject response) {
				v.add(new Label("testPut Sucesso"));
			}
			
			@Override
			public void onFailure(Method method, Throwable exception) {
				fodeu("testPut",v, exception);
			}
		});
		
	}

	private void testPostMapReturnMap(JacksonTestInterface client, final  VerticalPanel v) {
		// TODO Auto-generated method stub
		v.add(new Label("Fazendo testPostMapReturnMap"));
		JacksonComplexObject obj = creteJacksonObject();
		Map<String,JacksonComplexObject> m = new HashMap<String, JacksonComplexObject>();
		m.put("um", obj);
		client.testPostMapReturnMap(m, new MethodCallback<Map<String,JacksonComplexObject>>() {
			
			@Override
			public void onSuccess(Method method, Map<String,JacksonComplexObject> response) {
				v.add(new Label("testPostMapReturnMap Sucesso"));
			}
			
			@Override
			public void onFailure(Method method, Throwable exception) {
				fodeu("testPostMapReturnMap",v, exception);
			}
		});
	}

	private void testPostMap(JacksonTestInterface client, final  VerticalPanel v) {
		v.add(new Label("Fazendo testPostMap"));
		JacksonComplexObject obj = creteJacksonObject();
		Map<String,JacksonComplexObject> m = new HashMap<String, JacksonComplexObject>();
		m.put("um", obj);
		client.testPostMap(m, new MethodCallback<JacksonComplexObject>() {
			
			@Override
			public void onSuccess(Method method, JacksonComplexObject response) {
				v.add(new Label("testPostMap Sucesso"));
			}
			
			@Override
			public void onFailure(Method method, Throwable exception) {
				fodeu("testPostMap",v, exception);
			}
		});
	}

	private void testPost(JacksonTestInterface client, final VerticalPanel v) {
		v.add(new Label("Fazendo testPost"));
		JacksonComplexObject obj = creteJacksonObject();
		
		client.testPost(obj, new MethodCallback<JacksonComplexObject>() {
			
			@Override
			public void onSuccess(Method method, JacksonComplexObject response) {
				v.add(new Label("testPost Sucesso"));
			}
			
			@Override
			public void onFailure(Method method, Throwable exception) {
				fodeu("testPost",v, exception);
			}
		});
	}

	private JacksonComplexObject creteJacksonObject() {
		JacksonComplexObject obj = new JacksonComplexObject();
		obj.setProp1(1);
		obj.setProp2("obj1");
		
		JacksonComplexObject obj2 = new JacksonComplexObject();
		obj2.setProp1(2);
		obj2.setProp2("obj2");
		obj2.setOther(obj);
		obj.setOther(obj2);
		return obj;
	}

	private void testGet(JacksonTestInterface client, final VerticalPanel v) {
		v.add(new Label("Fazendo testGet"));
		client.testGet(new MethodCallback<JacksonComplexObject>() {

			@Override
			public void onSuccess(Method method, JacksonComplexObject response) {
				v.add(new Label("testGet com sucesso"));
			}

			@Override
			public void onFailure(Method method, Throwable exception) {
				fodeu("testGet",v, exception);
			}

			
		});
	}
	
	private void fodeu(String teste,final VerticalPanel v, Throwable exception) {
		GWT.log("Erro chamando "+ teste, exception);
		
		Label l = new Label(" Fodeu:  "+ teste);
		l.setStyleName("fodeu");
		v.add(l);
	}

}
