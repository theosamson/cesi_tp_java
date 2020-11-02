package com.example.demo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StringTest {

    @Test
    public void testConcatenation() {
        String foo = "abc";
        String bar = "def";
        assertEquals("abcdef", foo + bar);
    }

    @Test
    public void testStartsWith() {
        String foo = "abc";
        assertTrue(foo.startsWith("ab"));
    }

}