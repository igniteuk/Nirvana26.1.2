plugins {
    // Standard vanilla gradle helper for multi-project management
    id("architectury-plugin") version "3.4-SNAPSHOT" apply false
    id("dev.architectury.loom") version "1.7-SNAPSHOT" apply false
}

subprojects {
    tasks.withType<JavaCompile>().configureEach {
        options.encoding = "UTF-8"
        // Target Java 25 for Minecraft 26.1.2+
        options.release.set(25)
    }

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(25))
        withSourcesJar()
    }

    repositories {
        mavenCentral()
        
        // Mojang's official library repository
        maven {
            name = "Mojang"
            url = uri("https://libraries.minecraft.net/")
        }

        // Necessary for NeoForge and modern build mappings
        maven {
            name = "NeoForge"
            url = uri("https://maven.neoforged.net/releases/")
        }

        // Necessary for Fabric components if compiling the Fabric subproject
        maven {
            name = "Fabric"
            url = uri("https://maven.fabricmc.net/")
        }

        // Kept from original script for dependencies like JEI
        maven {
            url = uri("https://maven.blamejared.com/")
            content { includeGroup("mezz.jei") }
        }

        // Kept for MixinExtras which is heavily used in 26.x ecosystems
        maven {
            url = uri("https://jitpack.io")
            content { includeGroup("com.github.llamalad7.mixinextras") }
        }
    }
}
