package hu.webvalto.springtanfolyam.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {

    Category testObj;

    @BeforeEach
    void setUp() {
        testObj = new Category();
    }

    @Test
    void getId() {
        testObj.setId(1L);
        assertEquals(1L, testObj.getId());
    }
}