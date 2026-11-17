package com.dpointtt.lab3

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.fragment.app.Fragment

class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editText = view.findViewById<EditText>(R.id.plain_text_input)
        val addButton = view.findViewById<Button>(R.id.add_button)
        val listView = view.findViewById<ListView>(R.id.listView)

        val itemsList = ArrayList<String>()
        val adapter = ArrayAdapter(
            requireContext(),
            R.layout.list_item,
            itemsList
        )
        listView.adapter = adapter

        addButton.setOnClickListener {
            val inputText = editText.text.toString().trim()
            if (inputText.isNotEmpty()) {
                itemsList.add(inputText)
                adapter.notifyDataSetChanged()
                editText.text.clear()
            }
        }
    }
}