plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.jetbrainsKotlinSerialization)
}

android {

    namespace = "com.yasunov.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.yasunov.myapplication"
        minSdk = 24
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
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    implementation(libs.material)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.recyclerview)
    implementation(libs.rxandroid)
    //    RxJava 3
    implementation (libs.rxjava)
    //    Retrofit, OkHttp, RxJava 3 Adapter
    implementation(libs.okhttp)
    implementation(libs.retrofit)
    //    Kotlinx realization, json support
    implementation(libs.converter.kotlinx.serialization)
    implementation(libs.kotlinx.serialization.json)
//    Picasso
    implementation (libs.picasso)
//    Paging 3
    implementation (libs.androidx.paging.runtime)
    implementation(libs.paging.rxjava3)
    implementation(libs.androidx.lifecycle.runtime.ktx)



}
