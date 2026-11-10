plugins {
    java
    id("xyz.wagyourtail.unimined") version "2.0.0-SNAPSHOT"
}


repositories {
    mavenCentral()

}

unimined {
    bta {
        version = "7.3_04"
        side = xyz.wagyourtail.unimined.api.spec.Side.MERGED
        loader("bta-babric", "0.18.4-bta.11")
    }

    mod {
        id = "examplemod"
        name = "examplemod"
        version = "1.0.0"
        loader("bta-babric") {}

    }
}

