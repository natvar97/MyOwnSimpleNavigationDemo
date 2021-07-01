package com.indialone.myownsiimplenavigationdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.net.UnknownServiceException

class UserDetailsFragment : Fragment(R.layout.fragment_user_details) {

    private lateinit var tvUserDetails: TextView
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            user = arguments?.getParcelable("user")!!
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvUserDetails = view.findViewById(R.id.tv_user_details)

        tvUserDetails.text =
            "User Logged in as \n Username : ${user.username} \n Password : ${user.password}"

    }

}