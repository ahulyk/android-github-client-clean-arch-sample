import org.jetbrains.kotlin.gradle.dsl.KotlinCompile

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.5.0-alpha03")
        classpath(kotlin("gradle-plugin", "1.3.20"))
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
    //enable progressive compiler mode and new type inference
    tasks.withType(KotlinCompile::class).all {
        kotlinOptions {
            freeCompilerArgs + "-progressive"
            freeCompilerArgs + "-Xnew-inference"
        }
    }
}

tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}
