package com.mapelli.simone.edittextcostum

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class AutoreadingFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val layoutContent =  inflater.inflate(R.layout.fragment_autoreading, container, false)
        val m_cube_text = layoutContent.findViewById<TextView>(R.id.m_cube_text)
        m_cube_text.text = Html.fromHtml("m<sup>3</sup>")

        return layoutContent
    }

    companion object {
        fun newInstance():AutoreadingFragment {
            return AutoreadingFragment()
        }
    }
}
