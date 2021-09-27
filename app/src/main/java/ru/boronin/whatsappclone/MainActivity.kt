package ru.boronin.whatsappclone

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import ru.boronin.whatsappclone.ui.theme.WhatsAppCloneTheme
import ru.boronin.whatsappclone.ui.theme.WhatsAppThemeColor

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      WhatsAppCloneTheme {
        WhatsApp()
      }
    }
  }
}

@Composable
fun WhatsApp() {
  val context = LocalContext.current
  val topBar: @Composable () -> Unit = {
    TopAppBar(
      title = {
        Text(
          text = "WhatsApp",
          color = Color.White,
          fontSize = 20.sp
        )
      },
      actions = {
        AppBarIconButton("Search", Icons.Filled.Search)
        AppBarIconButton("Message", Icons.Filled.MailOutline)
        AppBarIconButton("Menu", Icons.Filled.MoreVert)
      },
      backgroundColor = WhatsAppThemeColor,
      elevation = AppBarDefaults.TopAppBarElevation
    )
  }

  Scaffold(
    topBar = topBar,
    content = {
      WhatsAppTab()
    }
  )
}

@Composable
fun WhatsAppTab() {

}

@Composable
private fun AppBarIconButton(buttonName: String, image: ImageVector) {
  val context = LocalContext.current
  IconButton(
    onClick = {
      Toast.makeText(context, "Clicked $buttonName", Toast.LENGTH_SHORT).show()
    }
  ) {
    Icon(
      image,
      contentDescription = buttonName,
      tint = Color.White
    )
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  WhatsApp()
}