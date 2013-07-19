package sample.component.californium;

import java.net.SocketException;

import resources.A;

import ch.ethz.inf.vs.californium.endpoint.ServerEndpoint;

public class MyServer extends ServerEndpoint{

	public MyServer() throws SocketException {
		super();
		addResource(new A());
	}

}
