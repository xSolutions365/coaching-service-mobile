# CF Coaching Service Mobile (KMP)

## Plugins
Install the following plugins in IntelliJ/ Android Studio:
- [Android](https://plugins.jetbrains.com/plugin/22989-android)
- [Jetpack Compose](https://plugins.jetbrains.com/plugin/18409-jetpack-compose)
- [Kotlin Multiplatform](https://plugins.jetbrains.com/plugin/14936-kotlin-multiplatform)

> Android and Jetpack Compose plugins come pre-bundled with Android Studio

## Prerequisites

> Use the 'Project Environment Preflight Checks' tool in IntelliJ/ Android Studio verify that you're environment is fully configured for KMP

### Java

Configure the JDK in your IDE settings and Project Structure.

Open JDK 17 is recommended

```sh
brew install openjdk@17
```

### Android SDK

Install the Android SDK using the SDK manager.

Latest Android Version: Android 16 - API Level 36 

> For those using IntelliJ, you will need to install the Android plugin first. See [Plugins](#plugins)

Ensure that your `local.properties` has the following

```properties
sdk.dir=<path-to-your-android-sdk-location>

# e.g:
# sdk.dir=/Users/cfUser/Library/Android/sdk
```

### Xcode - If you want to run the iOS App

Ensure that you have Xcode installed.

> It is not recommended to download Xcode from the Mac App Store (it's painfully slow).
> 
> Use one of the following methods.
> - [Apple Developer Website](https://developer.apple.com/download/all/?q=xcode)
> - [XcodesApp](https://github.com/XcodesOrg/XcodesApp)

### Gradle

Once you've completed the steps above, sync gradle and the `composeApp` Configuration should be available in IntelliJ

## Default KMP README

This is a Kotlin Multiplatform project targeting Android, iOS.

* [/composeApp](./composeApp/src) is for code that will be shared across your Compose Multiplatform
  applications.
  It contains several subfolders:
    - [commonMain](./composeApp/src/commonMain/kotlin) is for code that’s common for all targets.
    - Other folders are for Kotlin code that will be compiled for only the platform indicated in the
      folder name.
      For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
      the [iosMain](./composeApp/src/iosMain/kotlin) folder would be the right place for such calls.
      Similarly, if you want to edit the Desktop (JVM) specific part,
      the [jvmMain](./composeApp/src/jvmMain/kotlin)
      folder is the appropriate location.

* [/iosApp](./iosApp/iosApp) contains iOS applications. Even if you’re sharing your UI with Compose
  Multiplatform,
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for
  your project.

* [/shared](./shared/src) is for the code that will be shared between all targets in the project.
  The most important subfolder is [commonMain](./shared/src/commonMain/kotlin). If preferred, you
  can add code to the platform-specific folders here too.

### Build and Run Android Application

To build and run the development version of the Android app, use the run configuration from the run
widget
in your IDE’s toolbar or build it directly from the terminal:

- on macOS/Linux
  ```shell
  ./gradlew :composeApp:assembleDebug
  ```
- on Windows
  ```shell
  .\gradlew.bat :composeApp:assembleDebug
  ```

### Build and Run iOS Application

To build and run the development version of the iOS app, use the run configuration from the run
widget
in your IDE’s toolbar or open the [/iosApp](./iosApp) directory in Xcode and run it from there.

---

Learn more
about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…