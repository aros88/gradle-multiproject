plugins {
    id("java")
    id("java-library")
    id("jacoco-report-aggregation")
    id("jvm-test-suite")
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

jacoco {
    toolVersion = "0.8.8"
}

java.sourceCompatibility = JavaVersion.VERSION_1_8
java.targetCompatibility = JavaVersion.VERSION_1_8

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

val rootDir = project.rootProject.projectDir

tasks {
    named<JacocoReport>("testCodeCoverageReport") {
        dependsOn(test)
        reports {
            xml.required.set(false)
            csv.required.set(true)
            csv.outputLocation.set(file("$rootDir/target/$name/coverage.csv"))
            html.outputLocation.set(layout.buildDirectory.dir("$rootDir/target/$name"))
        }
    }

    test {
        finalizedBy(named<JacocoReport>("testCodeCoverageReport"))
        outputs.upToDateWhen { false }
        ignoreFailures = true
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.named("jar", Jar::class.java) {
    manifest {
        attributes["Implementation-Version"] = project.version
    }
}