package com.icr7.springBootBasics;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.icr7.springBootBasics.JacksonBasics.CustomDeserializer;
import com.icr7.springBootBasics.JacksonBasics.CustomSerializer;
import com.icr7.springBootBasics.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JacksonBasicsTest {
    @Test
    public void testSerialization() throws JsonProcessingException {
        Person person = new Person("ishwar",25);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);
        System.out.println("Serialized Json: "+json);
    }

    @Test
    public void testDeserialization() throws JsonProcessingException {
        String json="{\"name\":\"mohit\",\"age\":23}";
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(json,Person.class);
        System.out.println("Deserialized Object: "+person);
    }

    @Test
    public void testCustomSerialization() throws JsonProcessingException {
        Person person = new Person("icr7",35);
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Person.class, new CustomSerializer());
        objectMapper.registerModule(module);

        String json = objectMapper.writeValueAsString(person);
        System.out.println("custom serialized Json: "+json);
    }

    @Test
    public void testCustomDeserialization() throws JsonProcessingException {
        String json="{\"name\":\"mohit\",\"age\":\"23\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Person.class, new CustomDeserializer());
        objectMapper.registerModule(module);

        Person person = objectMapper.readValue(json,Person.class);
        System.out.println("custom Deserialized Object: "+person);
    }

}
