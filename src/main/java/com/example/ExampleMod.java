package com.example;

import cpw.mods.fml.common.Mod;
import net.minecraft.client.Minecraft;

@Mod(modid = "examplemod", version = "1.0.0", name = "ExampleMod", acceptedMinecraftVersions = "[1.7.10]")
public record ExampleMod() {

    public ExampleMod() {
        System.out.println("Hello Forge!");
        System.out.println(Minecraft.getMinecraft());
    }


}
