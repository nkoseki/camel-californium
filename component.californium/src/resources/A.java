package resources;

import ch.ethz.inf.vs.californium.coap.GETRequest;
import ch.ethz.inf.vs.californium.coap.Response;
import ch.ethz.inf.vs.californium.coap.registries.CodeRegistry;
import ch.ethz.inf.vs.californium.coap.registries.MediaTypeRegistry;
import ch.ethz.inf.vs.californium.endpoint.resources.LocalResource;

public class A extends LocalResource {

	public A() {
		this("Hello", "aaaaa");
	}

	public A(String str1, String str2) {
		super(str1);
		setTitle(str1);
		setResourcesPath(str2);
	}
	
	@Override
	public void performGET(GETRequest request) {
		//create response
		Response response = new Response(CodeRegistry.RESP_CONTENT);
		
		// set payload
		response.setPayload("HHHHHHHHHHHHHHHHHHEEEEELLLLLLLLLLLLLOOOOOOOOOOOO");
		response.setContentType(MediaTypeRegistry.TEXT_PLAIN);
		
		request.respond(response);
	}
}
