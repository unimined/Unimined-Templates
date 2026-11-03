plugins {
    java
    id("xyz.wagyourtail.unimined") version "2.0.0-SNAPSHOT"
}


repositories {
    mavenCentral()

}

unimined {
    minecraft {
        version = "b1.7.3"
        side = Side.MERGED
        loader("ornithe", "0.19.5")
        mappings {
            ornitheGenVersion = 2
            feather(2,2)
            nests(1)
            sparrow(2)
        }
    }
}

    mod {
        id = "unimined"
        name = "Unimined"
        version = "1.0.0"
    loader("ornithe") { }
    }
