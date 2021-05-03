package com.example.apicorona

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListOFDataCorona()
    }

    private fun setupListOFDataCorona(){
        rvItemList.layoutManager = LinearLayoutManager(this)

        var apiInterface : ApiInterface = ApiClient().getApiClient()!!.create(ApiInterface::class.java)
        apiInterface.getDatas().enqueue(object : Callback<ArrayList<CoronaModel>> {

            override fun onResponse( call: Call<ArrayList<CoronaModel>>?, response: Response<ArrayList<CoronaModel>>?) {
                var coronaData = response?.body()!!
                if (coronaData.size > 0) {
                    rvItemList.visibility = View.VISIBLE
                    tvNoRecordAvailable.visibility = View.GONE
                    rvItemList.adapter = CoronaAdapter(this@MainActivity,coronaData)
                }else {
                    rvItemList.visibility = View.GONE
                    tvNoRecordAvailable.visibility = View.VISIBLE
                }
                Toast.makeText(baseContext, "Data downloading", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<ArrayList<CoronaModel>>, t: Throwable) {
                Toast.makeText(baseContext, "Data Downloading is failed", Toast.LENGTH_LONG).show()
            }
        })
    }
}