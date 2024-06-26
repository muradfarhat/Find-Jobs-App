package com.example.sampleproject

import android.os.Bundle
//import androidx.fragment.app.Fragment
import android.app.Fragment
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.sampleproject.util.CommonUtils
import com.example.sampleproject.views.MainActivity
import com.example.sampleproject.views.activities.RecyclerViewActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [login_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login_fragment, container, false)

        val username = view.findViewById<EditText>(R.id.userName)
        val password = view.findViewById<EditText>(R.id.password)
        val loginBtn = view.findViewById<TextView>(R.id.loginbtn)

        loginBtn.setOnClickListener {
            if (username.text.isNotEmpty() && CommonUtils.isValidEmailFormat(username.text.toString()) && password.text.isNotEmpty()) {
                val intent = Intent(activity, RecyclerViewActivity::class.java)
                intent.putExtra("EXTRA_USERNAME", username.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(activity, getString(R.string.invalid_email_or_password), Toast.LENGTH_SHORT).show()
            }
        }
        // Inflate the layout for this fragment
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment login_fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}