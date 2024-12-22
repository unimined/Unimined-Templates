package com.example;

import xyz.wagyourtail.unimined.expect.annotation.Environment;
import xyz.wagyourtail.unimined.expect.annotation.ExpectPlatform;

public class ExampleMod {

    public ExampleMod() {

    }

    public static void run() {
        runPlatform();
        try {
            clientOnly();
        } catch (Throwable ignored) {}
    }

    @ExpectPlatform
    public static void runPlatform() {
        throw new AssertionError();
    }

    @Environment(Environment.EnvType.CLIENT)
    public static void clientOnly() {
        System.out.println("hello client");
    }

}
