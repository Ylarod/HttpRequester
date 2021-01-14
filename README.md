# Compile Environment

System: Arch Linux x86_64

IDE: Android Studio 4.1.1

Current Desktop: KDE

Gradle Plugin Version: 4.1.1

Gradle Version: 6.5

Compile SDK: 30

Build Tool Version: 30.0.1

Java Version: openjdk version "11.0.8" 2020-07-14

Dependencies:
 ```
 dependencies {
     def nav_version = "2.3.2"
     def lifecycle_version = "2.2.0"
     def room_version = "2.2.6"

     implementation 'com.google.android.material:material:1.2.1'
     implementation 'com.google.code.gson:gson:2.8.6'
     implementation 'com.squareup.okhttp3:okhttp:4.2.0'
     implementation 'com.ejlchina:okhttps:2.5.0'

     implementation 'androidx.appcompat:appcompat:1.2.0'
     implementation 'androidx.constraintlayout:constraintlayout:2.0.4'
     implementation "androidx.coordinatorlayout:coordinatorlayout:1.1.0"
     implementation "androidx.drawerlayout:drawerlayout:1.1.1"

     implementation "androidx.navigation:navigation-ui:$nav_version"
     implementation "androidx.navigation:navigation-fragment:$nav_version"

     implementation "androidx.lifecycle:lifecycle-viewmodel:$lifecycle_version"
     implementation "androidx.lifecycle:lifecycle-livedata:$lifecycle_version"
     implementation "androidx.lifecycle:lifecycle-runtime:$lifecycle_version"
     implementation "androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version"
     implementation "androidx.lifecycle:lifecycle-common-java8:$lifecycle_version"

     implementation "androidx.room:room-runtime:$room_version"
     annotationProcessor "androidx.room:room-compiler:$room_version"
     testImplementation 'junit:junit:4.13.1'
     androidTestImplementation 'androidx.test.ext:junit:1.1.2'
     androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'
 }
 ```
