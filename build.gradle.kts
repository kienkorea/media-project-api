import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"

    val kotlinVersion = "1.5.20"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
    kotlin("kapt") version kotlinVersion

}

group = "com.example"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // spring-boot
    implementation("org.springframework.boot:spring-boot-starter-web")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    implementation("org.springframework.boot:spring-boot-starter-thymeleaf:2.5.5")
    implementation ("org.apache.tomcat.embed:tomcat-embed-jasper")
    implementation ("javax.servlet:jstl")

    // Deprecated
    // Parse from String to Json using Klaxon
    implementation ("com.beust:klaxon:5.5")

    // PhoneNumberUtils
    implementation("com.googlecode.libphonenumber:libphonenumber:3.5")

    // security
    implementation("org.springframework.boot:spring-boot-starter-security")

    // JWT
    implementation("com.auth0:java-jwt:3.10.3")
    implementation("com.nimbusds:oauth2-oidc-sdk:7.3") // refresh token

    // db
     runtimeOnly("mysql:mysql-connector-java")
    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.querydsl:querydsl-jpa:4.3.1")
    kapt("com.querydsl:querydsl-apt:4.3.1:jpa")

    // https://mvnrepository.com/artifact/io.split.client/java-client
    implementation("io.split.client:java-client:3.3.4")

    // swagger
    implementation("io.springfox:springfox-boot-starter:3.0.0")
    implementation("io.swagger:swagger-annotations:1.5.21")
    implementation("io.swagger:swagger-models:1.5.21")

    //  MySQL Connector/J » 5.1.6
    implementation("mysql:mysql-connector-java:8.0.26")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    //retrofit2
    implementation("com.squareup.retrofit2:retrofit:2.7.1")
    implementation("com.squareup.retrofit2:converter-jackson:2.7.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
