import xyz.wagyourtail.unimined.api.minecraft.task.RemapJarTask

plugins {
    id("java")
    id("xyz.wagyourtail.unimined") version "1.2.0"
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
    ivy {
        name = "BTA"
        url = uri("https://github.com/Better-than-Adventure/bta-download-repo/releases/download/")
        patternLayout {
            artifact("v[revision]/bta.[ext]")
        }
        content {
            includeModule("com.github.better-than-adventure", "bta")
        }
        metadataSources {
            artifact()
        }
    }
    maven("https://jitpack.io") {
        name = "jitpack"
    }
}

unimined.minecraft {
    side("client")
    version(project.properties["minecraft_version"] as String)

    merged {
        legacyFabric {
            loader(project.properties["fabric_version"] as String)

            // "hacks" to not have mappings
            prodNamespace("official")
            devMappings = null
            customIntermediaries = true
        }
        jarMod {}
    }

    mappings {
        devNamespace("official")
        devFallbackNamespace("official")
    }

    runs.config("client") {
        jvmArgs += listOf("-Dfabric.gameVersion=$minecraftVersion")
    }
}

dependencies {
    "jarMod"("com.github.better-than-adventure:bta:1.7.7.0_02")

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