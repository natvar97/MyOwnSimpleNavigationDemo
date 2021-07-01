package com.indialone.myownsiimplenavigationdemo

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation

class LoginFragment : Fragment(R.layout.fragment_login), View.OnClickListener {

    private lateinit var navController: NavController
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnSignIn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        etUsername = view.findViewById(R.id.et_username)
        etPassword = view.findViewById(R.id.et_password)
        btnSignIn = view.findViewById(R.id.btn_sign_in)

        btnSignIn.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_sign_in -> {
                if (!TextUtils.isEmpty(etUsername.text.toString().trim { it <= ' ' }) &&
                    !TextUtils.isEmpty(etPassword.text.toString().trim { it <= ' ' })
                ) {
                    val user = User(etUsername.text.toString(), etPassword.text.toString())
                    val bundle = bundleOf(
                        "user" to user
                    )

                    navController.navigate(R.id.action_loginFragment_to_userDetailsFragment, bundle)
                } else {
                    Toast.makeText(v.context, "Please fill all the fields are given!!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}