package fr.postz.cashmanager

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.net.Uri
import android.nfc.NfcAdapter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.ViewPager
import android.widget.LinearLayout
import android.widget.Toast
import fr.postz.cashmanager.dummy.DummyContent
import kotlinx.android.synthetic.main.fragment_products_list.*
import java.util.ArrayList
import android.support.v4.app.FragmentPagerAdapter
import android.view.View
import fr.postz.cashmanager.ViewModel.CaddieModel
import java.io.Serializable


class MainActivity : AppCompatActivity(), NcfReader.OnFragmentInteractionListener, ProductsFragment.OnListFragmentInteractionListener, Caddie.OnListFragmentInteractionListener{


    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {

    }

    override fun onFragmentInteraction(uri: Uri) {
        Toast.makeText(this,"lala ", Toast.LENGTH_LONG ).show()
    }




    private var fNfcReader: Fragment?= null
    private var fProductsFragment: Fragment? = null;


    private lateinit var mPager: ViewPager


    private lateinit var sharedViewModel: CaddieModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mPager = findViewById(R.id.viewPager)



        val mFragmentAdapter = MyPagerAdapter(getSupportFragmentManager());
        this.let {
            sharedViewModel = ViewModelProviders.of(it).get(CaddieModel::class.java)
        }
        sharedViewModel.set(DummyContent.ITEMS);
        mPager.setAdapter(mFragmentAdapter);
    }


    private inner class MyPagerAdapter(supportFragmentManager: FragmentManager) :
        FragmentPagerAdapter(supportFragmentManager) {

        // Returns the fragment to display for that page
        override fun getItem(position: Int): Fragment? {

            when (position) {
                0 -> return NcfReader()
                1 -> return ProductsFragment()
                2 -> return Caddie()
                else -> return null
            }
        }

        // Returns total number of pages
        override fun getCount(): Int {
            return 3
        }

    }




}
