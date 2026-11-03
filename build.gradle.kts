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
        side = Side.SERVER
        loader("foxloader")
    }
}

    mod {
        id = "unimined"
        name = "Unimined"
        version = "1.0.0"
    loader("foxloader") { }
    }

