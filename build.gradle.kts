plugins {
    `java-library`
    id("maven-publish")
    id ("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "de.oliver"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
    implementation("com.google.guava:guava:31.1-jre")
}

tasks.shadowJar{
    manifest {
        attributes["Main-Class"] = "de.oliver.Main"
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

