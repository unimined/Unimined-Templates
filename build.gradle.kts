plugins {
    java
    id("xyz.wagyourtail.unimined") version "2.0.0-SNAPSHOT"
}


repositories {
    mavenCentral()

}

unimined {
    bta {
        version.set(providers.gradleProperty("minecraft_version"))
        side = xyz.wagyourtail.unimined.api.spec.Side.MERGED
        loader("bta-babric", "0.18.4-bta.11")
    }

    mod {
        id.set(providers.gradleProperty("modid"))
        name = "examplemod"
        version.set(providers.gradleProperty("version"))
        loader("bta-babric") {}

    }
}

