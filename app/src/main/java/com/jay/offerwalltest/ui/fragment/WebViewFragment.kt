package com.jay.offerwalltest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.jay.offerwalltest.R


class WebViewFragment : Fragment() {

    private var webViewLink: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { webViewLink = it.getString(WEB_VIEW_LINK) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_web_view, container, false)

        val webView: WebView = view.findViewById(R.id.web_view)
        webView.apply { loadUrl(webViewLink) }

        return view
    }

    companion object {
        private const val WEB_VIEW_LINK = "webViewLink"

        @JvmStatic
        fun newInstance(webViewLink: String?) =
            WebViewFragment().apply {
                arguments = Bundle().apply { putString(WEB_VIEW_LINK, webViewLink) }
            }
    }
}