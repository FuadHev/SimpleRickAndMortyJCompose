package com.fuadhev.rickandmortyjetpack

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fuadhev.rickandmortyjetpack.presentation.character_detail.CharacterDetailScreen
import com.fuadhev.rickandmortyjetpack.presentation.characters.views.CharactersScreen
import com.fuadhev.rickandmortyjetpack.utils.Constant.CHARACTER_ID

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.CharactersScreen.route) {
        composable(Screen.CharactersScreen.route) {
            CharactersScreen(navController = navController)
        }
        composable(Screen.CharacterDetailScreen.route+"/{${CHARACTER_ID}}"){
            CharacterDetailScreen()
        }




    }
}