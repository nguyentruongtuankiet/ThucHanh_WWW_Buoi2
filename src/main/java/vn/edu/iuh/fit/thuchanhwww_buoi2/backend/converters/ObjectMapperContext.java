package vn.edu.iuh.fit.thuchanhwww_buoi2.backend.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ObjectMapperContext implements ContextResolver<ObjectMapper> {
    final ObjectMapper mapper = new ObjectMapper();

    public ObjectMapperContext() {
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.findAndRegisterModules();
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return mapper;
    }
}
