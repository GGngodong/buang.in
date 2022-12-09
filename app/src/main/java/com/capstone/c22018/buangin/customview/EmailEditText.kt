package com.capstone.c22018.buangin.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Patterns
import android.view.View
import androidx.core.content.ContextCompat
import com.capstone.c22018.buangin.R
import com.google.android.material.textfield.TextInputEditText

class EmailEditText : TextInputEditText {

    constructor(context: Context): super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet): super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr) {
        init()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    private fun init() {
        maxLines = 1
        inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
        addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, before: Int, count: Int, p3: Int) {
                setSelection(text!!.length)

                if (s != null) {
                    error = if (s.isEmpty()) {
                        null
                    } else if (!Patterns.EMAIL_ADDRESS.matcher(s).matches()) {
                        resources.getString(R.string.email_not_valid)
                    } else {
                        null
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }
}