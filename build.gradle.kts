plugins {
    id("java")
    id("xyz.wagyourtail.unimined") version "1.2.0-SNAPSHOT"
    id("xyz.wagyourtail.jvmdowngrader") version "0.0.1-SNAPSHOT"
}

group = "com.example"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
    maven("https://maven.wagyourtail.xyz/releases")
    maven("https://maven.wagyourtail.xyz/snapshots")
    mavenLocal()
}

val minecraftVersion = project.properties["minecraft_version"] as String


val forgeDowngraded by sourceSets.creating {
    runtimeClasspath += sourceSets.main.get().runtimeClasspath
}

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

unimined.minecraft(sourceSets.main.get(), forgeDowngraded) {
    version(project.properties["minecraft_version"] as String)

    mappings {
        searge()
        mcp("stable", "12-1.7.10")
    }

    minecraftForge {
        loader(project.properties["forge_version"] as String)
//        mixinConfig("modid.mixins.json")
    }

    defaultRemapJar = false

    if (sourceSet == sourceSets.main.get()) {
        runs.off = true
    }

    if (sourceSet == forgeDowngraded) {
        remap(jvmdg.defaultShadeTask.get(), "remapJar") {
            archiveClassifier = "final"
        }
    }
}

dependencies {
    "modImplementation"("com.github.LegacyModdingMC.UniMixins:unimixins-all-1.7.10:"+project.properties["unimixins_version"]+":dev")

    "forgeDowngradedImplementation"("xyz.wagyourtail.jvmdowngrader:jvmdowngrader-java-api:${jvmdg.version}:downgraded-8")
    "forgeDowngradedImplementation"(jvmdg.defaultTask.get().outputs.files)

}

tasks.compileJava {
    options.release.set(17)
}

tasks.build {
    dependsOn("remapJar")
}