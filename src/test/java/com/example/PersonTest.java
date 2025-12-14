package com.example;

import com.google.gson.Gson;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Person.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void gsonRoundTripShouldKeepEquality() {
        Gson gson = new Gson();

        Person original = new Person("Pulenko", "Evheniy", 20);
        String json = gson.toJson(original);
        Person restored = gson.fromJson(json, Person.class);

        assertEquals(original, restored);
        assertEquals(original.hashCode(), restored.hashCode());
    }

    @Test
    void equalsShouldReturnFalseForDifferentObjects() {
        Person p1 = new Person("A", "B", 10);
        Person p2 = new Person("A", "B", 11);
        assertNotEquals(p1, p2);
    }
}
