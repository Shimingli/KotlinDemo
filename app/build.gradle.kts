//build 可以转化为  kotlin的语言哦
//group= 'com.android.application'
//apply plugin: 'kotlin-android'
//apply plugin: 'kotlin-android-extensions'//不需要找id
////apply plugin: 'kotlin-noarg'//这两个插件 是官方提供的 防止 data class 被编译成了final
////apply plugin: 'kotlin-allopen'//
//android {
//    compileSdkVersion 26
//    defaultConfig {
//        applicationId "com.kotlin.demo"
//        minSdkVersion 15
//        targetSdkVersion 26
//        versionCode 1
//        versionName "1.0"
//        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
//    }
//    buildTypes {
//        release {
//            minifyEnabled false
//            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
//        }
//    }
//}
////noArg{
////    annotation("com.kotlin.demo.annotations.PoKo")
////}
////allOpen{
////    annotation("com.kotlin.demo.annotations.PoKo")
////}
//dependencies {
//    implementation fileTree(dir: 'libs', include: ['*.jar'])
//    implementation 'com.android.support:appcompat-v7:26.1.0'
//    implementation 'com.android.support.constraint:constraint-layout:1.0.2'
//    testImplementation 'junit:junit:4.12'
//    androidTestImplementation 'com.android.support.test:runner:1.0.1'
//    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.1'
//    compile "org.jetbrains.kotlin:kotlin-stdlib-jre7:$kotlin_version"
//    //加入这两个依赖的原因是  data class 被编译成了final的了
//    //所以官方出了两个插件来解决 傻逼 注意添加的位置啊
////    compile "org.jetbrains.kotlin:kotlin-noarg:$kotlin_version"
////    compile "org.jetbrains.kotlin:kotlin-allopen:$kotlin_version"
//
//
//}
//repositories {
//    mavenCentral()
//}