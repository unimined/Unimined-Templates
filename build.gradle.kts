plugins {
    java
    id("xyz.wagyourtail.unimined") version "2.0.0-SNAPSHOT"
}


repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net/")
}

unimined {
    minecraft {
        version = "26.3"

        loader("fabric", "0.20.1")

    }
}

    mod {
        id = "unimined"
        name = "Unimined"
        version = "1.0.0"
    loader("fabric") { }
    }
