package com.mine.abooklover

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.mine.abooklover.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bindings: ActivityMainBinding
    val activity = this
    val list : ArrayList<BooksModel> = ArrayList()//create list of data model
    val madapter = BooksAdapter(list,activity)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindings = ActivityMainBinding.inflate(layoutInflater)//use small case layoutInflater

     //   setContentView(R.layout.activity_main)
        setContentView(bindings.root)

        bindings.apply {
            mRecycleView.adapter = madapter
            list.add(BooksModel(R.drawable.emma,"emma Book Title","emma Book Description","emma.pdf"))
            list.add(BooksModel(R.drawable.his_burning_desirepage0,"his burning desire Title","Book Description","his_burning_desire.pdf"))
            list.add(BooksModel(R.drawable.the_making_of_a_matchmakerpage," the making Book Title","the making of a matchmaker Book Description","the_making_of_a_matchmaker.pdf"))
            list.add(BooksModel(R.drawable.lady_tanglewood,"lady tanglewood Book Title","lady tanglewood Book Description","lady_tanglewood.pdf"))
            list.add(BooksModel(R.drawable.war_of_the_animals,"war_of_the_animals Book Title","war_of_the_animals Book Description","war_of_the_animals.pdf"))

        }

    }
}