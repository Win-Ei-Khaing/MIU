package com.example.dynammiclanguagedays

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener, View.OnTouchListener {
    private lateinit var languageList: ArrayList<Language>
    private var isTouched: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        daysTextView.text = getString(R.string.days).format(
            getString(R.string.monday),
            getString(R.string.tuesday),
            getString(R.string.wednesday),
            getString(R.string.thursday),
            getString(R.string.friday),
            getString(R.string.saturday),
            getString(R.string.sunday)
        )

        languageList = MainViewModel().loadLanguage()
        spinner.adapter = SpinnerAdapter(this, languageList)

        spinner.setOnTouchListener(this)
        spinner.onItemSelectedListener = this
    }
    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        isTouched = true
        return false
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        if (!isTouched) return
        val language = languageList[p2]
        changeLanguage(language.code)
        isTouched = false
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    private fun changeLanguage(code: String) {
        // return the resource's current configuration.
        val config = resources.configuration
        //Construct a locale from language and country.
        val locale = Locale(code)
        Locale.setDefault(locale)
        config.locale = locale
        /* Return the current display metrics that are in effect for this resource object
        * A structure describing general information about a display, such as its size, density, and font scaling.*/
        resources.updateConfiguration(config, resources.displayMetrics)
        recreate()
    }
}
