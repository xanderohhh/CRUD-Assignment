package com.example.crudassignment

class RecordItem(var name: String, var description: String) {

    fun toCSV(): String {
        return "$name,$description"
    }

    override fun toString(): String {
        return "$name: $description"
    }
}