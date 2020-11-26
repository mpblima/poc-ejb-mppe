package br.mppe.poc.ejb.rest;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("consultarProtocolo/")
@Stateless
public class EndpointConsultarProtocoloEJB {

    @GET
    @Path("{protocolo}/")
    @Produces({"application/xml","application/json"})
    public Response consultaProtocolo(@PathParam("protocolo") String protocolo){
        System.out.println("Numero do protoculo consultado: "+protocolo);

        if(protocolo.equalsIgnoreCase("0123456789")){
        	return Response.status(Status.OK).entity(String.format("Este protocolo esta vencido há %o dias.",randomDiasVencimento())).build();
        }

        if(protocolo.equalsIgnoreCase("987654321")){
        	return Response.status(Status.OK).entity("Protocolo concluido!").build();
        }

        return Response.status(Status.NO_CONTENT).entity("Protocolo não encontrado!!!").build();
    }

    private int randomDiasVencimento(){
        return (int) (Math.random() *  (1000 - 1)) + 1;
    }
}
