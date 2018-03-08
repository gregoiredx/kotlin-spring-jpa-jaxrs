package com.orange.business.packid.demoweb

import org.glassfish.jersey.server.mvc.Viewable
import org.glassfish.jersey.server.mvc.spi.TemplateProcessor
import org.jtwig.JtwigModel
import org.jtwig.JtwigTemplate
import java.io.OutputStream
import javax.inject.Named
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.MultivaluedMap
import javax.ws.rs.ext.Provider


@Named
@Provider
internal class JtwigTemplateProcessor : TemplateProcessor<String> {

    override fun writeTo(templateReference: String, viewable: Viewable, mediaType: MediaType, httpHeaders: MultivaluedMap<String, Any>, out: OutputStream) {
        val jtwigModel = JtwigModel.newModel()
        if (viewable.model is Map<*,*>) {
            (viewable.model as Map<*,*>).forEach {
                if(it.key is String) {
                    jtwigModel.with(it.key as String, it.value)
                }
            }
        } else {
            jtwigModel.with("model", viewable.model)
        }
        val jtwigTemplate = JtwigTemplate.classpathTemplate("templates/${viewable.templateName}.twig")
        jtwigTemplate.render(jtwigModel, out)
    }

    override fun resolve(path: String, mediaType: MediaType): String? {
        return path
    }

}


