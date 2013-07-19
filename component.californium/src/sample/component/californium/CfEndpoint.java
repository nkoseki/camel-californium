package sample.component.californium;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.impl.DefaultEndpoint;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CfEndpoint extends DefaultEndpoint{

	private static final transient Log LOG = LogFactory.getLog(CfEndpoint.class);
	
	public CfEndpoint(){
	}
	
	public CfEndpoint(String uri, CfComponent component) {
		super(uri, component);
		LOG.debug("CfEndpoint constructor called");
	}

	@Override
	public Consumer createConsumer(Processor processor) throws Exception {
		LOG.debug("CfConsumer called");
		return new CfConsumer(this, processor);
	}

	@Override
	public Producer createProducer() throws Exception {
		return new CfProducer(this);
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
