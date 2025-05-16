package dev.sandul.viewmodelexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.sandul.viewmodelexample.search_viewmodel.SearchScreen
import dev.sandul.viewmodelexample.ui.theme.ViewModelExampleTheme
import dev.sandul.viewmodelexample.viewmodel_example.MyMainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ViewModelExampleTheme {
//                MyMainScreen()
                SearchScreen()
            }
        }
    }
}