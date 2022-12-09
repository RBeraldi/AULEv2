package com.example.macc.aule.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.macc.aule.model.ClassRoom
import com.example.macc.aule.model.ClassRoomRepository

@Composable
fun MyClassRoomList(classRoomRepository: ClassRoomRepository,
imageId: Int) {

    val classrooms = remember {
        classRoomRepository.loadData()
    }

    Column(
        modifier = Modifier.
        background(Color.Blue)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Image(painter =painterResource(imageId) ,
            contentDescription = "" )
        Spacer(modifier = Modifier.height(40.dp))
        /*
        Column(modifier =
        Modifier
            .align(Alignment.CenterHorizontally)
            //.fillMaxSize()
            //.fillMaxHeight()
            .background(Color.Green)
            .alpha(40f)
            )
        {
            Text("TODAY AT DIAG",
                color = Color.Blue, fontSize = 35.sp)

        }
*/
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())) {
        for(i in 0 until classrooms.size){
            MyClassRoomCardItem(classrooms[i])
        }
    }
}
}

@Composable
fun MyClassRoomItem(classroomData: ClassRoom) {
    Row(modifier = Modifier
        .padding(5.dp)
        .background(Color.LightGray)
        .alpha(50f))
    {
        Column(modifier = Modifier
            .align(Alignment.CenterVertically)
            .padding(20.dp)) {
            Text(classroomData.aulaId)
        }
        Column(modifier =
        Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .align(Alignment.CenterVertically)
         ) {
            Text(classroomData.descrizione)
        }
    }
}

@Composable
fun MyClassRoomCardItem(classroomData: ClassRoom) {
    Card(modifier = Modifier
        .padding(5.dp)
        .fillMaxSize()
        .fillMaxHeight()
        )
    {
        Column(modifier = Modifier
            .padding(20.dp)
        ) {
            Text(classroomData.aulaId)
            Row(modifier = Modifier
                .padding(0.dp)
            ) {
                Text(classroomData.ora_inizio)
                Text(classroomData.minuti_inizio + "-")

                Text(classroomData.ora_fine)
                Text(classroomData.minuti_fine + "  ")
            }
                Text(classroomData.descrizione)

        }
    }
}