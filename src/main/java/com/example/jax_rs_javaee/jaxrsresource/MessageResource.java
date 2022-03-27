package com.example.jax_rs_javaee.jaxrsresource;

import com.example.jax_rs_javaee.entity.Message;
import com.example.jax_rs_javaee.pojo.MessageResponse;
import com.example.jax_rs_javaee.pojo.Messagepojo;
import com.example.jax_rs_javaee.service.MessageService;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {


    @Inject
    private MessageService messageService;


    @GET
    public MessageResponse getMessages() {

        List<Message> messages = messageService.getMessages();

        MessageResponse response = new MessageResponse();
        response.setMessages(messages);
        response.setDescription("Successfully retrieved messages");

        return response;
    }

    @GET
    @Path("{id}")
    public Response getMessage(@PathParam("id") Long id) {
        Message message = messageService.findMessage(id);
        if (message == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("No message with this id ").build();
        }
        return Response.status(Response.Status.OK).entity(message).build();
    }

    @POST
    @Path("create")
    public Response createMessage(Messagepojo messagepojo) {
        boolean created = messageService.createMessage(messagepojo);

        if (!created) {
            return Response.status(Response.Status.NOT_FOUND).entity("No message with this id ").build();
        }
        return Response.status(Response.Status.OK).entity("Message created successfully").build();
    }

}
