package com.arpit.catfactsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.lang.Exception

const val baseurl = "https://cat-fact.herokuapp.com/"

class MainActivity : AppCompatActivity() {

    private var TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      getCurrentData()

        relativeLayout.setOnClickListener {
            getCurrentData()
        }
    }

    private fun getCurrentData() {

        tvFact.visibility = View.INVISIBLE
        tvTimeStamp.visibility = View.INVISIBLE
        progressBar.visibility = View.VISIBLE

        val api = Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRequest::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = api.getCatFacts().awaitResponse()
                if (response.isSuccessful) {
                    val data = response.body()!!
                    Log.d(TAG, data.text)

                    withContext(Dispatchers.Main) {
                        tvFact.visibility = View.VISIBLE
                        tvTimeStamp.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE

                        tvFact.text = data.text
                        tvTimeStamp.text = data.createdAt


                    }
                }
            }
            catch (e:Exception){
                withContext(Dispatchers.Main){
                    Toast.makeText(applicationContext, "Cannot Load Data" , Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}