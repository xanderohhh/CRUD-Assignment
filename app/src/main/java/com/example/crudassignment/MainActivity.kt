package com.example.crudassignment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.javafaker.Faker

class MainActivity : BaseActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var recordListAdapter: RecordsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recordsRecycler)
        recordListAdapter = RecordsAdapter(recordList) { postition ->
            toastIt("You selected position: $postition")
            val intent = Intent(this, ShowRecord::class.java)
            currentRecord = postition
            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = recordListAdapter

        readFile()
        recordListAdapter.notifyDataSetChanged()
    }

    fun newRecordOnClick(v: View) {
        val intent = Intent(this, AddRecord::class.java)
        startActivity(intent)
    }

    fun mockOnClick(v: View) {

        repeat(40) {
            val faker = Faker()
            val name = faker.commerce().productName()
            val description = faker.lorem().sentence()
            val recordItem = RecordItem("$name", "$description")
            recordList.add(recordItem)
        }
        writeToFile()
        recordListAdapter.notifyDataSetChanged()
    }

    fun scrollToTopOnClick(v: View) {
        recyclerView.smoothScrollToPosition(0)
    }

    fun scrollToBottomOnClick(v: View) {
        recyclerView.smoothScrollToPosition(recordList.size)
    }

    fun clearOnClick(v: View) {
        recordList.clear()
        writeToFile()
        recordListAdapter.notifyDataSetChanged()
    }

}