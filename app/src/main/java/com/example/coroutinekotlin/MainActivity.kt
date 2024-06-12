package com.example.coroutinekotlin

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutinekotlin.Interface.QuotesApi
import com.example.coroutinekotlin.databinding.ActivityMainBinding
import com.example.coroutinekotlin.helper.RetrofitHelper
import com.example.coroutinekotlin.model.Result
import com.example.coroutinekotlin.ui.theme.CoroutineKotlinTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.create

class MainActivity : AppCompatActivity() {
  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
            binding.recyclerview.layoutManager = LinearLayoutManager(this)
            val data = ArrayList<Result>();
       // setContentView(R.layout.activity_main)
          val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)
        GlobalScope.launch {
            val result = quotesApi.getQuotes()
            if(result != null){
                Log.d("tag",result.body().toString())
                result.body()?.let {
                    data.addAll(it.results)
                }

            }
        }

        val adapter = DataAdapterList(data)
        binding.recyclerview.adapter = adapter


    }
}

