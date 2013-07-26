package sample.component.californium;

import java.net.SocketException;

import resources.MyResource;

import ch.ethz.inf.vs.californium.endpoint.ServerEndpoint;

public class MyServer extends ServerEndpoint{

	CfConsumer consumer;
	
	public MyServer(CfConsumer consumer) throws SocketException {
		super();
		this.consumer = consumer;
		addResource(new MyResource(this));
		
	}
	
	public CfConsumer getConsumer(){
		return consumer;
	}
	

}
