plugins {
    java
    id("xyz.wagyourtail.unimined") version "2.0.1"
}


repositories {
    mavenCentral()

}

unimined {
    bta {
        version = providers.gradleProperty("minecraft_version").get()
        side = xyz.wagyourtail.unimined.api.spec.Side.MERGED
        loader("bta-babric", "0.18.4-bta.11")
    }

    mod {
        id = providers.gradleProperty("modid").get()
        name = "examplemod"
        version = providers.gradleProperty("version").get()
        loader("bta-babric") {}

    }
}

