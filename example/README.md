
To run the example application with functioning mobile push notifications (complete only step 4 for in-app functionality to work), follow these steps:

1) Change the package identifier in the **app/build.gradle** file if needed

2) Add your application to a Firebase project, following the instructions provided at:
[Firebase Key Generation](https://developers.maestra.io/docs/firebase-get-keys)
or add app in your existing project

3) Configure Push Notification Services:
* For Firebase:
Copy the **google-services.json** file into the **app/** folder of your project.

4) Create **example.properties** in the root of the example project (next to `settings.gradle`).
This file is gitignored — fill in your own values (the example ships no endpoint, so set the endpoint id
of your own Android app as configured in your Maestra admin site):
```
mindbox.domain=api.maestra.io
mindbox.endpointId=your-endpoint-id
```
These values are injected into `BuildConfig` at build time and read by
[ExampleApplication](app/src/main/java/com/mindbox/example/ExampleApplication.kt).
Alternatively, you can set the values directly in that file as string literals.

5) Run the application

6) After 5 minutes check your user in your Maestra admin site

7) Run in-app and send mobile push
