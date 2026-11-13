plugins {
    java
    id("xyz.wagyourtail.unimined") version "2.0.2"
}


repositories {
    mavenCentral()

}

unimined {
    bta {
        version = providers.gradleProperty("minecraft_version").get()

    }

    mod {
        id = providers.gradleProperty("modid").get()
        name = "examplemod"
        version = providers.gradleProperty("version").get()

    }
}

