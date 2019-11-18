package com.android.pickerfoto

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.magentotest.Adapter.ImageAdapter
import kotlinx.android.synthetic.main.activity_piker.*
import java.util.ArrayList

class PickerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_piker)

        var type = intent.getStringExtra(STRING_EXTRA)
        val viewModel = ViewModelProviders.of(this)[BaseViewModel::class.java]
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        viewModel.getImages(type)

        viewModel.imageList.observe(this, Observer {
            val productAdapter = ImageAdapter(it)
            recyclerView.adapter = productAdapter
        })

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item!!.itemId) {
            R.id.add_new_product -> {
                var intent = Intent(this, PickerActivity::class.java)

                var arr = App.selectedImage as ArrayList<out Parcelable>
                intent.putParcelableArrayListExtra(
                    "test", arr
                )
                setResult(Activity.RESULT_OK, intent)
                finish()
            }

            R.id.table -> {
                recyclerView.layoutManager = LinearLayoutManager(this)
            }
            R.id.grid -> {
                recyclerView.layoutManager = GridLayoutManager(this, 3)
            }
        }
        return super.onOptionsItemSelected(item)
    }


}