package com.zzidc.entity.jsonserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.zzidc.entity.EurekaServiceProvider;

public class EurekaServiceProviderSerializer extends JsonSerializer<EurekaServiceProvider>{

	@Override
	public void serialize(EurekaServiceProvider value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		gen.writeString(value.getServiceId()+"");
	}

}
