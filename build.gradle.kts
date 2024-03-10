import xyz.wagyourtail.unimined.api.minecraft.task.RemapJarTask

plugins {
    id("java")
    id("xyz.wagyourtail.unimined") version "1.2.0-SNAPSHOT"
    id("xyz.wagyourtail.jvmdowngrader") version "0.0.1-SNAPSHOT"
}

group = "com.example"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8

    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

repositories {
    mavenCentral()
    maven("https://maven.wagyourtail.xyz/releases")
    maven("https://maven.wagyourtail.xyz/snapshots")
    mavenLocal()
}

val minecraftVersion = project.properties["minecraft_version"] as String

repositories {
    maven("https://maven.wagyourtail.xyz/releases") {
        name = "wagyourtail releases"
    }
    maven("https://repo.spongepowered.org/maven") {
        name = "sponge"
    }
    mavenCentral()
    maven("https://jitpack.io") {
        name = "jitpack"
    }
}

unimined.minecraft {
    version(project.properties["minecraft_version"] as String)

    mappings {
        searge()
        mcp("stable", "12-1.7.10")
    }

    minecraftForge {
        loader(project.properties["forge_version"] as String)
    }
}

dependencies {
    "modImplementation"("com.github.LegacyModdingMC.UniMixins:unimixins-all-1.7.10:"+project.properties["unimixins_version"]+":dev")

}

// allow mixin extra on old forge
tasks.getByName<RemapJarTask>("remapJar") {
    mixinRemap {
        enableMixinExtra()
    }
}

tasks.build {
    dependsOn("remapJar")
}