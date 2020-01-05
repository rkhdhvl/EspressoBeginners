package com.espresso_practice.myapplication.ui.main.dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.espresso_practice.myapplication.R
import kotlinx.android.synthetic.main.activity_dialog.*

class DialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
        button_launch_dialog.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        MaterialDialog(this)
            .show {
                input(
                    waitForPositiveButton = true,
                    allowEmpty = false
                ){
                    dialog, name ->setNameToTextView(name.toString())
                 showToast(buildToast(name.toString()))
                }
                title(R.string.text_enter_name)
                positiveButton (R.string.ok_)
            }
    }

    private fun setNameToTextView(name: String){
        text_name.text = name
    }

    private fun showToast(test:String)
    {
        Toast.makeText(this,test,Toast.LENGTH_LONG).show()
    }

    companion object{
        fun buildToast(test:String):String{
            return "Your name is $test"
        }
    }

}
