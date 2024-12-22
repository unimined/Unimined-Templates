package com.example.fabric;

import com.example.ExampleMod;
import net.fabricmc.api.ModInitializer;

public class ExampleModImpl implements ModInitializer {

    @Override
    public void onInitialize() {
        ExampleMod.run();
    }

    public static void runPlatform() {
        System.out.println("Hello fabric world!");
    }

}
