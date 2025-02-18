import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.23"
    alias(libs.plugins.compose)
    kotlin("plugin.serialization") version "1.9.23"
}

group = "com.alfred"
version = "1.1.5"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(compose.desktop.currentOs)
    implementation(libs.compose.ui.util.desktop)
    implementation(libs.compose.material3.desktop)
    implementation(libs.skiko)
    implementation(libs.skiko.awt.runtime.windows.x64)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.collection)

    //LOGGING
    implementation(libs.slf4j)
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "19"
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "MainKt"
    }

    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }

    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "KManager"
            packageVersion = "1.1.5"
        }
    }
}
