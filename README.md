# Gardening Journal App

## Overview
Gardening Journal App is an Android application developed in Kotlin, designed for garden enthusiasts to track and manage their plants. The app features a modern architecture using ViewModel, LiveData, Navigation components, Room database, and coroutines.

## Features
- **Home Screen:** A welcoming dashboard for users.
- **Garden Log:** Display and manage a list of plants.
- **Plant Details:** View detailed information about each plant.
- **Log Plants:** Page to log a new plant

## Getting Started

### Prerequisites
- Android Studio
- Kotlin plugin for Android Studio
- Minimum SDK version: (specify your min SDK)

### Installation
1. Clone the repository using Git: git clone https://github.com/abhay-rawal/gardening-app.git
2. Open the project in Android Studio.
3. Wait for Android Studio to install all the necessary components and dependencies.
4. Configure an emulator or connect an Android device to run the app.

### Running the App
- In Android Studio, select the 'Run' button.
- Choose the desired emulator or connected device.
- The app should build and run, displaying the Home screen.

## Architecture
This app uses the MVVM (Model-View-ViewModel) architecture, ensuring a clean separation of concerns and improved testability.

### Key Components
- **ViewModel:** Manages UI-related data, surviving configuration changes.
- **LiveData:** Used for observing and updating the UI based on data changes.
- **Room Database:** For persisting plant data.
- **Coroutines:** For performing asynchronous tasks efficiently.

### Screen shots
1. Home Screen : <br>
   ![HomeScreen](https://github.com/abhay-rawal/gardening-app/blob/main/app/src/main/res/drawable/Home.png) <br>
2. Create Plant : <br>
   ![CreatePlant](https://github.com/abhay-rawal/gardening-app/blob/main/app/src/main/res/drawable/CreatePlant.png) <br>
3. Calander View: <br>
   ![CalanderView](https://github.com/abhay-rawal/gardening-app/blob/main/app/src/main/res/drawable/CalanderView.png) <br>
4. Garden Log : <br>
   ![GardenLog](https://github.com/abhay-rawal/gardening-app/blob/main/app/src/main/res/drawable/GardenLog.png) <br>
5. Plant Details : <br>
   ![PlantDetails](https://github.com/abhay-rawal/gardening-app/blob/main/app/src/main/res/drawable/PlantDetails.png) <br>

  

