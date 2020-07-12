package com.jay.offerwalltest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.jay.offerwalltest.R

class TextFragment : Fragment() {

    private var text: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { text = it.getString(TEXT) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_text, container, false)

        val textView: TextView = view.findViewById(R.id.text_view)
        textView.text = text

        return view
    }

    companion object {
        private const val TEXT = "text"

        @JvmStatic
        fun newInstance(text: String?): TextFragment {
           return TextFragment().apply {
                arguments = Bundle().apply {
                    putString(TEXT, text)
                }
            }
        }
    }
}