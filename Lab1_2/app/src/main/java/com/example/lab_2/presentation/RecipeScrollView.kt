package com.example.lab_2.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.lab_2.domain.model.Recipe
import com.example.lab_2.ui.theme.BodyTitleText
import com.example.lab_2.ui.theme.ContentText
import com.example.lab_2.ui.theme.TitleText

@Composable
fun RecipeScrollView(recipe: Recipe) {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        contentAlignment = Alignment.TopStart
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Text(
                text = "${recipe.title} Recipe",
                style = TitleText,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(vertical = 20.dp)
            )
            RecipeIngredients(recipe = recipe)
            RecipeSteps(recipe = recipe)
        }
    }
}

@Composable
private fun RecipeIngredients(recipe: Recipe) {
    Text(
        text = "Ingredients",
        style = TitleText,
        color = MaterialTheme.colorScheme.onBackground,
        modifier = Modifier.padding(vertical = 20.dp)
    )

    for (part in recipe.ingredients) {
        Text(
            text = part.part,
            style = BodyTitleText,
            modifier = Modifier.padding(vertical = 5.dp)
        )
        for (item in part.items) {
            Text(
                text = "- ${item.amount} of ${item.name}",
                style = ContentText,
                modifier = Modifier.padding(vertical = 5.dp)
            )
        }
    }
}

@Composable
private fun RecipeSteps(recipe: Recipe) {
    Text(
        text = "Steps",
        style = BodyTitleText,
        color = MaterialTheme.colorScheme.onBackground,
        modifier = Modifier.padding(vertical = 20.dp)
    )
    for (step in recipe.steps) {
        val stepText = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                append("Step ${step.number}: ")
            }
            withStyle(style = SpanStyle(fontWeight = FontWeight.Normal)) {
                append(step.instruction)
            }
        }
        Text(
            text = stepText,
            style = ContentText,
            modifier = Modifier.padding(vertical = 10.dp)
        )
    }
}