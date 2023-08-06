package com.example.transform;

import net.lenni0451.classtransform.InjectionCallback;
import net.lenni0451.classtransform.annotations.CTarget;
import net.lenni0451.classtransform.annotations.CTransformer;
import net.lenni0451.classtransform.annotations.injection.CInject;
import net.minecraft.src.GuiMainMenu;

@CTransformer(GuiMainMenu.class)
public class TransformGuiMainMenu {

    @CInject(method = "initGui", target = @CTarget("HEAD"))
    public void onGuiInit(InjectionCallback callback) {
        System.out.println("Hello from ExampleMod Client, Main menu gui Init!");
    }

}
