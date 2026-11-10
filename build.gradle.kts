plugins {
    java
    id("xyz.wagyourtail.unimined") version "2.0.0-SNAPSHOT"
}


repositories {
    mavenCentral()

}

unimined {
    reindev {
        version = "2.9_03"
        side = xyz.wagyourtail.unimined.api.spec.Side.SERVER
        loader("foxloader")
    }

    mod {
        id = "examplemod"
        name = "examplemod"
        version = "1.0.0"
        loader("foxloader") {}

    }
}

