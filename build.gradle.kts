plugins {
  id("java")
  kotlin("jvm") version "1.5.31"
  id("jacoco-report-aggregation")
  id("jvm-test-suite")
}

repositories {
  mavenCentral()
}

jacoco {
  toolVersion = "0.8.8"
}

val rootDir = projectDir
val failedTests = mutableListOf<TestDescriptor>()
val successTests = mutableListOf<TestDescriptor>()
val skippedTests = mutableListOf<TestDescriptor>()

subprojects {
  repositories {
    mavenCentral()
  }

  apply {
    plugin("java")
    plugin("java-library")
    plugin("jacoco-report-aggregation")
    plugin("jvm-test-suite")
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
}
