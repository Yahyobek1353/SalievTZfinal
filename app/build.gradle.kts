plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.navigation.args)
}

android {
    namespace = "com.myself223.graduationtestassignment"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.myself223.graduationtestassignment"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        buildConfigField("String","BASE_URL","\"https://rickandmortyapi.com/api/\"")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures{
        viewBinding = true
        buildConfig = true
    }
}

dependencies {
    //Ui
    implementation(libs.bundles.ui.component)
    //Test
    implementation(libs.bundles.test.component)
    //Retrofit
    implementation(libs.bundles.network.component)
    //Koin
    implementation(libs.bundles.koin.component)
    //OkHttp
    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    //Nav Component
    implementation(libs.bundles.navigaion.component)

    implementation(project(":features:main"))



}