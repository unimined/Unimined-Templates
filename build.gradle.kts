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

        loader("jarmod", providers.gradleProperty("jarmod_version").get())
        mappings {
            yarn(providers.gradleProperty("yarn_mappings").get().toInt())
        }
    }

    mod {
        id = providers.gradleProperty("modid").get()
        name = "examplemod"
        version = providers.gradleProperty("version").get()
        loader("jarmod") {}

    }
}

dependencies {
    // mods on the classpath — remapped onto your mappings
    // modImplementation("maven:coord")
    // modCompileOnly(...) / modLocalRuntime(...)
    // unimined.loaderApi("fabric", providers.gradleProperty("fabric_api_version").get()) — loader api coords
    // (also records the api modid into mod { depends } automatically)
}

