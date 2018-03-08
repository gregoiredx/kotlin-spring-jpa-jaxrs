package com.orange.business.packid.demoweb

import org.glassfish.jersey.server.mvc.Template
import javax.inject.Named
import javax.ws.rs.DefaultValue
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.QueryParam

@Named
@Path("hello")
class HelloResource {

    @GET
    fun get(@QueryParam("name") @DefaultValue("world") name: String): String {
        return "hello $name"
    }

    @GET
    @Path("template")
    @Template(name="hello")
    fun getWithTemplate(@QueryParam("name") @DefaultValue("world") name: String): Map<String, Any> {
        return hashMapOf("name" to name)
    }

}
