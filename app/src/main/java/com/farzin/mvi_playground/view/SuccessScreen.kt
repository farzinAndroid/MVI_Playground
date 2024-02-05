package com.farzin.mvi_playground.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.farzin.mvi_playground.api.AnimalService
import com.farzin.mvi_playground.model.Animal

@Composable
fun SuccessScreen(animalList: List<Animal>) {

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(animalList) {
            AnimalItem(item = it)
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
        }
    }
}


@Composable
fun AnimalItem(item: Animal) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(horizontal = 4.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Start
        ) {

            val url = AnimalService.BASE_URL + item.image
            Image(
                painter = rememberAsyncImagePainter(url),
                contentDescription = "",
                modifier = Modifier
                    .size(100.dp),
                contentScale = ContentScale.FillHeight
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 4.dp)
            ) {

                Text(text = item.name, fontWeight = FontWeight.Bold)
                Text(text = item.location, fontWeight = FontWeight.Normal)

            }
        }
    }
}