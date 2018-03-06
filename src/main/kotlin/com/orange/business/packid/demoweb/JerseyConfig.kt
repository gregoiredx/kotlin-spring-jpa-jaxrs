package com.orange.business.packid.demoweb

import org.glassfish.jersey.server.ResourceConfig
import org.springframework.context.ApplicationContext
import javax.inject.Named
import javax.ws.rs.Path


@Named
class JerseyConfig(applicationContext: ApplicationContext) : ResourceConfig() {

    init {
        applicationContext.getBeansWithAnnotation(Path::class.java).values.forEach { register(it) }
    }

}
