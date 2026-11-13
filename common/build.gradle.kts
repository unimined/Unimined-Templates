plugins {
    java
    id("xyz.wagyourtail.unimined") version "2.0.2"
}


repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net/")
    maven("https://maven.minecraftforge.net/")
}

unimined {
    minecraft {
        version = providers.gradleProperty("minecraft_version").get()



    }
}

