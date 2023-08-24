package com.example.lab_2.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.res.painterResource
import com.example.lab_2.R
import com.example.lab_2.domain.model.applePieRecipe

@Composable
fun App() {
    var recipeVisible by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        if (recipeVisible) {
            RecipeScrollView(recipe = applePieRecipe)
        } else {
            Image(
                painter = painterResource(id = R.drawable.disappear),
                contentDescription = "disappear",
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .align(Alignment.Center)
            )
        }
        ToggleRecipeButton(
            recipeVisible = recipeVisible,
            toggleRecipe = {
                recipeVisible = !recipeVisible
            },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .zIndex(1f)
                .padding(16.dp)
        )
    }
}





