package com.example.crudassignment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText

class AddRecord : BaseActivity() {

    private lateinit var edtName: EditText
    private lateinit var edtDescription: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_record)

        edtName = findViewById(R.id.edtName)
        edtDescription = findViewById(R.id.edtDescription)
    }

    fun showAllRecordsOnClick(v: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun addRecordOnClick(v: View) {
        if (edtName.text.toString().trim().isNotEmpty()) {
            var recordItem = RecordItem(
                edtName.text.toString(), edtDescription.text.toString()
            )
            recordList.add(recordItem)
            appendTofile(recordItem)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }else {
            toastIt("Please enter a valid name and description.")
        }
    }
}