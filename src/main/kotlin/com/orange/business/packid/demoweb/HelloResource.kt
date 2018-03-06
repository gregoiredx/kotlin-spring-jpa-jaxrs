package com.orange.business.packid.demoweb

import javax.inject.Named
import javax.ws.rs.DefaultValue
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.QueryParam

@Path("hello")
@Named
class HelloResource {

    @GET
    fun get(@QueryParam("name") @DefaultValue("world") name: String): String {
        return "hello $name"
    }

}
