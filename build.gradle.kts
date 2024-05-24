plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation ("io.rest-assured:rest-assured:4.3.0")
    testImplementation ("com.google.code.gson:gson:2.8.6")
}

tasks.test {
    useJUnitPlatform()
}