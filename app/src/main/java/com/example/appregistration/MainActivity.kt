package com.example.appregistration

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.appregistration.constance.Constance
import com.example.appregistration.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var login: String = "empty"
    private var password: String = "empty"
    private var name: String = "empty"
    private var surname: String = "empty"
    private var secondName: String = "empty"
    private var image: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == Constance.REQUEST_CODE_SIGN_IN) {
            var login = data?.getStringExtra(Constance.LOGIN)
            var password = data?.getStringExtra(Constance.PASSWORD)
            if (this.login == login && this.password == password){
                binding.imageAvatar.setImageResource(image)
                binding.imageAvatar.visibility = View.VISIBLE
                var text = "$name $surname $secondName"
                binding.textView.text = text
                binding.bSignUp.visibility = View.INVISIBLE
                binding.bSignIn.text = "Выйти"
            }
            else {
                binding.textView.text = "Нет такого аккаунта"
            }
        } else if (requestCode == Constance.REQUEST_CODE_SIGN_UP) {
            login = data?.getStringExtra(Constance.LOGIN)!!
            password = data.getStringExtra(Constance.PASSWORD)!!
            name = data.getStringExtra(Constance.NAME)!!
            surname = data.getStringExtra(Constance.SURNAME)!!
            secondName = data.getStringExtra(Constance.SECOND_NAME)!!
            image = data.getIntExtra(Constance.AVATAR_ID, 0)
            binding.imageAvatar.setImageResource(image)
            binding.imageAvatar.visibility = View.VISIBLE
            var text = "$name $surname $secondName"
            binding.textView.text = text
            binding.bSignUp.visibility = View.INVISIBLE
            binding.bSignIn.text = "Выйти"
        }
    }

    fun onclickSignIn(view: View) {
        val intent = Intent(this, SignUpInAct::class.java)
        intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_IN_STATE)
        startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_IN)
    }

    fun onclickSignUp(view: View) {
        val intent = Intent(this, SignUpInAct::class.java)
        intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_UP_STATE)
        startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_UP)
    }
}