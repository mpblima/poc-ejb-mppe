package br.mppe.poc.ejb.rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import br.mppe.poc.ejb.definition.RestLocalClient;

@Path("testeCliente/")
@Stateless
public class ClientTestEJB {
	
	private String pdfTest = "/home/mpblima/violao.pdf";
	
	@Inject
	private RestLocalClient client;
	
	@GET
	public void testaCliente() {
		client.ProtocolarAcao("TesteServico", pdfTest);
	}
}
