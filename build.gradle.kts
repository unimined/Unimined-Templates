plugins {
    java
    id("xyz.wagyourtail.unimined") version "2.0.0-SNAPSHOT"
}


repositories {
    mavenCentral()
    maven("https://maven.minecraftforge.net/")
}

unimined {
    minecraft {
        version = "1.20.1"

        loader("forge", "47.3.0")
        mappings {
            intermediary()
            yarn(10)
        }
    }
}

    mod {
        id = "unimined"
        name = "Unimined"
        version = "1.0.0"
    loader("forge") { }
    }
