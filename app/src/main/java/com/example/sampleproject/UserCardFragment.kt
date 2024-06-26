package com.example.sampleproject

import android.os.Bundle
import android.app.Fragment
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UserCardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserCardFragment() : Fragment() {

    private  var username: String=""
    private lateinit var usernameText: TextView
  //  private lateinit var intent: Intent



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_card, container, false)
        usernameText = view.findViewById(R.id.usernameText)
        this.arguments?.let {
            usernameText.setText(    it.getString("userName"))
        }

       // usernameText.setText("Hi, $userNam")

//        usernameText.text = "Hi, $username"
        return view
    }

}