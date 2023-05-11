# proguard-rules
# How to Use ProGuard Rules in Android

ProGuard is a Java optimization tool that is included with the Android SDK.
It can help you reduce the size of your Android app by removing unused code and optimizing the remaining code.
ProGuard can also obfuscate your code to make it more difficult to reverse-engineer.

## Step 1: Enable ProGuard in your Android project

To enable ProGuard in your Android project, you need to add the following lines to your `build.gradle` file:

groovy
```groovy
android {
  buildTypes {
    release {
      shrinkResources true
      minifyEnabled true
      proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
    }
  }
}
```
kotlin
```
android {
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}
```

## Step 2: Customize your ProGuard rules

By default, ProGuard will apply a set of general rules to your code to optimize and obfuscate it. However, you may need to customize these rules to ensure that your app functions correctly.

- If your app uses a third-party library, you may need to add rules to keep the classes and methods used by the library from being removed or obfuscated.
- You can also add rules to keep specific classes or methods in your own code from being removed or obfuscated.

Here is an example of a ProGuard rule that keeps all classes and methods in a specific package:

```proguard
-keep class com.example.myapp.mypackage.** { *; }
```

## Step 3: Test and troubleshoot ProGuard

Once you have customized your ProGuard rules, it is important to test your app thoroughly to ensure that it functions correctly. ProGuard can sometimes remove code that is actually necessary for your app to work, which can lead to crashes or other issues.

- Run your app in the release build type and check for any errors or unexpected behavior.
- Use the ProGuard `-printusage` option to print out a report of the code that has been removed or obfuscated by ProGuard.

If you encounter issues with ProGuard, you may need to modify your ProGuard rules to exclude certain code or to prevent ProGuard from optimizing or obfuscating specific classes or methods.

## Conclusion

ProGuard is a powerful tool that can help you optimize and obfuscate your Android app. By enabling ProGuard and customizing your ProGuard rules, you can reduce the size of your app and make it more difficult to reverse-engineer.

However, it is important to test your app thoroughly and troubleshoot any issues that may arise. By following the steps outlined in this guide, you can use ProGuard effectively in your Android project.

## Classes to preserve
Determining the specific classes to preserve with ProGuard rules depends on the structure of your application and the libraries
or frameworks you're using. However, there are certain classes that are commonly preserved to ensure the proper functioning of an
Android application. Here are some examples:

1. Application Class:
   - Preserve your custom `Application` class and any overrides you have made to its lifecycle methods.

2. Activities and Fragments:
   - Preserve classes for your activities and fragments, including any custom lifecycle callbacks or overridden methods.
   - Preserve classes for activities or fragments used in your manifest file (specified in the `<activity>` or `<fragment>` tags).

3. Views and ViewHolders:
   - Preserve classes for custom views and view holders used in your application.

4. Interfaces:
   - Preserve interfaces used for callbacks or listeners, such as click listeners or network response callbacks.

5. Models and Data Classes:
   - Preserve classes representing your data models or data transfer objects (DTOs) used for serialization or communication.

6. Services:
   - Preserve classes for your custom services, including any overridden methods or custom service connections.

7. Broadcast Receivers:
   - Preserve classes for your custom broadcast receivers, including any overridden methods or custom behavior.

8. Content Providers:
   - Preserve classes for your custom content providers, including any overridden methods or custom functionality.

9. Application-specific Utilities:
   - Preserve any utility classes or helper classes specific to your application.

10. Third-party Libraries:
    - If you're using third-party libraries, check their documentation or ProGuard guidelines to identify any specific classes that should be preserved.
      If you're using third-party libraries, check their documentation or ProGuard guidelines to identify any specific classes that should be preserved.
      
Remember, the above list is not exhaustive and will vary based on your application's architecture, dependencies, and specific requirements. It's important to test your application thoroughly after applying ProGuard rules to ensure that the preserved classes work as expected and that no crashes or unexpected behavior occur.

When configuring ProGuard, it's also a good practice to enable shrinking (shrinkResources true) and obfuscation (minifyEnabled true) for better optimization and security, but ensure that the necessary classes are preserved using appropriate -keep rules.
