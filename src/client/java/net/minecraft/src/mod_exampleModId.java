package com.example;

import net.minecraft.src.BaseModMp;

public class mod_exampleModId extends BaseModMp {

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public void load() {
        System.out.println("Hello from ExampleMod Client!");
    }

}
