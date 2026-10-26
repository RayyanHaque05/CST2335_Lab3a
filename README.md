# CST2335 Lab 3 - Activity Lifecycle & Intents

**Course:** CST2335 - Mobile Graphical Interface Programming  
**Branch:** lab_3  

## Description
This Android application demonstrates:
- Navigation between `MainActivity` and `NameActivity` using explicit intents.
- Passing data using `startActivityForResult()` and handling result codes (`0` and `1`) in `onActivityResult()`.
- Saving and restoring user input using `SharedPreferences` in `onPause()` and `onCreate()`.
- Full English and French localization using Android resource files (`values/strings.xml` and `values-fr/strings.xml`).

## Project Structure
- `app/src/main/java/com/cst2335/lab3/`
  - `MainActivity.java`
  - `NameActivity.java`
- `app/src/main/res/`
  - `layout/activity_main.xml`
  - `layout/activity_name.xml`
  - `values/strings.xml` (English)
  - `values-fr/strings.xml` (French)
- `media/`
  - Screenshots and demo recording
