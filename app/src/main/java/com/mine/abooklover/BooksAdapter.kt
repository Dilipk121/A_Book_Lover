package com.mine.abooklover

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.mine.abooklover.databinding.LayoutHomeBinding

class BooksAdapter(val list:ArrayList<BooksModel>, val context: Context) :
    RecyclerView.Adapter<BooksAdapter.MyViewHolder>() {


        //inner class of view holder
    class MyViewHolder(val binding:LayoutHomeBinding):RecyclerView.ViewHolder(binding.root) {

    }

    //here return own created inner class construction
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      return  MyViewHolder(LayoutHomeBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val model = list[position]
        holder.binding.apply {
            imageView.setImageResource(model.image)

            //in adapter , how we can call Intent & startActivity

            cardView.setOnClickListener{
                val intent = Intent()
                intent.putExtra("book_title",model.title)
                intent.putExtra("book_description",model.description)
                intent.putExtra("book_pdf",model.bookPDF)
                intent.putExtra("book_image",model.image)
                intent.setClass(context,DetailMainActivity::class.java)//this class is the activity
                // activity animation
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(context as Activity,imageView,"bookTransitions")
                //pass above option in below code
                context.startActivity(intent,options.toBundle())//context use to call activity in adapter class
            }

        }
    }


}