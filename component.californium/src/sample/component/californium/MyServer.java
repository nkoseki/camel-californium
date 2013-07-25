package sample.component.californium;

import java.net.SocketException;

import resources.A;

import ch.ethz.inf.vs.californium.endpoint.ServerEndpoint;

public class MyServer extends ServerEndpoint{

	CfConsumer consumer;
	
	public MyServer(CfConsumer consumer) throws SocketException {
		super();
		this.consumer = consumer;
		addResource(new A(this));
	}
	
	public CfConsumer getConsumer(){
		return consumer;
	}
	

}
