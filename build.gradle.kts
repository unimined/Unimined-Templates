plugins {
    java
    id("xyz.wagyourtail.unimined") version "2.0.0-SNAPSHOT"
}


repositories {
    mavenCentral()

}

unimined {
    minecraft {
        version = "1.2.5"
        side = xyz.wagyourtail.unimined.api.spec.Side.CLIENT
        loader("fg1", "0.1.5")
        mappings {
            mcp("legacy",  "6.2-1.2.5")
        }
    }

    mod {
        id = "examplemod"
        name = "examplemod"
        version = "1.0.0"
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

