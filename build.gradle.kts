import org.jooq.meta.jaxb.Property

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.10"
    id("nu.studer.jooq") version "5.2"
}

group "com.github.ptomaszek.jooq"
version "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.10")

    jooqGenerator("org.jooq:jooq-meta-extensions")
}

jooq {
    configurations {
        create("main") {
            jooqConfiguration.apply {
                logging = org.jooq.meta.jaxb.Logging.WARN
                generator.apply {

                    //for more configuration options see https://www.jooq.org/doc/latest/manual/code-generation/codegen-ddl/
                    database.apply {
                        name = "org.jooq.meta.extensions.ddl.DDLDatabase"
                        properties.add(Property().withKey("scripts").withValue("src/main/resources/db/changelog/*.sql"))
                        properties.add(Property().withKey("sort").withValue("alphanumeric"))
                        properties.add(Property().withKey("defaultNameCase").withValue("lower")) //for PostgreSQL
                    }

                    generate.apply {
                        isFluentSetters = false
                    }

                    target.apply {
                        packageName = "com.github.ptomaszek.db"
                    }
                }
            }
        }
    }
}
