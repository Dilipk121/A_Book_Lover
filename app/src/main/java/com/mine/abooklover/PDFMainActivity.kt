package com.mine.abooklover

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.mine.abooklover.databinding.ActivityPdfmainBinding

class PDFMainActivity : AppCompatActivity() {
    val activity = this
    lateinit var binding: ActivityPdfmainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity.window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        binding = ActivityPdfmainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            val bookpdf = intent.getStringExtra("book_PDF").toString()
            pdfView.fromAsset(bookpdf)
                .swipeHorizontal(true)
                .pageSnap(true)
                .autoSpacing(true)
                .pageFling(true)
                .enableSwipe(true)
                .load()

        }
    }
}