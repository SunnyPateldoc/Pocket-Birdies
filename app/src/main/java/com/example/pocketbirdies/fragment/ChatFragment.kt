package com.example.pocketbirdies.fragment

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.fonts.FontFamily
import android.graphics.fonts.FontStyle
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.view.View.OnTouchListener
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pocketbirdies.R
import com.example.pocketbirdies.activity.Home
import com.example.pocketbirdies.adapter.AdapterChat


class ChatFragment : Fragment() {

    lateinit var edtMessages: EditText

    lateinit var recyclerView: RecyclerView

    lateinit var imgOption :ImageView

    lateinit var imgProfil :ImageView
    lateinit var textName :TextView
    lateinit var textView:TextView

    var report : TextView? = null
    var block : TextView? = null
    var removeChat : TextView? = null

    private val args : ChatFragmentArgs by navArgs<ChatFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val activity = (requireActivity() as Home)

        activity.supportActionBar!!.setHomeAsUpIndicator(R.drawable.icon_ionic_ios_arrow_back)
        activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val view = inflater.inflate(R.layout.fragment_chat, container, false)

        val data = args.chatInstrocter



        activity.setOnClickListener(object : Home.onClickListener{
            override fun onClickImageOption(view: View) {

                onShowPopup(view)

            }

            override fun onClickTextName(view: View) {

                Toast.makeText(requireContext(),"${data.nameInstructors}",Toast.LENGTH_SHORT).show()

            }

            override fun onClickImageProfile(view: View) {

                Toast.makeText(requireContext(),"ok",Toast.LENGTH_SHORT).show()


            }


        })

        edtMessages = view.findViewById(R.id.edt_message)


        edtMessages.setOnTouchListener(object :OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                val left = 0
                val top = 1
                val right = 2
                val bottom = 3

                if (event!!.action == MotionEvent.ACTION_UP){

                    if (event!!.rawX >= (edtMessages.right)-edtMessages.compoundDrawables[right].bounds.width()){


                        validation()

                        return true
                    }

                }
                return false
            }

        })



        /*val view2 =layoutInflater.inflate(R.layout.chat_bottome_layout, null)

        val dialog = BottomSheetDialog(requireContext())
        dialog.setContentView(view2)
        dialog.setCancelable(false)
        dialog.show()*/

        /*imgOption.setOnClickListener {

            onShowPopup(it)

        }*/


        recyclerView = view.findViewById(R.id.recycler_view)

        val list = ArrayList<String>()
        list.add("Mihir")
        list.add("Sunny")
        list.add("Dhruv")
        list.add("Sunny")
        list.add("Dhruv")
        list.add("Dhruv")
        list.add("Sunny")
        list.add("Dhruv")
        list.add("Sunny")
        list.add("Sunny")

        val adapter = AdapterChat(list)
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter


        recyclerView.scrollToPosition(adapter.getItemCount()-1)


        report = TextView(requireActivity())
        block = TextView(requireActivity())
        removeChat = TextView(requireActivity())




        return view
    }

    private fun validation() {


        val message = edtMessages.text.toString()

        Toast.makeText(requireContext(),"$message",Toast.LENGTH_SHORT).show()

        edtMessages.setText("")


    }

    private fun onShowPopup(view: View?) {


        val layoutInflater =
            requireActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val popupLayout = layoutInflater.inflate(R.layout.popup_layout, null)


        val popupWindow = PopupWindow(requireContext())

        popupWindow.contentView = popupLayout

        popupWindow.width = ViewGroup.LayoutParams.MATCH_PARENT
        popupWindow.height = ViewGroup.LayoutParams.WRAP_CONTENT

        popupWindow.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        popupWindow.setOutsideTouchable(true)
        popupWindow.setOnDismissListener(PopupWindow.OnDismissListener {


        })
        val report = popupLayout.findViewById<TextView>(R.id.text_report)
        val block = popupLayout.findViewById<TextView>(R.id.text_block)
        val remove = popupLayout.findViewById<TextView>(R.id.text_remove_chat)

        report.setOnClickListener {


            findNavController().navigate(Uri.parse("navapp://report/report"))

            popupWindow.dismiss()


        }

        block.setOnClickListener {

            findNavController().navigate(R.id.blockDialog)

            popupWindow.dismiss()

        }

        remove.setOnClickListener {


            findNavController().navigate(R.id.removeChatDialog)

            popupWindow.dismiss()

        }

        popupWindow.showAsDropDown(view)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId==android.R.id.home){

            requireActivity().onBackPressed()

        }
        if (item.itemId == R.id.item_option){

            onShowPopup((requireActivity() as Home).supportActionBar!!.customView)

        }


        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        menu.clear()

        //inflater.inflate(R.menu.chat_menu,menu)

        super.onCreateOptionsMenu(menu, inflater)

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
        activity.supportActionBar!!.setHomeAsUpIndicator(R.drawable.icon_ionic_ios_arrow_back)
        activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }




}