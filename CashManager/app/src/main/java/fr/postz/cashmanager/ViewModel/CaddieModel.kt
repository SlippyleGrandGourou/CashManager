package fr.postz.cashmanager.ViewModel

import android.arch.lifecycle.ViewModel
import fr.postz.cashmanager.dummy.DummyContent

class CaddieModel: ViewModel(){

    private var caddie: MutableList<DummyContent.DummyItem>  =  ArrayList();




    public fun get() : MutableList<DummyContent.DummyItem> {
        return caddie;
    }

    public fun getFiltre() : MutableList<DummyContent.DummyItem> {
        var test: MutableList<DummyContent.DummyItem> = ArrayList()

        for (e in caddie ){
            if (e.getCount() != "0")
                test.add(e);
        }
        return test;
    }


    public fun set(list :MutableList<DummyContent.DummyItem>) {
        caddie = list;
    }
}