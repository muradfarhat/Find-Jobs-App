package com.example.sampleproject

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.app.Fragment
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleproject.interfaces.OnItemClickListener
import com.example.sampleproject.interfaces.OnRecyclerCardClick
import com.example.sampleproject.views.activities.Item
import com.example.sampleproject.views.activities.JobDetailsActivity
import com.example.sampleproject.views.activities.JobDetailsData
import com.example.sampleproject.views.activities.JobItemAdapter
import com.example.sampleproject.views.activities.RecyclerViewActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RecyclerViewCardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecyclerViewCardFragment : Fragment(), OnItemClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val data = listOf(
        Item(
            "UI/UX Designer",
            "Elux Space, Malang",
            "Part-time",
            "Remote",
            "Junior level",
            "Your profile match this job",
            "Yesterday",
            "\$300 - 500/month"
        ),
        Item(
            "Product Designer",
            "Flip, Jakarta Barat",
            "Full-time",
            "On-site",
            "Senior level",
            "Your profile match this job",
            "Now",
            "\$12k - 20k/years"
        ),
        Item(
            "UI/UX Designer",
            "Elux Space, Malang",
            "Part-time",
            "Remote",
            "Junior level",
            "Your profile match this job",
            "Yesterday",
            "\$300 - 500/month"
        ),
        Item(
            "Product Designer",
            "Flip, Jakarta Barat",
            "Full-time",
            "On-site",
            "Senior level",
            "Your profile match this job",
            "Now",
            "\$12k - 20k/years"
        ),
        Item(
            "UI/UX Designer",
            "Elux Space, Malang",
            "Part-time",
            "Remote",
            "Junior level",
            "Your profile match this job",
            "Yesterday",
            "\$300 - 500/month"
        ),
        Item(
            "Product Designer",
            "Flip, Jakarta Barat",
            "Full-time",
            "On-site",
            "Senior level",
            "Your profile match this job",
            "Now",
            "\$12k - 20k/years"
        )
    )

    private lateinit var recyclerView: RecyclerView
//    private val recyclerViewActivity = RecyclerViewActivity()
    private  var recycleViewListener: OnRecyclerCardClick?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recycler_view_card, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val adapter = JobItemAdapter(data, this)
        recyclerView.adapter = adapter


        return view
    }



    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        if (context is OnRecyclerCardClick) {
            recycleViewListener = context as OnRecyclerCardClick
        } else {
            throw RuntimeException("$context must implement OnDataPass")
        }
    }

    override fun onItemClick(position: Int) {
//        val intent = Intent(RecyclerViewActivity(), JobDetailsActivity::class.java)
//        intent.putExtra("tvCompany", data[position].tvCompany)
//        intent.putExtra("tvTittle", data[position].tvTitle)
//        intent.putExtra("salary", data[position].salary)
//        startActivity(intent)

        val intent = Intent()
        val jobDetailsData = JobDetailsData()

        jobDetailsData.tvTittle = data[position].tvTitle
        jobDetailsData.tvCompany = data[position].tvCompany
        jobDetailsData.salary = data[position].salary

        recycleViewListener?.onCardClickListener(jobDetailsData)

//        val bundle = Bundle()
//        bundle.putString("tvTittle", data[position].tvTitle)
//        bundle.putString("tvCompany", data[position].tvCompany)
//        bundle.putString("salary", data[position].salary)
//
//        val jobDetails = JobDetailsFragment()
//        jobDetails.arguments = bundle
//
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.add(R.id.recyclerViewCard, jobDetails)
//        fragmentTransaction.addToBackStack(null)
//        fragmentTransaction.commit()
        
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.add(R.id.recyclerViewCard, jobDetails)
//        fragmentTransaction.addToBackStack(null)
//        fragmentTransaction.commit()
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("bino","")
    }


}