import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
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
