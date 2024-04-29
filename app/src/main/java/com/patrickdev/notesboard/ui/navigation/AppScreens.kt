package com.patrickdev.notesboard.ui.navigation

sealed class AppScreens(val route: String) {

    object HomeScreen: AppScreens("home_screen")

    object NoteScreen: AppScreens("note_screen")
}