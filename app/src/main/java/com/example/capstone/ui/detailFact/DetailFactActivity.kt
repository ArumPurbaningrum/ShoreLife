package com.example.capstone.ui.detailFact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.capstone.data.di.Injection
import com.example.capstone.data.retrofit.ApiService
import com.example.capstone.databinding.ActivityDetailFactBinding

class DetailFactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailFactBinding
    private lateinit var detailViewModel: DetailFactViewModel
    private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        apiService = Injection.proviceApiService()

        val repository = Injection.provideRepository(this@DetailFactActivity)
        val factory = ViewModelFactory(repository)
        detailViewModel = ViewModelProvider(this@DetailFactActivity, factory)[DetailFactViewModel::class.java]

        getDetail()
        getDetailId()
    }

    private fun getDetailId() {
        val id = intent.getIntExtra("extra_id", -1)
        detailViewModel.getDetail(id)
    }

    private fun getDetail() {
        detailViewModel.itemDetail.observe(this@DetailFactActivity){
            if (it != null){
                binding.deskripsiDetail.text = it.content
                binding.tvDesc.text = it.batikName
            }
        }
    }
}