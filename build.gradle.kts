plugins {
    kotlin("jvm") version "1.9.21"
    application
}

group = "fr.maynadier"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    // Testing dependencies
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.1")
    testImplementation("org.assertj:assertj-core:3.24.2")

    // Cucumber dependencies
    testImplementation("io.cucumber:cucumber-java:7.14.1")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.14.1")
    testImplementation("org.junit.platform:junit-platform-suite-api:1.10.1")
    testRuntimeOnly("org.junit.platform:junit-platform-suite-engine:1.10.1")
    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("io.cucumber:cucumber-picocontainer:7.15.0")

    testImplementation("org.mockito:mockito-core:5.4.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:5.1.0")
}

application {
    mainClass.set("fr.maynadier.MainKt")
}

tasks.test {
    useJUnitPlatform()
    systemProperty("cucumber.junit-platform.naming-strategy", "long")
}

kotlin {
    jvmToolchain(17)
}
