package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.Minecraft;

public class ExampleMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        System.out.println("Hello Fabric world!");
    }
}
