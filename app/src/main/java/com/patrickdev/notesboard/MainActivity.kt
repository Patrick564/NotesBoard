package com.patrickdev.notesboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.patrickdev.notesboard.ui.navigation.AppNavigation
import com.patrickdev.notesboard.ui.screens.home.HomeScreen
import com.patrickdev.notesboard.ui.theme.NotesBoardTheme
import com.patrickdev.notesboard.ui.viewmodel.PreviewNoteViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NotesBoardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewDefault() {
    val previewNoteViewModel = remember {
        PreviewNoteViewModel()
    }

    val navController = rememberNavController()

    HomeScreen(navController, previewNoteViewModel)
}