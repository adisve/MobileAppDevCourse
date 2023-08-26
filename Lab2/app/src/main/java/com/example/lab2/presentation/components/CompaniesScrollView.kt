import android.content.Intent
import android.net.Uri
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2.R
import com.example.lab2.domain.models.network.Company
import com.example.lab2.presentation.components.CompanyCard
import com.example.lab2.presentation.components.WebViewComposable

@Composable
fun CompaniesScrollView(companies: List<Company>) {
    var showWebView by remember { mutableStateOf(false) }
    var selectedCompanyWebPage by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(companies) { company ->
                CompanyCard(company = company, onVisitClick = {
                    showWebView = true
                    selectedCompanyWebPage = company.webpage
                })
            }
        }

        if (showWebView) {
            WebViewComposable(url = selectedCompanyWebPage) {
                showWebView = false
            }
        }
    }
}
