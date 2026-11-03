plugins {
    java
    id("xyz.wagyourtail.unimined") version "2.0.0-SNAPSHOT"
}


repositories {
    mavenCentral()

}

unimined {
    nsss {
        side = Side.CLIENT
        file("dist.jar")
    }
}

    mod {
        id = "unimined"
        name = "Unimined"
        version = "1.0.0"

    }

