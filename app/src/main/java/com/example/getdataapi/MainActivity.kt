package com.example.getdataapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.getdataapi.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

   var url="https://gorest.co.in/public/v2/todos"

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

binding.button.setOnClickListener {


    downloadfile()
}


    }
    fun downloadfile(){
       var queue=Volley.newRequestQueue(this)
        val request=StringRequest(Request.Method.GET,url,
            Response.Listener { response ->
                var data=response.toString()
                var jArray=JSONArray(data)
                for (i in 0..jArray.length()-1)
                {
                    var jsonobject=jArray.getJSONObject(i)
                   binding.textView3.text=jsonobject.getString("id")
                }

            },
            Response.ErrorListener {


        })
    }
}