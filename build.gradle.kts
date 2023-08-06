plugins {
    id("java")
    id("xyz.wagyourtail.unimined") version "1.0.2"
}

group = "com.example"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
    maven("https://maven.wagyourtail.xyz/releases")
}

val client by sourceSets.creating
val server by sourceSets.creating

tasks.register<Jar>("clientJar") {
    from(client.output)
    archiveClassifier.set("client")
    manifest {
        attributes(
            "JarModAgent-Transforms" to "exampleModId-client.transform"
        )
    }
}

tasks.register<Jar>("serverJar") {
    from(server.output)
    archiveClassifier.set("server")
    manifest {
        attributes(
            "JarModAgent-Transforms" to "exampleModId-server.transform"
        )
    }
}

val minecraftVersion = project.properties["minecraft_version"] as String

unimined.minecraft(client, server) {
    version(minecraftVersion)
    side(this.sourceSet.name) // a trick because we named them based on the sides

    mappings {
        retroMCP()
        // mcp("legacy", project.properties["mapping_version"] as String)

        stub.withMappings("mcp") {
            c("ModLoader", "net/minecraft/src/ModLoader")
            c("BaseMod", "net/minecraft/src/BaseMod")
            c("ModLoaderMp", "net/minecraft/src/ModLoaderMp")
            c("BaseModMp", "net/minecraft/src/BaseModMp")
            c("mod_exampleModId", "net/minecraft/src/mod_exampleModId")
            // you can add more as you need them...
        }
    }

    jarMod {
        transforms("exampleModId-${sourceSet.name}.transform")

        // WARNING: this will compile your jarmods in a way that'll include patched mojang classes.
        // the benefit is not using JarModAgent at runtime.
        // also, JarModAgent currently doesn't support remapping transforms, so this won't actually work with false...
        // this will be fixed in the future.
        compiletimeTransforms = true
    }
}

dependencies {
    "clientJarMod"("risugami:modloader:${minecraftVersion}")
    "clientJarMod"("modloadermp:modloadermp:${minecraftVersion}:client")

    "serverJarMod"("modloadermp:modloadermp:${minecraftVersion}:server")
}

tasks.withType<JavaCompile> {
    if (JavaVersion.current().isJava9Compatible) {
        options.release.set(8)
    }
}

tasks.jar {
    enabled = false
}