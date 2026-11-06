# Maestra SDK for Android

The Maestra SDK allows you to integrate mobile push-notifications, in-app messages and client events into your Android projects.

## Getting Started

These instructions will help you integrate the Maestra SDK into your Android app.

### Installation

Coming soon.

### Initialization 

Initialize the SDK in your Activity or Application class. Check documentation [here](https://developers.maestra.io/docs/android-sdk-initialization) for more details.


### Operations

Learn how to send events to Maestra. Create a new Operation class object and set the respective parameters. Check the [documentation](https://developers.maestra.io/docs/android-integration-of-actions) for more details.

### Push Notifications

The Maestra SDK helps handle push notifications. Configuration and usage instructions can be found in the SDK documentation [here](https://developers.maestra.io/docs/firebase-send-push-notifications).

### Tracking Identifiers

The SDK reports the device tracking identifier (GAID from Google Mobile Services) alongside the
regular application events. This is **on by default**. Turn it off when building the configuration
if your app must not collect it:

```kotlin
val configuration = MindboxConfiguration.Builder(this, "domain", "endpointId")
    .disableTrackingIds(true)
    .build()
```

The option is re-read on every initialization, so it can be turned on or off in a later app
version. The SDK never asks for a permission of its own — it reads only what the system already exposes:

* **Android 13+ (API 33) requires the `com.google.android.gms.permission.AD_ID` permission** for
  the GAID to be readable. The `mindbox-firebase` module declares it, so it reaches your app
  through manifest merging if — and only if — you integrate Firebase push.
* The identifier is re-read on every application event, so turning "Delete advertising ID" on or
  off in the system settings reaches Maestra with the next event.

To stop the collection by the SDK, use the configuration option above rather than stripping the
permission: removing it is app-wide, so it also cuts off every other SDK in your app that needs
the advertising id.

**Apps under the Google Play Families policy** must not request `AD_ID` at all. Remove it in your
own manifest — the GAID then stays unavailable and the SDK reports nothing, regardless of this
option:

```xml
<uses-permission
    android:name="com.google.android.gms.permission.AD_ID"
    tools:node="remove" />
```

`deviceUUID` is unaffected — it stays the stable installation key it has always been.

### Migration

If migrating from an older version, follow the instructions [here](https://developers.maestra.io/docs/mobile-sdk) to upgrade to the new version.

## Troubleshooting

Refer to the [Example of integration](example) in case of any issues.

## Further Help

Reach out to us for further help and we'll be glad to assist.

For a better understanding of this content, please familiarize yourself with the Maestra [Android SDK](https://developers.maestra.io/docs/androidhuawei-native-sdk) documentation.
