package com.fuadhev.rickandmortyjetpack.presentation.characters.views

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fuadhev.rickandmortyjetpack.Screen
import com.fuadhev.rickandmortyjetpack.presentation.characters.CharactersViewModel
import com.fuadhev.rickandmortyjetpack.ui.theme.irishGrover
import com.fuadhev.rickandmortyjetpack.utils.Constant

@Composable
fun CharactersScreen(
    navController: NavController,
    viewModel: CharactersViewModel = hiltViewModel()
) {


    val state = viewModel.state.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Rick and Morty",
            fontSize = 40.sp,
            fontFamily = irishGrover
        )

        Text(text = "fandom",
            fontSize = 24.sp,
            fontFamily = irishGrover
        )


        Spacer(modifier = Modifier.padding(15.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.characters){ charcacter->
                CharactersVerticalGrid(character = charcacter, onItemClick = {
                    navController.navigate(Screen.CharacterDetailScreen.route + "/${charcacter.id}")
                    Log.e("TAG", "fuad: ${charcacter.id}", )
                } )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {

}
