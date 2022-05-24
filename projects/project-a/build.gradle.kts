plugins {
  id("java")
  id("java-library")
  kotlin("jvm") version "1.5.31"
}

repositories {
  // Use Maven Central for resolving dependencies.
  mavenCentral()
}

dependencies {
  implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.springframework:spring-context:5.3.10")
  implementation("org.springframework:spring-oxm:5.3.10")
  implementation("org.springframework:spring-jdbc:5.3.10")
  implementation("org.springframework.batch:spring-batch-core:4.3.5")

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
    attributes["Implementation-Title"] = "Project A"
    attributes["Implementation-Version"] = project.version
  }
}
