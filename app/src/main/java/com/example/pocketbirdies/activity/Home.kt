package com.example.pocketbirdies.activity


import android.app.ActionBar.LayoutParams
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.bumptech.glide.Glide
import com.example.pocketbirdies.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar


class Home : AppCompatActivity() {

    var isBottomViewVisible = true
    var isHomeActionBar = true
    var isSecondActionBar = true
    var isChatActionBar = true
    var setTitle = "Welcome Back!"
    var setBack = "Back"

     var mListstner : onClickListener? = null

    interface onClickListener{

        fun onClickImageOption(view: View)
        fun onClickTextName(view: View)
        fun onClickImageProfile(view: View)

    }

    fun setOnClickListener(listener: onClickListener){

        this.mListstner = listener

    }


    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var navController: NavController

    lateinit var drawerLayout: DrawerLayout
    lateinit var rootLaylout: ConstraintLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var naviView: NavigationView

    lateinit var imgLogout: ImageView
    lateinit var textLogout: TextView

    var textBack: TextView? = null

    var textTile: TextView? = null

    var imgProfile: ImageView? = null
    var imgOption: ImageView? = null
    var textName: TextView? = null

    var image:String? = null
    var name:String? = null

    var layout: View? = null

    lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        window.statusBarColor = ContextCompat.getColor(applicationContext, R.color.white)

        val drawerView = layoutInflater.inflate(R.layout.home_screen_drawer, null)

        toolbar = findViewById(R.id.toolbar)
        rootLaylout = findViewById(R.id.root)

        bottomNavigationView = findViewById(R.id.bottom_navigation_view)

        drawerLayout = findViewById(R.id.drawer_layouy)
        naviView = findViewById(R.id.nav_view)

        imgLogout = findViewById(R.id.img_logout)
        textLogout = findViewById(R.id.text_title_logout)



        imgLogout.setOnClickListener {

            startActivity(Intent(applicationContext, LoginPlayer::class.java))
            finish()

        }

        textLogout.setOnClickListener {

            startActivity(Intent(applicationContext, LoginPlayer::class.java))
            finish()

        }


        setSupportActionBar(toolbar)

        this.supportActionBar!!.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar!!.setDisplayShowCustomEnabled(true)

