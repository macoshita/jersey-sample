package com.bugsrock.jerseysample;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.mvc.Viewable;
import org.glassfish.jersey.server.mvc.spi.TemplateProcessor;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;

@Provider
public class HandlebarsProcessor implements TemplateProcessor<Template> {

    private final Handlebars handlebars;

    public HandlebarsProcessor() {
        this.handlebars = new Handlebars();
    }
    
    @Override
    public Template resolve(String path, MediaType mediaType) {
        String ext = ".hbs";
        
        if (!path.endsWith(ext)) {
            path += ext;
        }
        
        
        URL url = this.getClass().getResource(path);
        
        if (url == null) {
            return null;
        }
        
        try {
            return handlebars.compile(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeTo(Template template,
                        Viewable viewable,
                        MediaType mediaType,
                        OutputStream out) throws IOException {
        
        OutputStreamWriter writer = new OutputStreamWriter(out);
        template.apply(viewable.getModel(), writer);
    }

}
