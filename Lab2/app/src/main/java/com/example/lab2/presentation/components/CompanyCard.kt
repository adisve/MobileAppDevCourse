package com.example.lab2.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2.domain.models.network.Company

@Composable
fun CompanyCard(company: Company, onVisitClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(vertical = 20.dp)
            .fillMaxWidth()
            .height(150.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            Column(
                Modifier.fillMaxSize()
            ) {
                Text(
                    text = company.title,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(15.dp),
                )
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 15.dp)
                ) {
                    Text(
                        text = company.city,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(end = 10.dp)
                    )
                    Icon(
                        Icons.Default.LocationOn,
                        modifier = Modifier.size(20.dp),
                        contentDescription = "location icon"
                    )
                }
            }
            Button(
                onClick = onVisitClick,
                modifier = Modifier
                    .padding(15.dp)
                    .clip(RoundedCornerShape(15.dp)),
                shape = RoundedCornerShape(15.dp)
            ) {
                Icon(
                    Icons.Filled.Search,
                    modifier = Modifier.size(25.dp),
                    contentDescription = "search icon"
                )
            }
        }
    }
}