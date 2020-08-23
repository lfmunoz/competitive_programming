
plugins {
    application
}

repositories {
    jcenter()
}

dependencies {
    implementation("com.google.guava:guava:26.0-jre")
    implementation("org.assertj:assertj-core:3.10.0")
    testImplementation("junit:junit:4.12")
}

application {
}