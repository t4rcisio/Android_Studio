package com.example.api_teste

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val remote = RetrofitClient.createService(PostService::class.java)

        val call : Call<List<PostModel>> =  remote.list()

        val response = call.enqueue(object :Callback<List<PostModel>>{

            override fun onResponse(call: Call<List<PostModel>>, res: Response<List<PostModel>>) {
                val data = res.body()
                Toast.makeText(applicationContext,R.string.sucesfull,Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                val errmsg = t.message
                Toast.makeText(applicationContext,t.message,Toast.LENGTH_LONG).show()
            }

        })





    }
}