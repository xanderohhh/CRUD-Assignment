package com.example.crudassignment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView

class ShowRecord : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_record)

        val tvName: TextView = findViewById(R.id.edtName)
        val tvDescription: TextView = findViewById(R.id.edtDescription)

        var record = recordList[currentRecord]

        tvName.text = record.name
        tvDescription.text = record.description

    }

    fun showAllRecordsOnClick(v: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun editRecordOnClick(v: View) {
        val intent = Intent(this, EditRecord::class.java)
        startActivity(intent)
    }

    fun deleteRecordOnClick(v: View) {
        val builder = android.app.AlertDialog.Builder(this)
        builder.setMessage("Are you sure you want to delete this event?").setCancelable(false)
            .setPositiveButton("Yes") { dialog, which ->
                toastIt("Deleted")
                recordList.removeAt(currentRecord)
                writeToFile()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }.setNegativeButton("NO") { dialog, which ->
                dialog.cancel()
            }.create().show()
    }


}