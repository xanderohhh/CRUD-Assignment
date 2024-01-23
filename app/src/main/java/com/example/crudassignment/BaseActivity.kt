package com.example.crudassignment

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.io.OutputStreamWriter

var recordList = ArrayList<RecordItem>()
var currentRecord = 0
const val RECORDS_FILE = "records.txt"

open class BaseActivity : AppCompatActivity() {

    open fun toastIt(msg: String?) {
        Toast.makeText(
            applicationContext, msg, Toast.LENGTH_SHORT
        ).show()
    }

    fun writeToFile() {
        val fileOutputStream: FileOutputStream = openFileOutput(RECORDS_FILE, MODE_PRIVATE)
        val recordFile = OutputStreamWriter(fileOutputStream)

        for (record in recordList) {
            recordFile.write(record.toCSV() + "\n")
        }
        recordFile.close()
    }

    fun deleteFile() {
        val file = File(filesDir, RECORDS_FILE)
        if (file.exists()) {
            file.delete()
        }
    }

    fun appendTofile(record: RecordItem) {
        val fileOutputStream: FileOutputStream = openFileOutput(RECORDS_FILE, MODE_APPEND)
        val recordFile = OutputStreamWriter(fileOutputStream)
        recordFile.write("${record.toCSV()}\n")
        recordFile.close()

    }

    fun readFile() {
        recordList.clear()
        val file = File(filesDir, RECORDS_FILE)
        if (file.exists()) {
            File(filesDir, RECORDS_FILE).forEachLine {
                val parts = it.split(",")
                var record = RecordItem(parts[0], parts[1])
                recordList.add(record)
            }
        }
    }
}