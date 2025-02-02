package com.example;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;

@Mod(modid = "examplemod", version = "1.0.0", name = "ExampleMod", acceptedMinecraftVersions = "[1.7.10]")
public class ExampleMod {

    public ExampleMod() {
        System.out.println("Hello Forge!");
        System.out.println(Minecraft.getMinecraft());
    }


}
