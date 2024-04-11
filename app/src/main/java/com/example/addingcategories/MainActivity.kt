package com.example.addingcategories

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.addingcategories.ui.theme.AddingCategoriesTheme

class MainActivity : ComponentActivity() {



    val myViewModel by lazy{
        ViewModelProvider(this).get(MyViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AddingCategoriesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    addinCategories(myViewModel)
                }
            }
        }
    }
}




@Composable
fun addinCategories (myViewModel : MyViewModel){


    Column {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp),
            value = myViewModel.state.value.textState,
            onValueChange = {myViewModel.updateText(it)},
            label = {Text ("Item")}
        )
        Button(onClick = {
           myViewModel.updateNamesList(myViewModel.state.value.textState)
            myViewModel.state.value.textState = ""
        }) {
            Text(text = "Add")
        }
        for(item in myViewModel.state.value.namesList){
            Text(item)
        }
    }


}