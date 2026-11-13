plugins {
    java
    id("xyz.wagyourtail.unimined") version "2.0.1"
}


repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net/")
    maven("https://maven.minecraftforge.net/")
}

unimined {
    minecraft {
        version = providers.gradleProperty("minecraft_version").get()

        loader("fabric", providers.gradleProperty("fabric_version").get())

    }
}

dependencies {
    implementation(project(":common"))
    // modImplementation("maven:coord") — remapped mods
}
