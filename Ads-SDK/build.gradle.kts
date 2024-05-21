plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "com.love.ainsoft.ads_sdk"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
//    project.afterEvaluate {
//        publishing {
//            publications {
//                create<MavenPublication>("maven") {
//                    from (components["release"])
//                    groupId = "com.github.adnanbhatti143"
//                    artifactId = "ads-sdk"
//                    version = "1.0.0"
//                }
//            }
//        }
//    }
}

project.afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("mavenAndroid") {
                from(components["debug"])
                groupId = "com.github.AdnanBhatti143"
                artifactId = "ads-sdk"
                version = "1.0.2"
            }
        }
    }
}

//publishing {
//    publications {
//        mavenAndroid(MavenPublication) {
//            from components . release
//
//                    groupId = 'com.example'
//            artifactId = 'your-android-library'
//            version = '1.0.0'
//        }
//    }
//}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}