package resources;

import sample.component.californium.CfConsumer;
import sample.component.californium.MyServer;
import ch.ethz.inf.vs.californium.coap.GETRequest;
import ch.ethz.inf.vs.californium.coap.Response;
import ch.ethz.inf.vs.californium.coap.registries.CodeRegistry;
import ch.ethz.inf.vs.californium.coap.registries.MediaTypeRegistry;
import ch.ethz.inf.vs.californium.endpoint.resources.LocalResource;
import org.apache.camel.Exchange;

public class MyResource extends LocalResource {

	MyServer server;
	
	public MyResource(MyServer server){

		//super("Hello");
		//setTitle("Hello");
		//setResourcesPath("aaa");
		super(server.getConsumer().getEndpoint().getUrl());
		setTitle(server.getConsumer().getEndpoint().getUrl());
		setResourcesPath(server.getConsumer().getEndpoint().getPath());
		this.server = server;
		
	}

	
	@Override
	public void performGET(GETRequest request) {

		String result = execute("TESTTESTTEST");

		//create response
		Response response = new Response(CodeRegistry.RESP_CONTENT);
		
		// set payload
		//response.setPayload("HHHHHHHHHHHHHHHHHHEEEEELLLLLLLLLLLLLOOOOOOOOOOOO");
		response.setPayload(result);
		response.setContentType(MediaTypeRegistry.TEXT_PLAIN);
		
		request.respond(response);
	}
	
	private String execute(String str){
		CfConsumer consumer = server.getConsumer();
		Exchange exchange = consumer.getEndpoint().createExchange();
		exchange.getIn().setBody(str);
		try{
			consumer.getProcessor().process(exchange);
		}catch(Exception e){
			consumer.getExceptionHandler().handleException("Error processing exchange", exchange, e);
			return null;
		}
		return exchange.getIn().getBody(String.class);
	}
}
