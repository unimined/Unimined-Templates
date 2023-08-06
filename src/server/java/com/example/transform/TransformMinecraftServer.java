package com.example.transform;

import net.lenni0451.classtransform.InjectionCallback;
import net.lenni0451.classtransform.annotations.CTarget;
import net.lenni0451.classtransform.annotations.CTransformer;
import net.lenni0451.classtransform.annotations.injection.CInject;
import net.minecraft.server.MinecraftServer;

@CTransformer(MinecraftServer.class)
public class TransformMinecraftServer {

    @CInject(method = "startServer", target = @CTarget(value = "CONSTANT", target = "string enable-query", shift = CTarget.Shift.BEFORE))
    public void afterServerLoaded(InjectionCallback callback) {
        System.out.println("Hello from ExampleMod Server, Server Loaded!");
    }

}
