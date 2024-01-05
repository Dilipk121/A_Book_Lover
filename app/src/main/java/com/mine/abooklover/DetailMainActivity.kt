package com.mine.abooklover

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mine.abooklover.databinding.ActivityDetailMainBinding

class DetailMainActivity : AppCompatActivity() {

    val activity = this
    lateinit var binding: ActivityDetailMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val book_title = intent.getStringExtra("book_title").toString()
        val book_image = intent.getIntExtra("book_image",0)// calling Int for image as we set there
        val book_description = intent.getStringExtra("book_description").toString()
        val book_pdf = intent.getStringExtra("book_pdf").toString()

        binding.apply {

            mbookTitle.text = book_title
            mbookDescription.text = book_description
            mbookImage.setImageResource(book_image)

           mReadFullBookPdf.setOnClickListener{
               val intent = Intent()
               intent.putExtra("book_PDF",book_pdf)
               intent.setClass(activity,PDFMainActivity::class.java)
               startActivity(intent)

           }
        }


    }
}