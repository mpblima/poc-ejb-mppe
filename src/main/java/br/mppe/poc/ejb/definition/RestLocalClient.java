package br.mppe.poc.ejb.definition;

import javax.ejb.Local;

@Local
public interface RestLocalClient {
	
	public String ProtocolarAcao(String nomeAcao, String file);
	
}
