plugins {
  id("java")
  id("java-library")
  kotlin("jvm") version "1.5.31"
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  testImplementation("org.mockito:mockito-core:4.5.1")
  testImplementation("org.mockito:mockito-inline:4.5.1")
  testImplementation("org.assertj:assertj-core:3.11.1")
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
  testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.2")

  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

tasks.withType<Test> {
  useJUnitPlatform()
}

val jar: Jar by tasks
jar.apply {
  archiveFileName.set("${project.name}-${project.version}.jar")
  manifest {
    attributes["Implementation-Title"] = "Lib A"
    attributes["Implementation-Version"] = project.version
  }
}
