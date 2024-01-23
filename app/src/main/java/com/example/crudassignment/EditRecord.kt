package com.example.crudassignment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText

class EditRecord : BaseActivity() {

    private lateinit var edtName: EditText
    private lateinit var edtDescription: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_event)

        edtName = findViewById(R.id.edtName)
        edtDescription = findViewById(R.id.edtDescription)

        var record = recordList[currentRecord]

        edtName.setText(record.name)
        edtDescription.setText(record.description)
    }

    fun showAllRecordsOnClick(v: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun saveChangesOnClick(v: View) {
        var record = recordList[currentRecord]
        if (record.name.isNotEmpty()) {
            record.name = edtName.text.toString()
            record.description = edtDescription.text.toString()
            recordList[currentRecord] = record
            writeToFile()
            val intent = Intent(this, ShowRecord::class.java)
            startActivity(intent)
        }else{
            toastIt("Please enter a valid name and description.")
        }
    }

    fun cancelOnClick(v: View) {
        val intent = Intent(this, ShowRecord::class.java)
        startActivity(intent)
    }
}