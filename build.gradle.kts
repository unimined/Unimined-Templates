plugins {
    java
    id("xyz.wagyourtail.unimined") version "2.0.0-SNAPSHOT"
}


repositories {
    mavenCentral()
    maven("https://maven.wagyourtail.xyz/releases/")
}

unimined {
    minecraft {
        version.set(providers.gradleProperty("minecraft_version"))
        side = xyz.wagyourtail.unimined.api.spec.Side.CLIENT
        loader("fg1", providers.gradleProperty("fg1_version").get())
        mappings {
            mcp(providers.gradleProperty("mcp_channel").get(), providers.gradleProperty("mcp_version").get())
        }
    }

    mod {
        id.set(providers.gradleProperty("modid"))
        name = "examplemod"
        version.set(providers.gradleProperty("version"))
        loader("fg1") {}

    }
}

dependencies {
    // mods on the classpath — remapped onto your mappings
    // modImplementation("maven:coord")
    // modCompileOnly(...) / modLocalRuntime(...)
    // unimined.loaderApi("fabric", "0.92.2+1.20.1") — loader api coords
    // (also records the api modid into mod { depends } automatically)
}

