package sample.component.californium;

import java.util.Map;

import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultComponent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CfComponent extends DefaultComponent{

	private static final transient Log LOG = LogFactory.getLog(CfComponent.class);
	
	@Override
	protected Endpoint createEndpoint(String uri, String remaining,
			Map<String, Object> parameters) throws Exception {
		
		LOG.debug("createEndpoint called");
		
		Endpoint endpoint = new CfEndpoint(uri, this);
		setProperties(endpoint, parameters);
		return endpoint;
	}

}
