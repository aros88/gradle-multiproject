plugins {
  id("qai.java-conventions")
  application
}

dependencies {
  implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.springframework:spring-oxm:5.3.10")
  implementation("org.springframework:spring-jdbc:5.3.10")
  implementation("org.springframework.batch:spring-batch-core:4.3.5")
  implementation("org.postgresql:postgresql:42.3.5")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8")
  implementation(project(":libs:lib-a"))
  implementation(project(":projects:project-a"))

  testImplementation("org.mockito:mockito-core:4.5.1")
  testImplementation("org.mockito:mockito-inline:4.5.1")
  testImplementation("org.assertj:assertj-core:3.11.1")
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
  testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.2")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

tasks.named("jar", Jar::class.java) {
  manifest {
    attributes["Implementation-Title"] = "Project A"
  }
}

application {
  // need to add Kt as Kotlin generates all files in Java with that at the end.
  mainClass.set("com.example.projectb.StartProjectKt")
}
