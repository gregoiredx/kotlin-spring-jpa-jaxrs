package com.orange.business.packid.demoweb

import javax.inject.Named
import javax.ws.rs.*
import javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED
import javax.ws.rs.core.MediaType.APPLICATION_JSON
import javax.ws.rs.core.Response
import javax.ws.rs.core.UriBuilder

@Path("users")
@Named
class UserResource(private val userRepository: UserRepository) {

    @GET
    @Produces(APPLICATION_JSON)
    fun getAll(): List<User> {
        return userRepository.findAll()
    }

    @GET
    @Path("{id}")
    @Produces(APPLICATION_JSON)
    fun getById(@PathParam("id") id: String): User {
        return userRepository.getOne(id)
    }

    @POST
    @Consumes(APPLICATION_FORM_URLENCODED)
    @Produces(APPLICATION_JSON)
    fun createUser(@FormParam("email") email: String, @FormParam("firstName") firstName: String?, @FormParam("lastName") lastName: String?): Response? {
        val user = User(email = email, firstName = firstName, lastName = lastName)
        userRepository.save(user)
        return Response.created(UriBuilder.fromPath(user.id).build()).entity(user).build()
    }
}