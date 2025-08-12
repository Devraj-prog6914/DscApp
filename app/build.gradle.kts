plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.gms.google.services) // Correct alias format
}

android {
    namespace = "com.example.blogapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.blogapp"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

    dependencies {
        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.appcompat)
        implementation(libs.material)
        implementation(libs.androidx.activity)
        implementation(libs.androidx.constraintlayout)

        // Firebase - All versions managed by BOM
        implementation(platform("com.google.firebase:firebase-bom:32.1.0"))
        implementation("com.google.firebase:firebase-auth-ktx")
        implementation("com.google.firebase:firebase-firestore-ktx")
        implementation("com.google.firebase:firebase-storage-ktx")
        implementation("com.google.firebase:firebase-common-ktx")
        implementation("com.google.firebase:firebase-database-ktx")

        // Google Sign-In
        implementation(libs.play.services.auth)

        // UI libraries
        implementation("io.github.shashank02051997:FancyToast:2.0.2")
        implementation("com.github.f0ris.sweetalert:library:1.6.2")
        implementation(libs.androidx.cardview)
        implementation(libs.androidx.recyclerview)
    }




