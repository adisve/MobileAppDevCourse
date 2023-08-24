package com.example.lab_1.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun FactBox(currentFact: String, isInitial: Boolean) {
    Box(
        Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surface)
            .width(300.dp)
            .height(200.dp)
            .padding(all = 25.dp),
        contentAlignment = Alignment.Center
    ) {
        val transitionSpec: (AnimatedContentScope<String>.() -> ContentTransform) = {
            if (isInitial) {
                slideInVertically { 0 } with slideOutVertically { 0 }
            } else {
                slideInVertically { it } with slideOutVertically { -it }
            }
        }

        AnimatedContent(
            targetState = currentFact,
            transitionSpec = transitionSpec,
            label = "animatedFact"
        ) { targetFact ->
            Text(
                text = targetFact,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 22.sp,
                lineHeight = 35.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.align(Alignment.Center).width(250.dp)
            )
        }
    }
}