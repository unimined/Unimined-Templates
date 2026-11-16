plugins {
    java
    id("xyz.wagyourtail.unimined") version "2.0.0-SNAPSHOT"
}


repositories {
    mavenCentral()

}

unimined {
    reindev {
        version.set(providers.gradleProperty("minecraft_version"))
        side = xyz.wagyourtail.unimined.api.spec.Side.SERVER
        loader("foxloader")
    }

    mod {
        id.set(providers.gradleProperty("modid"))
        name = "examplemod"
        version.set(providers.gradleProperty("version"))
        loader("foxloader") {}

    }
}

