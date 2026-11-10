plugins {
    java
    id("xyz.wagyourtail.unimined") version "2.0.0-SNAPSHOT"
}


repositories {
    mavenCentral()

}

unimined {
    nsss {
        version = "1.0"
        side = xyz.wagyourtail.unimined.api.spec.Side.CLIENT
        file("dist.jar")
    }

    mod {
        id = "examplemod"
        name = "examplemod"
        version = "1.0.0"

    }
}

