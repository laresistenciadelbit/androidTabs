package com.chatapp.tablayoutagain;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter_class extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter_class(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        return new Fragment_class();
        /*
        switch (position) {
            case 0:
                Fragment_class tab1 = new Fragment_class();
                return tab1;
            case 1:
                Fragment_class tab2 = new Fragment_class();
                return tab2;
            case 2:
                Fragment_class tab3 = new Fragment_class();
                return tab3;
            default:
                return null;
        }*/
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    public void addTabPage(/*String title*/) {  // https://stackoverflow.com/questions/34306476/dynamically-add-and-remove-tabs-in-tablayoutmaterial-design-android , https://github.com/android-ide/platform_development/blob/master/samples/SupportDesignDemos/src/com/example/android/support/design/widget/TabLayoutUsage.java
        mNumOfTabs++;//tabItems.add(title); //<-----------deberíamos hacerlo con un arraylist de strings en vez de con la cuenta de nº de pestañas
        notifyDataSetChanged();                             //  como aquí (o como en el ejemplo de arriba) \_http://www.gadgetsaint.com/android/create-viewpager-tabs-android/
    }

    public void removeTabPage(int position) {
        /*if (!tabItems.isEmpty() && position<tabItems.size()) {
            tabItems.remove(position);
            notifyDataSetChanged();
        }*/
        //if(mNumOfTabs>2)    //si estamos en esta pestaña antes tendremos que forzar el pasar a otra distinta! (lo hacemos así porque sino no podríamos cerrar la pestaña en la que estamos en este momento)
            mNumOfTabs--;
        notifyDataSetChanged();
    }




}