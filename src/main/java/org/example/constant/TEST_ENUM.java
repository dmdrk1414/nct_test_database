package org.example.constant;

import lombok.Getter;

@Getter
public enum TEST_ENUM {
    TEST("test"),
    ADD("add 2");

    private String name;

    TEST_ENUM(String name) {
        this.name = name;
    }
}
