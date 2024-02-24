package com.icr7.springBootBasics.JacksonBasics;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.icr7.springBootBasics.model.Person;

import java.io.IOException;

public class CustomSerializer extends JsonSerializer<Person> {

    @Override
    public void serialize(Person person, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("naam bata",person.getName());
        jsonGenerator.writeStringField("umar",String.valueOf(person.getAge()));
        jsonGenerator.writeEndObject();
    }
}
