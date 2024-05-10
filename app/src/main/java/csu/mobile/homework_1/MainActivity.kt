package csu.mobile.homework_1

import android.os.Bundle
import android.view.View
import androidx.activity.EdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy

class MainActivity : AppCompatActivity() {
    private var viewPager: ViewPager2? = null
    private var tabLayout: TabLayout? = null
    private var viewPagerAdapter: ViewPagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)
        EdgeToEdge.enable(this)
        viewPager = findViewById<ViewPager2>(R.id.viewPager)
        tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        viewPagerAdapter = ViewPagerAdapter(this)
        viewPagerAdapter.addFragment(FriendListFragment.newInstance(), "Friends")
        viewPagerAdapter.addFragment(LoadingFragment.newInstance(), "Loading")
        viewPager.setAdapter(viewPagerAdapter)
        val originalTabTexts = arrayOfNulls<String>(tabLayout.getTabCount())
        for (i in 0 until tabLayout.getTabCount()) {
            originalTabTexts[i] = tabLayout.getTabAt(i)!!.text.toString()
        }
        TabLayoutMediator(tabLayout, viewPager,
            TabConfigurationStrategy { tab: TabLayout.Tab, position: Int ->
                tab.text = originalTabTexts[position]
            }
        ).attach()
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById<View>(R.id.main)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}