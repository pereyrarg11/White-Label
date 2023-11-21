import com.google.firebase.appdistribution.gradle.firebaseAppDistribution
import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("io.gitlab.arturbosch.detekt")
    // Google services Gradle plugin
    id("com.google.gms.google-services")
    // App Distribution Gradle plugin
    id("com.google.firebase.appdistribution")
    // Crashlytics Gradle plugin
    id("com.google.firebase.crashlytics")
}

val signingPropertiesFile = rootProject.file("signing/signingSecret.properties")
val signingProperties = Properties()
signingProperties.load(FileInputStream(signingPropertiesFile))

android {
    namespace = "com.pereyrarg11.mobile"
    compileSdk = 34

    signingConfigs {
        create("release") {
            keyAlias = signingProperties["KEY_ALIAS"] as String
            keyPassword = signingProperties["KEY_PASSWORD"] as String
            storeFile = file(signingProperties["STORE_FILE"] as String)
            storePassword = signingProperties["STORE_PASSWORD"] as String
        }
    }

    defaultConfig {
        applicationId = "com.pereyrarg11.mobile"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
            firebaseAppDistribution {
                artifactType = "APK"
                serviceCredentialsFile = "api-secrets/app-distribution/services_account_key.json"
                // groups, testers and releaseNotes SHOULD be added on gradle command execution
            }
        }
        debug {
            applicationIdSuffix = ".debug"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    /* Jetpack Compose */
    // Glide
    implementation("com.github.bumptech.glide:compose:1.0.0-beta01")

    /* Firebase */
    // Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:32.6.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-crashlytics")
}