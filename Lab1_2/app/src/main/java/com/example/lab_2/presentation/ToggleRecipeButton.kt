package com.example.lab_2.presentation

import android.view.MotionEvent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab_2.R
import com.example.lab_2.ui.theme.ButtonText
import com.example.lab_2.ui.theme.OnPrimaryColor
import com.example.lab_2.ui.theme.PrimaryColor

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ToggleRecipeButton(recipeVisible: Boolean, toggleRecipe: () -> Unit, modifier: Modifier = Modifier) {
    val selected = remember { mutableStateOf(false) }
    val scale by animateFloatAsState(if (selected.value) 0.8f else 1f, label = "")

    Button(
        onClick = { },
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor, contentColor = OnPrimaryColor),
        contentPadding = PaddingValues(vertical = 10.dp, horizontal = 15.dp),
        modifier = modifier
            .scale(scale)
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        selected.value = true
                    }

                    MotionEvent.ACTION_UP -> {
                        selected.value = false
                        toggleRecipe()
                    }
                }
                true
            }
    ) {
        Text(
            text = if (recipeVisible) "Hide" else "Show",
            style = ButtonText,
            modifier = Modifier.padding(end = 10.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.pie),
            contentDescription = "cookie",
            modifier = Modifier
                .width(22.dp)
                .height(22.dp)
        )
    }
}