import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.23"
    id("org.jetbrains.compose") version "1.6.2"
    kotlin("plugin.serialization") version "1.9.23"
}

group = "com.alfred"
version = "1.1.1"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(compose.desktop.currentOs) //windows_x64)
    implementation("org.jetbrains.skiko:skiko-awt-runtime-windows-x64:0.7.97")
    implementation("org.jetbrains.skiko:skiko:0.7.97")
    implementation("org.jetbrains.compose.ui:ui-util-desktop:1.6.2")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    implementation("org.slf4j:slf4j-log4j12:1.7.36")
    implementation("org.jetbrains.compose.material3:material3-desktop:1.6.2")
    implementation("androidx.collection:collection:1.4.0")
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
            packageVersion = "1.1.1"
        }
    }
}
