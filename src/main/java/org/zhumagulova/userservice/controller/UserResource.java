package org.zhumagulova.userservice.controller;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.zhumagulova.userservice.dto.UserDto;
import org.zhumagulova.userservice.model.User;
import org.zhumagulova.userservice.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Stateless
@Path("/users")
public class UserResource {
    @Inject
    UserService userService;
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/{id}")
    public Response find(@PathParam("id") long id) {
        UserDto userDto = UserDto.fromUser(userService.findById(id));
        return Response.ok().entity(userDto).build();
    }
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<UserDto> getAll() {
        return userService.getAll().stream()
                .map(user -> UserDto.fromUser(user))
                .collect(Collectors.toList());
    }

    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public void createUser(@QueryParam("email") String email, @QueryParam("password") String password) {
        UserDto userDto = new UserDto (email, password);
        User user = userDto.user();
        userService.save(user);
    }
}