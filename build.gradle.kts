plugins {
    java
    id("xyz.wagyourtail.unimined") version "2.0.0-SNAPSHOT"
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net/")
}

unimined {
    minecraft {
        version = "1.20.1"

        loader("fabric", "0.16.0")
        mappings {
            mojmap()
        }
    }

    mod {
        id = "examplemod"
        name = "examplemod"
        version = "1.0.0"
        loader("fabric") {}

    }
}

dependencies {
    // mods on the classpath — remapped onto your mappings
    // modImplementation("maven:coord")
    // modCompileOnly(...) / modLocalRuntime(...)
    // unimined.loaderApi("fabric", "0.92.2+1.20.1") — loader api coords
    // (also records the api modid into mod { depends } automatically)
}

