plugins {
    java
    id("xyz.wagyourtail.unimined") version "2.0.0-SNAPSHOT"
}


repositories {
    mavenCentral()

}

unimined {
    minecraft {
        version = "1.20.1"

        loader("jarmod", "0.1.5")
        mappings {
            yarn(10)
        }
    }
}

    mod {
        id = "unimined"
        name = "Unimined"
        version = "1.0.0"
    loader("jarmod") { }
    }
