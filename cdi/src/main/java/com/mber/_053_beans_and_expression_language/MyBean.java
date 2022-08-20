package com.mber._053_beans_and_expression_language;

import lombok.Getter;

import javax.inject.Named;


@Named
public class MyBean { //myBean
    @Getter
    private final String s = "Hi";
}
