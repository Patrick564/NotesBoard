package com.patrickdev.notesboard.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.patrickdev.notesboard.ui.components.HomeTopAppBar
import com.patrickdev.notesboard.ui.components.NoteListItem
import kotlinx.coroutines.CoroutineScope

@Composable
fun HomeScreen(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
        ModalDrawerSheet {
            Text(text = "Title", modifier = Modifier.padding(16.dp))

            HorizontalDivider()

            NavigationDrawerItem(
                label = { Text(text = "Item 1") },
                selected = false,
                onClick = { /*TODO*/ }
            )
        }
    }) {
        ScaffoldHome(drawerState, scope, navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldHome(drawerState: DrawerState, scope: CoroutineScope, navController: NavController) {
    val contentCards = listOf(
        "aaa", "fffff", "fffff", "fffff", "fffff", "fffff", "fffff", "fffff", "fffff", "fffff",
        "fffff"
    )

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            HomeTopAppBar(drawerState, scope, scrollBehavior)
        }, content = { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding,
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .padding(top = 12.dp)
                    .padding(horizontal = 16.dp)
            ) {
                items(contentCards) {
                    NoteListItem(navController, scope)
                }
            }
        }
    )
}