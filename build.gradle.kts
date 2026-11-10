plugins {
    java
    id("xyz.wagyourtail.unimined") version "2.0.0-SNAPSHOT"
}


repositories {
    mavenCentral()

}

unimined {
    minecraft {
        version = "b1.7.3"
        side = xyz.wagyourtail.unimined.api.spec.Side.MERGED
        loader("ornithe", "0.19.5")
        mappings {
            ornitheGenVersion = 2
            feather(2, 2)
            nests(1)
            sparrow(2)
        }
    }

    mod {
        id = "examplemod"
        name = "examplemod"
        version = "1.0.0"
        loader("ornithe") {}

    }
}

dependencies {
    // mods on the classpath — remapped onto your mappings
    // modImplementation("maven:coord")
    // modCompileOnly(...) / modLocalRuntime(...)
    // unimined.loaderApi("fabric", "0.92.2+1.20.1") — loader api coords
    // (also records the api modid into mod { depends } automatically)
}

