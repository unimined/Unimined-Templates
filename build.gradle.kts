plugins {
    java
    id("xyz.wagyourtail.unimined") version "2.0.0-SNAPSHOT"
}


repositories {
    mavenCentral()

}

unimined {
    minecraft {
        version.set(providers.gradleProperty("minecraft_version"))
        side = xyz.wagyourtail.unimined.api.spec.Side.MERGED
        loader("ornithe", providers.gradleProperty("ornithe_version").get())
        mappings {
            ornitheGenVersion = 2
            feather(providers.gradleProperty("feather_mappings").get().toInt(), 2)
            nests(1)
            sparrow(2)
        }
    }

    mod {
        id.set(providers.gradleProperty("modid"))
        name = "examplemod"
        version.set(providers.gradleProperty("version"))
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

