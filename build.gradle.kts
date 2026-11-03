plugins {
    java
    id("xyz.wagyourtail.unimined") version "2.0.0-SNAPSHOT"
}


repositories {
    mavenCentral()

}

unimined {
    minecraft {
        version = "1.2.5"
        side = Side.CLIENT
        loader("fg1", "0.1.5")
        mappings {
            mcp("legacy", "6.2-1.2.5")
        }
    }
}

    mod {
        id = "unimined"
        name = "Unimined"
        version = "1.0.0"
    loader("fg1") { }
    }
