package org.zhumagulova.userservice.controller;

import org.zhumagulova.userservice.dto.UserDto;
import org.zhumagulova.userservice.service.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/users")
public class UserResource {

    @Inject
    UserService userService;

    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service online").build();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/{id}")
    public Response find(@PathParam("id") long id) {
        UserDto userDto = UserDto.fromUser(userService.findById(id));
        return Response.ok().entity(userDto).build();
    }
}