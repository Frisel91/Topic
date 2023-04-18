package com.example.topic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.topic.data.DataSource
import com.example.topic.data.DataSource.topics
import com.example.topic.data.Topic
import com.example.topic.ui.theme.TopicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SpisokSetka()
                }
            }
        }
    }
}

@Composable
fun CardPreview(topic: Topic ,modifier: Modifier = Modifier){
    Card(elevation = 4.dp) {
        Row() {
            Image(modifier = Modifier.size(width = 68.dp, height = 68.dp),
                painter = painterResource(topic.imageID),
                contentDescription = stringResource(topic.titleID),
                contentScale = ContentScale.Crop)
            Column() {
                Row(modifier = Modifier.padding(top =  16.dp)) {
                    Text(modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        text = stringResource(topic.titleID))
                }
                Row(modifier = Modifier.padding(top =  8.dp)) {
                    Text(modifier = Modifier.padding(start =  16.dp),
                        text = topic.cost.toString())
                }
            }

        }
    }
}

@Composable
fun SpisokSetka( modifier: Modifier = Modifier){
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    modifier = Modifier.padding(8.dp)
    ){
        items (DataSource.topics){
            topic -> CardPreview(topic)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TopicTheme {
        val topic = Topic(R.string.photography, 321, R.drawable.photography)
        CardPreview(topic = topic)
    }
}