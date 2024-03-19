package com.fuadhev.rickandmortyjetpack.presentation.character_detail

import androidx.compose.animation.scaleIn
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.fuadhev.rickandmortyjetpack.ui.theme.irishGrover

@Composable
fun CharacterDetailScreen(viewModel: CharacterDetailViewModel= hiltViewModel()){

    val state=viewModel.state.value


    Box (modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),
        contentAlignment = Alignment.Center
    ){
        state.character?.let {
            Column {

                Text(text = it.name?:"Unknown",
                    fontFamily = irishGrover,
                    fontSize = 40.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(10.dp))

                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(it.image)
                        .build(),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null
                )

                Spacer(modifier = Modifier.height(14.dp))

                Text(text = "Gender ${it.gender}",
                    fontSize = 20.sp
                )
                Text(text = "Status ${it.status}",
                    fontSize = 20.sp
                )
                Text(text = "Species ${it.species}",
                    fontSize = 20.sp
                )
                Text(text ="Type ${it.type}",
                    fontSize = 20.sp
                )
                Text(text ="Origin ${it.origin}",
                    fontSize = 20.sp
                )
            }
        }

        if(state.isLoading) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }

    }
}