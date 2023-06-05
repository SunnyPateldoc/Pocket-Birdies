package com.example.pocketbirdies.fragment

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pocketbirdies.R
import com.example.pocketbirdies.activity.Home
import com.github.sundeepk.compactcalendarview.CompactCalendarView
import com.github.sundeepk.compactcalendarview.domain.Event
import java.util.*


class FilterFragment : Fragment() {

    lateinit var calenderView: CompactCalendarView

    lateinit var spinner: Spinner
    lateinit var btNext: ImageView
    lateinit var btBack: ImageView
    lateinit var textMonthYear: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val activity = (requireActivity() as AppCompatActivity)

        activity.supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        activity.supportActionBar!!.setDisplayShowHomeEnabled(false)


        val view = inflater.inflate(R.layout.fragment_filter, container, false)

        calenderView = view.findViewById(R.id.calender_view)
        calenderView.shouldScrollMonth(false)

        btNext = view.findViewById(R.id.img_next)
        btBack = view.findViewById(R.id.img_back)
        spinner = view.findViewById(R.id.spinner)
        textMonthYear = view.findViewById(R.id.text_month_year)


        val list = arrayOf("1 hour", "30 mins")

        val spinnerAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, list)

        spinner.adapter = spinnerAdapter

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.setSelection(0)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                p1: View?,
                position: Int,
                p3: Long
            ) {
                val items = parent?.getItemAtPosition(position).toString()


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {


            }

        }

        setCalenderStyle()

        return view
    }

    private fun setCalenderStyle() {


        val c = Calendar.getInstance()
        calenderView.setCurrentDate(c.time)
        textMonthYear.setText(
            "${
                c.getDisplayName(
                    Calendar.MONTH,
                    Calendar.LONG,
                    Locale.getDefault()
                )
            } ${c.get(Calendar.YEAR)}"
        )



        btNext.setOnClickListener {
            c.add(Calendar.MONTH, 1)
            calenderView.setCurrentDate(c.time)
            textMonthYear.setText(
                "${
                    c.getDisplayName(
                        Calendar.MONTH,
                        Calendar.LONG,
                        Locale.getDefault()
                    )
                } ${c.get(Calendar.YEAR)}"
            )
        }



        btBack.setOnClickListener {
            c.add(Calendar.MONTH, -1)
            calenderView.setCurrentDate(c.time)
            textMonthYear.setText(
                "${
                    c.getDisplayName(
                        Calendar.MONTH,
                        Calendar.LONG,
                        Locale.getDefault()
                    )
                } ${c.get(Calendar.YEAR)}"
            )
        }




        calenderView.shouldDrawIndicatorsBelowSelectedDays(true)

        val event1 =
            Event(resources.getColor(R.color.cream_90), System.currentTimeMillis(), "Event 1")
        calenderView.addEvent(event1)


        calenderView.setListener(object : CompactCalendarView.CompactCalendarViewListener {
            override fun onDayClick(dateClicked: Date?) {
                // Change the color of the selected date
                calenderView.setCurrentSelectedDayBackgroundColor(resources.getColor(R.color.cream_100))
                val event = Event(
                    resources.getColor(R.color.cream_90), dateClicked!!.time * 1000, "Event 2"
                )
                calenderView.addEvent(event)
            }

            override fun onMonthScroll(firstDayOfNewMonth: Date?) {
                // Handle month scrolling event
            }
        })

    }

    override fun onResume() {
        super.onResume()

        val activity = (requireActivity() as Home)

        val isBottome = activity.isBottomViewVisible
        val isHome = activity.isHomeActionBar
        val isSecond = activity.isSecondActionBar
        val isChat = activity.isChatActionBar
        val getTitle = activity.setTitle
        val getBack = activity.setBack

        activity.setFragmetActive(isBottome, isHome, isSecond, isChat, getTitle, getBack)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.item_save -> {  }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        menu.clear()

        inflater.inflate(R.menu.filter_menu,menu)

        super.onCreateOptionsMenu(menu, inflater)
    }


}