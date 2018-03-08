package com.orange.business.packid.demoweb

import org.glassfish.jersey.server.ResourceConfig
import org.springframework.context.ApplicationContext
import javax.inject.Named
import javax.ws.rs.Path
import org.glassfish.jersey.server.mvc.MvcFeature
import javax.ws.rs.ext.Provider


@Named
class JerseyConfig(applicationContext: ApplicationContext) : ResourceConfig() {

    init {
        applicationContext.getBeansWithAnnotation(Path::class.java).values.forEach { register(it) }
        applicationContext.getBeansWithAnnotation(Provider::class.java).values.forEach { register(it) }
        register(MvcFeature::class.java)
    }

}
