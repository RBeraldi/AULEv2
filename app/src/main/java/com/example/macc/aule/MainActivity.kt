package com.example.macc.aule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.macc.aule.model.ClassRoom
import com.example.macc.aule.model.ClassRoomRepository
import com.example.macc.aule.ui.MyClassRoomList
import com.example.macc.aule.ui.theme.AULETheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AULETheme() {
                MyClassRoomList(
                    ClassRoomRepository(),
                    R.drawable.marchio_logo_eng)
            }

        }
    }


}

