package sample.component.californium;

import org.apache.camel.Endpoint;
import org.apache.camel.Processor;
import org.apache.camel.impl.DefaultConsumer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CfConsumer extends DefaultConsumer{

	private static final transient Log LOG = LogFactory.getLog(CfConsumer.class);
	
	private CfEndpoint endpoint;
	private Processor processor;
	
	public CfConsumer(CfEndpoint endpoint, Processor processor) {
		super(endpoint, processor);
		this.endpoint = endpoint;
		this.processor = processor;
		LOG.debug("CfConsumer constructor called");
	}

	/**
	 * コネクタが起動した時に呼び出される
	 * 
	 * @see org.apache.camel.impl.DefaultConsumer#doStart()
	 */
	protected void doStart() throws Exception {

		LOG.debug("doStart called");
		
		MyServer server = new MyServer(this);
		server.start();
		super.doStart();
	}
	
	protected void doStop() throws Exception{
		LOG.debug("doStop() Called");
		super.doStop();
	}

}
