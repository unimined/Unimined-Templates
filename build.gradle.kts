plugins {
    java
    id("xyz.wagyourtail.unimined") version "2.0.0-SNAPSHOT"
}


repositories {
    mavenCentral()
    maven("https://maven.minecraftforge.net/")
}

unimined {
    minecraft {
        version.set(providers.gradleProperty("minecraft_version"))

        forge(providers.gradleProperty("forge_version").get())

    }

    mod {
        id.set(providers.gradleProperty("modid"))
        name = "examplemod"
        version.set(providers.gradleProperty("version"))
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

