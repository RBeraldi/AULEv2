package com.example.macc.aule.model

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import kotlinx.coroutines.*
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query


interface GetData {
    @GET("/pannello/")
    suspend fun doGet(@Query("q") c : String) : ResponseBody
}

class ClassRoomRepository() {

    private val localClassRooms =
        mutableStateListOf<ClassRoom>()

    private lateinit var data : JSONArray
    private val baseUrl = "https://www.diag.uniroma1.it/"

    var retrofit: GetData = Retrofit.Builder()
                .baseUrl(baseUrl)
                .build().create(GetData::class.java)


    fun loadData(): SnapshotStateList<ClassRoom> {
        loadRemoteDataFromNetwork()
        return localClassRooms
    }

    private fun loadRemoteDataFromNetwork(){
        GlobalScope.launch{
          try {
              //delay(10000L)
              val reply = retrofit.doGet("export_json").string()
              data =JSONArray(reply)
              for (i in 0 until data.length() ){
                  val jsonObject = JSONObject(data[i].toString())
                  with(jsonObject){
                      localClassRooms.add(
                          ClassRoom(
                              descrizione = getString("Descrizione"),
                              aulaId = getString("nome_risorsa"),
                              ora_inizio = getString("ora_inizio"),
                              ora_fine = getString("ora_fine"),
                              minuti_inizio = getString("minuti_inizio"),
                              minuti_fine = getString("minuti_fine")
                          )
                      )
                      Log.i("AULE","nr."+localClassRooms.size.toString())
                  }
                  Log.i("AULE",data[i].toString())
              }
          }
          catch (e: Error)
          {
              Log.i("AULE","ERROR")
          }
              }
    }
}

data class ClassRoom(val descrizione:String="placeholder",
                     val who :  String = "placeholder",
                     val aulaId : String = "placeholder",
                     val Id : String ="placeholder",
                     val data : String = "placeholder",
                     val ora_inizio :String= "placeholder" ,
                     val minuti_inizio: String ="placeholder",
                     val ora_fine: String ="placeholder",
                     val minuti_fine: String ="placeholder",
                     val id_aula: String ="placeholder",
                     val nome_aula: String ="placeholder",
                     val nome_risorsa: String ="placeholder"
){

}