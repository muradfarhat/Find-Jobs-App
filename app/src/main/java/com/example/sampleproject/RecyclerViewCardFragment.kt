package com.example.sampleproject

import android.os.Bundle
import android.app.Fragment
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleproject.interfaces.OnItemClickListener
import com.example.sampleproject.views.activities.Item
import com.example.sampleproject.views.activities.JobDetailsActivity
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


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recycler_view_card, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(RecyclerViewActivity())

        val adapter = JobItemAdapter(data, this)
        recyclerView.adapter = adapter

        return view
    }


    override fun onItemClick(position: Int) {
        val intent = Intent(RecyclerViewActivity(), JobDetailsActivity::class.java)
        intent.putExtra("tvCompany", data[position].tvCompany)
        intent.putExtra("tvTittle", data[position].tvTitle)
        intent.putExtra("salary", data[position].salary)
        startActivity(intent)
    }
}