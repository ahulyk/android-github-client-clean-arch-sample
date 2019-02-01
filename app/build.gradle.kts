import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}
apply {
    plugin("kotlin-android")
    plugin("kotlin-android-extensions")
}

kapt {
    useBuildCache = true
    mapDiagnosticLocations = true
}


android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "net.hulyk.githubclient"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.20")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.1.1")

    implementation("androidx.appcompat:appcompat:1.1.0-alpha01")
    implementation("androidx.core:core-ktx:1.1.0-alpha03")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    val lifecycleVersion = "2.1.0-alpha02"
    implementation("androidx.lifecycle:lifecycle-extensions:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")

    //Dagger
    val daggerVersion = "2.20"
    kapt("com.google.dagger:dagger-compiler:$daggerVersion")
    kapt("com.google.dagger:dagger-android-processor:$daggerVersion")
    implementation("com.google.dagger:dagger:$daggerVersion")
    implementation("com.google.dagger:dagger-android-support:$daggerVersion")

    //Rx
    implementation("io.reactivex.rxjava2:rxjava:2.2.5")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.0")

    //Retrofit
    val okhttpClientVersion = "3.12.1"
    implementation("com.squareup.okhttp3:okhttp:$okhttpClientVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$okhttpClientVersion")
    implementation("com.squareup.okio:okio:2.1.0")

    val retrofitVersion = "2.5.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-jackson:$retrofitVersion")
    implementation("com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion")
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")

    //Jackson
    val jacksonVersion = "2.9.8"
    implementation("com.fasterxml.jackson.core:jackson-core:$jacksonVersion")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation("com.fasterxml.jackson.core:jackson-annotations:$jacksonVersion")

    //Timber
    implementation("com.jakewharton.timber:timber:4.7.1")

//    testImplementation 'junit:junit:4.12'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.0'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.1.1'
}
