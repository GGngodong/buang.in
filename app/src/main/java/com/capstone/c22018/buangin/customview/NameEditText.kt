package com.capstone.c22018.buangin.customview

import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import androidx.core.content.ContextCompat
import com.capstone.c22018.buangin.R
import com.google.android.material.textfield.TextInputEditText

class NameEditText : TextInputEditText {

    private lateinit var clearButton: Drawable

    constructor(context: android.content.Context): super(context) {
        init()
    }

    constructor(context: android.content.Context, attrs: android.util.AttributeSet): super(context, attrs) {
        init()
    }

    constructor(context: android.content.Context, attrs: android.util.AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        init()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        hint = ""
        textAlignment = View.TEXT_ALIGNMENT_TEXT_START
    }

    private fun init() {
        maxLines = 1
        inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS

        clearButton = ContextCompat.getDrawable(context, R.drawable.ic_close) as Drawable

        addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable) {

                if (s.toString().isNotEmpty()) showClearButton() else hideClearButton()

                if (s.toString().isEmpty()) showError()

                if (!Patterns.EMAIL_ADDRESS.matcher(s).matches())
                    error = "Email is not valid"

            }
        })
    }

    private fun showError() {
        error = "Must be filled"
    }

    private fun showClearButton() {
        setButtonDrawables(endOfTheText = clearButton)
    }

    private fun hideClearButton() {
        setButtonDrawables()
    }

    private fun setButtonDrawables(
        startOfTheText: Drawable? = null,
        topOfTheText: Drawable? = null,
        endOfTheText: Drawable? = null,
        bottomOfTheText: Drawable? = null
    ) {
        setCompoundDrawablesWithIntrinsicBounds(
            startOfTheText,
            topOfTheText,
            endOfTheText,
            bottomOfTheText
        )
    }
}