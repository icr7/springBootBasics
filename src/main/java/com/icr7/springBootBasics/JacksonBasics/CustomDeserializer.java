package com.icr7.springBootBasics.JacksonBasics;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.icr7.springBootBasics.model.Person;

import java.io.IOException;

public class CustomDeserializer extends JsonDeserializer<Person> {
    @Override
    public Person deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        ObjectCodec objectCodec = jsonParser.getCodec();
        JsonNode jsonNode = objectCodec.readTree(jsonParser);
        String name = jsonNode.get("name").textValue();
        int age = Integer.valueOf(jsonNode.get("age").textValue());
        return new Person(name,age);
    }
}
