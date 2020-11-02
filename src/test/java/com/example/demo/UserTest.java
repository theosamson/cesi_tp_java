package com.example.demo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void testConcatenationNomPrenom() {

        User n = new User();
        n.setName("toto");
        n.setEmail("toto@toto.fr");

            assertEquals("toto toto@toto.fr", n.toString());
    }

}