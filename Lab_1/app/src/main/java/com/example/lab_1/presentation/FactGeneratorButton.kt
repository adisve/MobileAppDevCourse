package com.example.lab_1.presentation

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
import com.example.lab_1.R
import com.example.lab_1.ui.theme.OnPrimary
import com.example.lab_1.ui.theme.Primary

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FactGeneratorButton(setCurrentFact: (String) -> Unit) {

    val selected = remember { mutableStateOf(false) }
    val scale = animateFloatAsState(if (selected.value) 0.8f else 1f, label = "buttonScaleAnimationValue")

    Button(
        onClick = {  },
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Primary, contentColor = OnPrimary),
        contentPadding = PaddingValues(vertical = 20.dp, horizontal = 30.dp),
        modifier = Modifier
            .scale(scale.value)
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        selected.value = true
                    }

                    MotionEvent.ACTION_UP  -> {
                        selected.value = false
                        setCurrentFact(getFact())
                    }
                }
                true
            }
    ) {
        Text(
            "Random fact",
            fontWeight = FontWeight.W600,
            fontSize = 16.sp,
            modifier = Modifier.padding(end = 10.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.cookie),
            contentDescription = "cookie",
            modifier = Modifier
                .width(22.dp)
                .height(22.dp)
        )
    }
}


private fun getFact(): String {
    return listOf(
        "I speak three languages",
        "I am a programmer",
        "I started university 2 years ago",
        "I love playing video games",
        "I enjoy reading books",
        "I play lots of instruments, like guitar, piano, and the drums",
        "I love watching and playing basketball",
        "I think app development in Swift is nicer than Kotlin",
        "I still haven't decided what my favorite programming language is",
        "I studied music before computer science"
    ).random()
}