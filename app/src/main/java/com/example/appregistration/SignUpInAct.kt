package com.example.appregistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.appregistration.constance.Constance
import com.example.appregistration.databinding.ActivityMainBinding
import com.example.appregistration.databinding.ActivitySignUpInActBinding

class SignUpInAct : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpInActBinding
    var signState: String = "empty"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpInActBinding.inflate(layoutInflater)
        setContentView(binding.root)

        signState = intent.getStringExtra(Constance.SIGN_STATE)!!
        if (signState == Constance.SIGN_UP_STATE) {
            binding.bAvatar.visibility = View.VISIBLE
            binding.editName.visibility = View.VISIBLE
            binding.editSurname.visibility = View.VISIBLE
            binding.editSecondName.visibility = View.VISIBLE
        }
    }

    fun onclickDone(view: View) {
        if (signState == Constance.SIGN_UP_STATE) {
            val intent = Intent()
            intent.putExtra(Constance.LOGIN, binding.editLoginUp.text.toString())
            intent.putExtra(Constance.PASSWORD, binding.editPasswordUp.text.toString())
            intent.putExtra(Constance.NAME, binding.editName.text.toString())
            intent.putExtra(Constance.SURNAME, binding.editSurname.text.toString())
            intent.putExtra(Constance.SECOND_NAME, binding.editSecondName.text.toString())
            if(binding.signAvatar.isVisible){
                intent.putExtra(Constance.AVATAR_ID, R.drawable.avat1)
            }
            setResult(RESULT_OK, intent)
            finish()
        }
        else if (signState == Constance.SIGN_IN_STATE){
            val intent = Intent()
            intent.putExtra(Constance.LOGIN, binding.editLoginUp.text)
            intent.putExtra(Constance.PASSWORD, binding.editPasswordUp.text)
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    fun onclickAvatar(view: View) {
        binding.signAvatar.visibility = View.VISIBLE
    }
}