package br.mppe.poc.ejb.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.sun.jersey.multipart.FormDataParam;
	
@Path("protocolarAcao/")
@Stateless
public class EndpointProtocolarAcaoEJB {

	@POST
    @Path("{nomeAcao}/")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response ajuizarAcao(@PathParam("nomeAcao") String nomeacao, @FormDataParam("file") InputStream file){
        System.out.println("String de entrada: "+nomeacao);
        try {
        	byte[] upload = file.readAllBytes();
	        if(nomeacao!= null && file!=null && upload.length > 0) {
	        	
	        	File targetFile = new File("/home/mpblima/Uploads/"+nomeacao+".pdf");
	        	
	        	OutputStream gravador = new FileOutputStream(targetFile);
	        	gravador.write(upload);
	        	gravador.flush();
	        	gravador.close();
	        	
	        	return Response.status(Status.OK).entity("Ação ajuizada com sucesso!!!").build();
	        }
	        else {
	        	return Response.status(Status.BAD_REQUEST).entity("Um dos parâmetros (nome da ação ou o arquivo) não foi informado!").build();
	        }
        }
        catch (Exception ex) {
        	return Response.status(Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
    }

}
