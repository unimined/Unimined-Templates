plugins {
    java
    id("xyz.wagyourtail.unimined") version "2.0.0-SNAPSHOT"
}


repositories {
    mavenCentral()

}

unimined {
    nsss {
        version = providers.gradleProperty("minecraft_version").get()
        side = xyz.wagyourtail.unimined.api.spec.Side.CLIENT
        file("dist.jar")

    }

    mod {
        id = providers.gradleProperty("modid").get()
        name = "examplemod"
        version = providers.gradleProperty("version").get()

    }
}

