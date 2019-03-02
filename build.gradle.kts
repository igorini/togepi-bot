import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel
import org.gradle.plugins.ide.idea.model.IdeaModel
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    val kotlinVersion by extra { "1.3.21" }

    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")
    }
}

val kotlinVersion: String by extra
val kotlinCoroutineVersion = "0.22.5"
val kotlinTwitchBotVersion = "0.0.10"
val koinVersion = "0.9.2"
val exposedVersion = "0.10.1"
val mysqlConnectorVersion = "6.0.6"
val tornadoFxVersion = "1.7.15"
val guavaVersion = "25.0-jre"

plugins {
    java
    application
    idea
    kotlin("jvm") version "1.3.21"
}

application {
    mainClassName = "com.igorini.togepibot.LauncherKt"
    applicationName = "togepi-bot"
    version = "0.0.1"
    group = "com.igorini"
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<JavaExec> {
    jvmArgs = listOf("-Xmx4g")
}

repositories {
    jcenter()
    mavenCentral()
    maven (url = "https://dl.bintray.com/kotlin/exposed")
    mavenLocal()
}

configure<IdeaModel> {
    project {
        languageLevel = IdeaLanguageLevel(JavaVersion.VERSION_1_8)
    }
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}

dependencies {
    // Kotlin
    compile(kotlin("stdlib", kotlinVersion))
    compile(kotlin("reflect", kotlinVersion))
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutineVersion")

    // Kotlin-Twitch-Bot
    compile("com.igorini:kotlin-twitch-bot:$kotlinTwitchBotVersion")

    // Koin
    compile("org.koin:koin-core:$koinVersion")

    // MySQL
    compile("mysql:mysql-connector-java:$mysqlConnectorVersion")

    // Exposed
    compile("org.jetbrains.exposed:exposed:$exposedVersion")

    // TornadoFX
    compile("no.tornado:tornadofx:$tornadoFxVersion")

    // Guava
    compile("com.google.guava:guava:$guavaVersion")
}

/*
task<Wrapper>("wrapper") {
    gradleVersion = "5.1.1"
    distributionUrl = distributionUrl.replace("bin", "all")
}*/
