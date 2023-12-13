import com.google.firebase.appdistribution.gradle.firebaseAppDistribution
import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("io.gitlab.arturbosch.detekt")
    // Dagger Hilt
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    // Google services Gradle plugin
    id("com.google.gms.google-services")
    // App Distribution Gradle plugin
    id("com.google.firebase.appdistribution")
    // Crashlytics Gradle plugin
    id("com.google.firebase.crashlytics")
}

android {
    namespace = "com.pereyrarg11.mobile"
    compileSdk = 34

    signingConfigs {
        create("release") {
            val (storePathProp, storePassProp, keyAliasProp, keyPassProp) =
                getSigningPropertiesByFlavorName(this.name)
            keyAlias = keyAliasProp
            keyPassword = keyPassProp
            storeFile = file(storePathProp)
            storePassword = storePassProp
        }
        getByName("debug") {
            val (storePathProp, storePassProp, keyAliasProp, keyPassProp) =
                getSigningPropertiesByFlavorName(this.name)
            keyAlias = keyAliasProp
            keyPassword = keyPassProp
            storeFile = file(storePathProp)
            storePassword = storePassProp
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
        firebaseAppDistribution {
            artifactType = "APK"
            serviceCredentialsFile = "secrets/google_service_account/white-label-ef4bc-49710878f259.json"
            // groups, testers and releaseNotes SHOULD be added on gradle command execution
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
        }
        debug {
            applicationIdSuffix = ".debug"
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
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
    hilt {
        enableAggregatingTask = true
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

    // TODO: define version as a constant
    /* Dependency Injection */
    implementation("com.google.dagger:hilt-android:2.48.1")
    kapt("com.google.dagger:hilt-android-compiler:2.48.1")

    /* Firebase */
    // Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:32.6.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-crashlytics")
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}

/**
 * Returns an array of strings with the next values:
 * STORE_FILE, STORE_PASSWORD, KEY_ALIAS, KEY_PASSWORD
 */
fun getSigningPropertiesByFlavorName(flavorName: String): Array<String> {
    try {
        val signingProperties = loadPropertiesFile("signing/$flavorName/signing.properties")
        return arrayOf(
            signingProperties.getProperty("STORE_FILE").orEmpty(),
            signingProperties.getProperty("STORE_PASSWORD").orEmpty(),
            signingProperties.getProperty("KEY_ALIAS").orEmpty(),
            signingProperties.getProperty("KEY_PASSWORD").orEmpty(),
        )
    } catch (exception: Exception) {
        throw Exception("Signing has not been configured for \"$flavorName\".\n${exception.message}")
    }
}

@Throws(Exception::class)
fun loadPropertiesFile(rootPath: String): Properties {
    val propertiesFile = rootProject.file(rootPath)
    val properties = Properties()
    properties.load(FileInputStream(propertiesFile))
    return properties
}