        layout = layoutInflater.inflate(R.layout.actionbar_layout_main, null)
        supportActionBar!!.setCustomView(
            layout,
            ActionBar.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.WRAP_CONTENT
            )
        )

        textBack = supportActionBar!!.customView.findViewById(R.id.text_back)

        //set drawer view
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)

        drawerLayout.addDrawerListener(actionBarDrawerToggle)

        actionBarDrawerToggle.syncState()


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view_home) as NavHostFragment
        navController = navHostFragment.navController

        setupWithNavController(bottomNavigationView, navController)
        setupWithNavController(naviView, navController)

        // naviView.setupWithNavController(navController)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.item_bell
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)


        naviView.setNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.my_account -> {
                    navController.navigate(R.id.my_account)
                    true
                }
                R.id.notification_settings -> {
                    navController.navigate(R.id.notification_settings)
                    true
                }
                R.id.about_us -> {
                    navController.navigate(R.id.about_us)
                    true
                }
                R.id.privacy_policy -> {
                    navController.navigate(R.id.privacy_policy)
                    true
                }
                R.id.terms_of_use -> {
                    navController.navigate(R.id.terms_of_use)
                    true
                }
                R.id.at_home_program -> {
                    navController.navigate(Uri.parse("navapp://coming_soon/coming_soon"))
                    true
                }
                R.id.contact_us -> {
                    navController.navigate(R.id.contact_us)
                    true
                }
                R.id.deactivate_account -> {
                    true
                }
                R.id.delete_account -> {
                    true
                }

                else -> {
                    true
                }
            }

            drawerLayout.closeDrawer(GravityCompat.START)

            true

        }



        navController.addOnDestinationChangedListener(object :
            NavController.OnDestinationChangedListener {

            override fun onDestinationChanged(
                controller: NavController,
                destination: NavDestination,
                arguments: Bundle?
            ) {
                val title: String = destination.label.toString()


                when (destination.id) {
                    R.id.about_us -> {
                        setFragmetActive(false, false, true, false, title, "Back")
                    }
                    R.id.addReviewFragment -> {
                        setFragmetActive(true, false, true, false, title, "Back")

                    }
                    R.id.cardDetailsFragment -> {
                        setFragmetActive(false, false, true, false, title, "Cancel")

                    }
                    R.id.chatFragment -> {
                        setFragmetActive(true, false, false, true, title, "Back")

                    }
                    R.id.coming_soon -> {
                        setFragmetActive(true, false, true, false, title, "Back")

                    }
                    R.id.completedDetailsFragment -> {
                        setFragmetActive(true, false, true, false, title, "Back")

                    }
                    R.id.contact_us -> {
                        setFragmetActive(false, false, true, false, title, "Back")

                    }
                    R.id.profile -> {
                        setFragmetActive(true, true, false, false, title, "Back")

                    }
                    R.id.emailAddressFragment -> {
                        setFragmetActive(false, false, true, false, title, "Back")

                    }
                    R.id.filterFragment -> {
                        setFragmetActive(false, false, true, false, title, "Cancel")

                    }
                    R.id.find_lesson -> {
                        setFragmetActive(true, false, true, false, title, "Back")

                    }
                    R.id.home -> {
                        setFragmetActive(true, true, false, false, title, "Back")

                    }
                    R.id.lessonFragment -> {
                        setFragmetActive(true, false, true, false, title, "Back")

                    }
                    R.id.massages -> {
                        setFragmetActive(true, true, false, false, title, "Back")
                    }
                    R.id.my_account -> {
                        setFragmetActive(false, false, true, false, title, "Back")

                    }

                    R.id.nearme -> {
                        setFragmetActive(true, true, false, false, title, "Back")

                    }
                    R.id.newMessageFragment -> {
                        setFragmetActive(false, false, true, false, title, " ")
                    }
                    R.id.item_bell -> {
                        setFragmetActive(false, false, true, false, title, " ")

                    }
                    R.id.notification_settings -> {
                        setFragmetActive(false, false, true, false, title, "Back")

                    }
                    R.id.paymentFragment -> {
                        setFragmetActive(false, false, true, false, title, "Cancel")

                    }

                    R.id.privacy_policy -> {
                        setFragmetActive(false, false, true, false, title, "Back")

                    }
                    R.id.editProfileFragment -> {
                        setFragmetActive(false, false, true, false, title, "Back")

                    }
                    R.id.reviewDetailsFragment -> {
                        setFragmetActive(true, false, true, false, title, "Back")

                    }
                    R.id.reviewsFragment -> {
                        setFragmetActive(true, false, true, false, title, "Back")

                    }
                    R.id.schedule -> {
                        setFragmetActive(true, true, false, false, title, "Back")

                    }
                    R.id.terms_of_use -> {
                        setFragmetActive(false, false, true, false, title, "Back")

                    }
                    R.id.upcomingDetailsFragment -> {
                        setFragmetActive(true, false, true, false, title, "Back")

                    }
                    R.id.updatePasswordFragment -> {
                        setFragmetActive(false, false, true, false, title, "Back")

                    }

                }

            }

        })

        textBack!!.setOnClickListener {

            this.onBackPressed()

        }


    }


    fun setFragmetActive(
        isBottomView: Boolean,
        isHomeActionBar: Boolean,
        isSecondActionBar: Boolean,
        isChatActionBar: Boolean,
        getTitle: String,
        getBack: String
    ) {

        val mainLayout = findViewById<View>(R.id.include_layout) as ConstraintLayout
        mainLayout.visibility = View.VISIBLE

        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        layout = inflater.inflate(R.layout.actionbar_title_layout, null)
        mainLayout.removeAllViews()
        mainLayout.addView(
            layout,
            ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        )

        actionBarDrawerToggle.isDrawerIndicatorEnabled = true


        setBottomNavigationViewVisibility(isBottomView)

        if (isHomeActionBar) {

            setHomeActionBar(getTitle)

        } else if (isSecondActionBar) {

            setSecondActionBar(getBack, getTitle)

        } else if (isChatActionBar) {

            setChatActionBar()

        }



        this.isBottomViewVisible = isBottomView
        this.isHomeActionBar = isHomeActionBar
        this.isSecondActionBar = isSecondActionBar
        this.isChatActionBar = isChatActionBar
        this.setTitle = getTitle
        this.setBack = getBack


    }

    fun setChatActionBar() {

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(getDrawable(R.drawable.icon_ionic_ios_arrow_back))

        actionBarDrawerToggle.isDrawerIndicatorEnabled = false
        val mainLayout = findViewById<View>(R.id.include_layout) as ConstraintLayout
        mainLayout.visibility = View.VISIBLE

        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        layout = inflater.inflate(R.layout.actionbar_chat_title_layout, null)

        imgProfile = layout!!.findViewById(R.id.img_profile)
        imgOption = layout!!.findViewById(R.id.img_option_menu)
        textName = layout!!.findViewById(R.id.text_title)

        Glide.with(this).load(image).circleCrop().into(imgProfile!!)
        textName!!.setText(name)

        mainLayout.removeAllViews()
        mainLayout.addView(
            layout,
            ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        )

        imgProfile!!.setOnClickListener { mListstner!!.onClickImageProfile(it) }
        imgOption!!.setOnClickListener { mListstner!!.onClickImageOption(it) }
        textName!!.setOnClickListener { mListstner!!.onClickTextName(it) }


        textBack!!.visibility = View.GONE
    }

    fun setChatTitle(image: String, name: String) {

        this.image = image
        this.name = name


    }

    private fun setSecondActionBar(
        getBack: String,
        getTitle: String
    ) {


        supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        supportActionBar!!.setDisplayShowHomeEnabled(false)
        supportActionBar!!.setHomeAsUpIndicator(getDrawable(R.drawable.icon_feather_menu))
        textBack!!.visibility = View.VISIBLE
        textBack!!.setText(getBack)

        textTile = supportActionBar!!.customView.findViewById(R.id.text_title)


        textTile!!.setText(getTitle)

        setTitle = getTitle
    }

    private fun setHomeActionBar(getTitle: String) {


        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(getDrawable(R.drawable.icon_feather_menu))

        textBack!!.visibility = View.GONE

        textTile = supportActionBar!!.customView.findViewById(R.id.text_title)
        textTile!!.setText(getTitle)

        setTitle = getTitle
    }

    fun setBottomNavigationViewVisibility(isVisible: Boolean) {

        isBottomViewVisible = isVisible

        if (isVisible) {
            bottomNavigationView.visibility = View.VISIBLE
        } else {
            bottomNavigationView.visibility = View.GONE
        }
    }


    override fun onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
            return
        }

    }

    fun setBadge(menu: Menu?) {

        val menuItem = menu!!.findItem(R.id.item_bell)

        menuItem.setIcon(R.drawable.badge_set)
//menuItem.setIcon(R.drawable.badge_not)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.action_menu, menu)


        setBadge(menu)


        return super.onCreateOptionsMenu(menu)

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        return if (actionBarDrawerToggle.isDrawerIndicatorEnabled && actionBarDrawerToggle.onOptionsItemSelected(
                item
            )
        ) {


            true
        } else if (item.itemId == android.R.id.home) {
            onBackPressed()
            true
        } else if (item.itemId == R.id.item_bell) {
            navController.navigate(R.id.item_bell)
            true
        } else super.onOptionsItemSelected(item)
    }


    fun onSnackBar(message: String) {

        Snackbar.make(rootLaylout, message, Snackbar.LENGTH_SHORT)
            .setBackgroundTint(getColor(R.color.white_85))
            .setTextColor(getColor(R.color.black_title))
            .show()
    }


}