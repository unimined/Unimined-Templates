import org.gradle.jvm.tasks.Jar
import xyz.wagyourtail.unimined.api.minecraft.task.RemapJarTask
import xyz.wagyourtail.unimined.expect.task.ExpectPlatformJar

plugins {
    id("java")
    id("xyz.wagyourtail.unimined") version "1.3.12"
    id("xyz.wagyourtail.unimined.expect-platform") version "1.0.5"
}

group = "com.example"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
    maven("https://maven.wagyourtail.xyz/releases")
    maven("https://maven.wagyourtail.xyz/snapshots")
    mavenLocal()
}


repositories {
    maven("https://maven.wagyourtail.xyz/releases") {
        name = "wagyourtail releases"
    }
    maven("https://repo.spongepowered.org/maven") {
        name = "sponge"
    }
    mavenCentral()
}

val minecraft_version: String by project.properties

val forge by sourceSets.creating
val fabric by sourceSets.creating

val forge_version: String by project.properties
val fabric_version: String by project.properties


unimined.minecraft {
    version(minecraft_version)

    mappings {
        mojmap()

        devFallbackNamespace("official")
    }

    accessWidener {

    }


    runs {
        off = true
    }
}
unimined.minecraft(forge) {
    combineWith(sourceSets.main.get())

    neoForge {
        loader(forge_version)
    }

    runs{
        off = false
        all {
            expectPlatform.insertAgent(this@all, "forge", mapOf(
                "xyz/wagyourtail/unimined/expect/annotation/Environment" to "net/neoforged/api/distmarker/OnlyIn",
                "xyz/wagyourtail/unimined/expect/annotation/Environment\$EnvType" to "net/neoforged/api/distmarker/Dist",
                "xyz/wagyourtail/unimined/expect/annotation/Environment\$EnvType.SERVER" to "DEDICATED_SERVER"
            ))
        }
    }

}

unimined.minecraft(fabric) {
    combineWith(sourceSets.main.get())

    fabric {
        loader(fabric_version)
    }

    runs{
        off = false
        all {
            expectPlatform.insertAgent(this@all, "fabric", mapOf(
                "xyz/wagyourtail/unimined/expect/annotation/Environment" to "net/fabricmc/api/Environment",
                "xyz/wagyourtail/unimined/expect/annotation/Environment\$EnvType" to "net/fabricmc/api/EnvType",
            ))
        }
    }

}

dependencies {
    implementation("xyz.wagyourtail.unimined.expect-platform:expect-platform-annotations:1.0.5")
}

tasks.getByName<Jar>("fabricJar") {
    destinationDirectory = temporaryDir
}

tasks.getByName<Jar>("forgeJar") {
    destinationDirectory = temporaryDir
}

tasks.getByName<RemapJarTask>("remapFabricJar") {
    asJar {
        destinationDirectory = temporaryDir
    }
}

tasks.getByName<RemapJarTask>("remapForgeJar") {
    asJar {
        destinationDirectory = temporaryDir
    }
}

val finalFabric = tasks.create("finalFabricJar", ExpectPlatformJar::class) {
    group = "expectPlatform"

    inputFiles = tasks.getByName("remapFabricJar").outputs.files
    platformName = "fabric"

    archiveClassifier = "fabric"

    remap = mapOf(
        "xyz/wagyourtail/unimined/expect/annotation/Environment" to "net/fabricmc/api/Environment",
        "xyz/wagyourtail/unimined/expect/annotation/Environment\$EnvType" to "net/fabricmc/api/EnvType",
    )
}

val finalForge = tasks.create("finalForgeJar", ExpectPlatformJar::class) {
    group = "expectPlatform"

    inputFiles = tasks.getByName("remapForgeJar").outputs.files
    platformName = "forge"

    archiveClassifier = "forge"

    remap = mapOf(
        "xyz/wagyourtail/unimined/expect/annotation/Environment" to "net/neoforged/api/distmarker/OnlyIn",
        "xyz/wagyourtail/unimined/expect/annotation/Environment\$EnvType" to "net/neoforged/api/distmarker/Dist",
        "xyz/wagyourtail/unimined/expect/annotation/Environment\$EnvType.SERVER" to "DEDICATED_SERVER",
    )
}

tasks.build {
    dependsOn(finalForge, finalFabric)
}

tasks.getByName<ProcessResources>("processFabricResources") {
    inputs.property("version", project.version)

    filesMatching("fabric.mod.json") {
        expand("version" to project.version)
    }
}

tasks.getByName<ProcessResources>("processForgeResources") {
    inputs.property("version", project.version)

    filesMatching("META-INF/neoforge.mods.toml") {
        expand("version" to project.version)
    }
}