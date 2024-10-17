plugins {
    kotlin("jvm") version "2.0.0"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.5.21"
    application
}



group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
}
application {
    mainClass.set("org.example.MainKt")
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation("io.ktor:ktor-client-core:2.3.12")
    implementation("io.ktor:ktor-client-cio:2.3.12")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.12")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.12")
    implementation("io.insert-koin:koin-core:4.0.0")
    implementation("ch.qos.logback:logback-classic:1.4.12")
    implementation("io.ktor:ktor-client-logging:2.3.12")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}