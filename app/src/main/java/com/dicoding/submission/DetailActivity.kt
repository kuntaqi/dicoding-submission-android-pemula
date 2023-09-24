package com.dicoding.submission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import coil.transform.RoundedCornersTransformation
import com.dicoding.submission.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val gambar = intent.getIntExtra("gambar", R.drawable.sejumlah_warga_mengurus_proses_perceraian_di_pengadilan_agama_jakarta__161003162539_371)

        binding.articleDate.text = intent.getStringExtra("tanggal")
        binding.articleTitle.text = intent.getStringExtra("judul")
        binding.articleJournalist.text = intent.getStringExtra("jurnalis")
        binding.imageDescription.text = intent.getStringExtra("keterangan")
        binding.articleSubdesc.text = intent.getStringExtra("artikel")
        binding.articleImage.load(gambar){
            crossfade(400)
            crossfade(true)
            transformations(RoundedCornersTransformation(10f))
        }

        binding.backArrow.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}