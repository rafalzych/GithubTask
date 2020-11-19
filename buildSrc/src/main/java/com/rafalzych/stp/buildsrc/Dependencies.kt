import org.gradle.api.JavaVersion

object Config {
    val minSdk = 21
    val compileSdk = 29
    val targetSdk = 29
    val javaVersion = JavaVersion.VERSION_1_8
}

object Versions {
    const val gradle_android_version = "4.0.0"

    const val kotlin_version = "1.4.10"
    const val appcompat_version = "1.2.0"

    const val activity_ktx_version = "1.1.0"
    const val fragment_ktx_version = "1.2.5"
    const val core_ktx_version = "1.3.2"
    const val constraint_layout_version = "2.0.4"
    const val recycler_view_version = "1.1.0"

    const val retrofit_version = "2.7.1"

    const val rxjava2_version = "2.2.17"
    const val rxandroid2_version = "2.1.1"

    const val okhttp_version = "4.3.1"

    const val gson_version = "2.8.6"

    const val glide_version = "4.11.0"

    const val timber_version = "1.5.1"

    const val junit_version = "4.12"
    const val junit_ext_version = "1.1.2"
    const val android_testing_version = "1.3.0"
    const val android_espresso_version = "3.3.0"
}

object Dependencies {
    const val toolsGradleAndroid =
        "com.android.tools.build:gradle:${Versions.gradle_android_version}"
    const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_version}"
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin_version}"

    const val googleAppCompat = "androidx.appcompat:appcompat:${Versions.appcompat_version}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activity_ktx_version}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragment_ktx_version}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.core_ktx_version}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout_version}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recycler_view_version}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}"
    const val retrofitGsonConverter =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofit_version}"
    const val retrofitAdapterRxjava2 =
        "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit_version}"

    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp_version}"
    const val okhttpInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp_version}"

    const val rxjava2 = "io.reactivex.rxjava2:rxjava:${Versions.rxjava2_version}"
    const val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid2_version}"

    const val gson = "com.google.code.gson:gson:${Versions.gson_version}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide_version}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide_version}"

    const val timber = "com.github.ajalt:timberkt:${Versions.timber_version}"

    const val testJunit = "junit:junit:${Versions.junit_version}"
    const val testExtJunit = "androidx.test.ext:junit:${Versions.junit_ext_version}"
    const val testAndroidRunner = "androidx.test:runner:${Versions.android_testing_version}"
    const val testAndroidEspressocore =
        "androidx.test.espresso:espresso-core:${Versions.android_espresso_version}"
}