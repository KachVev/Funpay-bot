plugins {
    kotlin("jvm") version "2.1.10"
    kotlin("plugin.serialization") version "2.1.10"
}

group = "dev.kachvev"
version = "1.0-SNAPSHOT"

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
    }
}

subprojects {
    kotlin {
        jvmToolchain(23)
    }
}


dependencies {
    implementation("com.charleskorn.kaml:kaml:0.74.0")
    implementation("org.slf4j:slf4j-api:2.0.17")
    implementation("ch.qos.logback:logback-classic:1.5.18")



    implementation(project(":extensions:files"))
    implementation(project(":extensions:profiler"))
}