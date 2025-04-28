plugins {
    id("org.sonarqube") version "6.0.1.5171"
    id("com.github.ben-manes.versions") version "0.52.0"
    application
    id("checkstyle")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass.set("hexlet.code.App")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

tasks.test {
    useJUnitPlatform()
}

sonar {
    properties {
        property("sonar.projectKey", "Valo27_java-project-61")
        property("sonar.organization", "valo27")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}
