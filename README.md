[![CircleCI](https://circleci.com/gh/raychenon/android-mvvm.svg?style=svg)](https://circleci.com/gh/raychenon/android-mvvm)
[![Maintainability](https://api.codeclimate.com/v1/badges/a99a88d28ad37a79dbf6/maintainability)](https://codeclimate.com/github/codeclimate/codeclimate/maintainability)

This project uses Android Architecture Components ( ViewModel + LiveData and Kotlin's Coroutine)

## Project

The project consists of 2 screens as master-detail interface :  the Home (with gridview) and the Detail

![Demo animation](doc/android_animation.gif)

## Architecture

The architecture is based on MVVM with Android Architecture Components ( ViewModel, LiveData) and Coroutine.
The code is in Kotlin.

The 1st screen (grid) and 2nd screen (detail) each have their Fragment and Activity separated.

`AlbumGridFragment` contains `AlbumGridViewModel` to manage the manages network request and caches data. The response is transmisted back to Fragment by `LiveData`.
 
## API

The REST API used is https://api.deezer.com/user/{id}/albums

## Image Loading

The loading animation is fade-in type in the class `ImageLoader`.
Because the images are displayed , the default image is `res/drawable/fruit.png`.
