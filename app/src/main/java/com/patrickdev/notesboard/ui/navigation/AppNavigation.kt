package com.patrickdev.notesboard.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentRecomposeScope
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.patrickdev.notesboard.ui.screens.home.HomeScreen
import com.patrickdev.notesboard.ui.screens.note.NoteScreen
import com.patrickdev.notesboard.ui.viewmodel.INoteViewModel
import com.patrickdev.notesboard.ui.viewmodel.NoteViewModel
import com.patrickdev.notesboard.ui.viewmodel.PreviewNoteViewModel
import kotlinx.coroutines.coroutineScope

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.HomeScreen.route) {
        composable(route = AppScreens.HomeScreen.route) { HomeScreen(navController) }
        composable(route = AppScreens.NoteScreen.route) { NoteScreen(navController) }
    }
}