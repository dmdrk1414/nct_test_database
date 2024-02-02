package org.example.constant;

public enum TEST_ENUM {
    TEST("test"),
    ADD("add 2");

    private String name;

    TEST_ENUM(String name) {
        this.name = name;
    }
}
