plugins {
    kotlin("jvm") version "1.4.10"
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "works.baehyeonwoo.autorestarter"
version = "0.1"

repositories {
    maven("https://papermc.io/repo/repository/maven-public/") // PaperMC
}

dependencies {
    implementation(kotlin("stdlib-jdk8")) // Kotlin
    implementation("com.destroystokyo.paper:paper-api:1.16.4-R0.1-SNAPSHOT") // Paper
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
    }
    javadoc {
        options.encoding = "UTF-8"
    }
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    processResources {
        filesMatching("**/*.yml") {
            expand(project.properties)
        }
    }
}