package com.zzidc.entity.jsonserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.zzidc.entity.EurekaReturnparameter;

public class EurekaServiceProviderSerializer extends JsonSerializer<EurekaReturnparameter>{

	@Override
	public void serialize(EurekaReturnparameter value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		gen.writeString(value.getRparnamesID()+"");
	}

}
