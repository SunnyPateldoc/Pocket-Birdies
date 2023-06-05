package com.example.pocketbirdies.fragment


import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pocketbirdies.R
import com.example.pocketbirdies.activity.Home
import com.example.pocketbirdies.adapter.AdapterPreferedTime
import com.github.sundeepk.compactcalendarview.CompactCalendarView
import com.github.sundeepk.compactcalendarview.domain.Event
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class LessonFragment : Fragment() {

    //lateinit var datePiker : MaterialDatePicker

    lateinit var calenderView: CompactCalendarView

    lateinit var spinner: Spinner
    lateinit var btNext: ImageView
    lateinit var btBack: ImageView
    lateinit var imgProfile: ImageView

    lateinit var textMonthYear: TextView
    lateinit var textName: TextView

    lateinit var recyclerView: RecyclerView
    var timeList = ArrayList<String>()

    val args : LessonFragmentArgs by navArgs<LessonFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_lesson, container, false)


        calenderView = view.findViewById(R.id.calender_view)
        calenderView.shouldScrollMonth(false)

        btNext = view.findViewById(R.id.img_next)
        btBack = view.findViewById(R.id.img_back)

        imgProfile = view.findViewById(R.id.img_profile)
        textName = view.findViewById(R.id.text_name)

        spinner = view.findViewById(R.id.spinner)

        recyclerView = view.findViewById(R.id.recycler_view)

        val data = args.lessonInstroctor

        Glide.with(requireContext()).load(data.imageProfile).circleCrop().into(imgProfile)

        textName.setText(data.nameInstructors)

        val recyclerAdapter = AdapterPreferedTime(timeList)
        recyclerView.layoutManager =
            GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        recyclerView.adapter = recyclerAdapter

        textMonthYear = view.findViewById(R.id.text_month_year)


        val list = arrayOf("1 hour", "30 mins")

        val spinnerAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, list)

        spinner.setAdapter(spinnerAdapter)

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.setSelection(0)


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

        val day = Calendar.getInstance()
        day.add(Calendar.DAY_OF_MONTH,4)
        //set Event

        val event1 = Event(resources.getColor(R.color.cream_90), day.timeInMillis, "Event 1")
        calenderView.addEvent(event1)

        day.add(Calendar.DAY_OF_MONTH,15)
        val event2 = Event(resources.getColor(R.color.cream_90),day.timeInMillis, "Event 1")
        calenderView.addEvent(event2)


        calenderView.setListener(object : CompactCalendarView.CompactCalendarViewListener {
            override fun onDayClick(dateClicked: Date?) {
                // Change the color of the selected date
                calenderView.setCurrentSelectedDayBackgroundColor(resources.getColor(R.color.cream_100))

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

        if (item.itemId==R.id.item_next){
            findNavController().navigate(R.id.reviewDetailsFragment)
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        menu.clear()

        inflater.inflate(R.menu.lesson_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }




}