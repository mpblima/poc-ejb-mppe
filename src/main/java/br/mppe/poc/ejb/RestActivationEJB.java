package br.mppe.poc.ejb;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Esta classe é necessária para a ativaçaão do jax-rs
 * 
 * 
 * @author Marcelo Lima
 *
 */

@ApplicationPath("/v1/")
public class RestActivationEJB extends Application{
	
}
