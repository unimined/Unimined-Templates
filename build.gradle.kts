plugins {
    java
    id("xyz.wagyourtail.unimined") version "2.0.2"
}


repositories {
    mavenCentral()
    maven("https://maven.minecraftforge.net/")
}

unimined {
    minecraft {
        version = providers.gradleProperty("minecraft_version").get()

        loader("forge", providers.gradleProperty("forge_version").get())
        mappings {
            mojmap()
        }
    }

    mod {
        id = providers.gradleProperty("modid").get()
        name = "examplemod"
        version = providers.gradleProperty("version").get()
        loader("forge") {}

    }
}

dependencies {
    // mods on the classpath — remapped onto your mappings
    // modImplementation("maven:coord")
    // modCompileOnly(...) / modLocalRuntime(...)
    // unimined.loaderApi("fabric", providers.gradleProperty("fabric_api_version").get()) — loader api coords
    // (also records the api modid into mod { depends } automatically)
}

