# Motivation
Understanding basics of dependency - instance sharing between components in Vanilla-Dagger.

# Content
- Implementing a basic dagger structure
- Injecting an instance into the application class
- Providing application context to the modules whose provider functions need it
- Providing an instance from the application component into an activity
- Sharing an instance between fragments and activities.
- Implementing a sub-component
    - Provide a single instance only over activities and its fragments
- Providing instances by using provider interfaces.

# Documentation
- The application is following the MVVM pattern.
- ViewModel classes do not inherit from AAC ViewModel. They are kept simple to show how dagger provides instances. So, do not assume it is as best practice.
- On each commit's description you can find the reasons and motivation for implementations.