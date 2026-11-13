plugins {
    java
    id("xyz.wagyourtail.unimined") version "2.0.1"
}


repositories {
    mavenCentral()

}

unimined {
    minecraft {
        version = providers.gradleProperty("minecraft_version").get()
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
        id = providers.gradleProperty("modid").get()
        name = "examplemod"
        version = providers.gradleProperty("version").get()
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

