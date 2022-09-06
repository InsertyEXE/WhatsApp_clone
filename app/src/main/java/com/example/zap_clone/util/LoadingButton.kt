package com.example.zap_clone.util

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ProgressBar
import com.example.zap_clone.R

class LoadingButton : FrameLayout {

    private lateinit var button: Button
    private lateinit var progressBar: ProgressBar
    private var text: String? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attr: AttributeSet) : super(context, attr) {
        setup(context, attr)
    }

    constructor(context: Context, attr: AttributeSet, defStyleAttr: Int) : super(
        context,
        attr,
        defStyleAttr
    ) {


        setup(context, attr)
    }

    private fun setup(context: Context, attr: AttributeSet) {

        //Inflando layout
        val inflater: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        inflater.inflate(R.layout.loading_button, this)


        //Pegando um arquivo de estilo para aplicar
        val styleArray = context.obtainStyledAttributes(attr, R.styleable.LoadingButton, 0, 0)
        text = styleArray.getString(R.styleable.LoadingButton_text)


        //Configurando por camadas
        button = getChildAt(0) as Button
        progressBar = getChildAt(1) as ProgressBar


        button.text = text
        button.isEnabled = false

        styleArray.recycle()

    }


    //Configurando a logica do botão
    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        button.isEnabled = enabled
    }

    override fun setOnClickListener(l: OnClickListener?) {
        button.setOnClickListener(l)
    }

    fun showProgressbar(enabled: Boolean){
        if (enabled){
            button.text = ""
            button.isEnabled = false
            progressBar.visibility = View.VISIBLE
        } else{
            button.text = text
            button.isEnabled = true
            progressBar.visibility = View.GONE
        }
    }
}