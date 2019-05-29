package com.chatapp.tablayoutagain;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ViewPager simpleViewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the reference of ViewPager and TabLayout
        simpleViewPager = (ViewPager) findViewById(R.id.simpleViewPager);
        tabLayout = (TabLayout) findViewById(R.id.simpleTabLayout);

        TabLayout.Tab firstTab = tabLayout.newTab();
        firstTab.setText("primera");
        tabLayout.addTab(firstTab);

        TabLayout.Tab secondTab = tabLayout.newTab();
        secondTab.setText("Segunda");
        tabLayout.addTab(secondTab);

        TabLayout.Tab thirdTab = tabLayout.newTab();
        thirdTab.setText("Tercera");
        tabLayout.addTab(thirdTab);

        final PagerAdapter_class adapter = new PagerAdapter_class(getSupportFragmentManager(), tabLayout.getTabCount());
        simpleViewPager.setAdapter(adapter);
        simpleViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tabSelected)
            {
                simpleViewPager.setCurrentItem(tabSelected.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tabSelected){}

            @Override
            public void onTabReselected(TabLayout.Tab tabSelected){

            }
        });

        Button button_add= (Button) findViewById(R.id.b_add_tab);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabLayout.Tab aTab = tabLayout.newTab();
                aTab.setText("otra-"+ new Random().nextInt((9 - 0 + 1) + 0)); //random del 0 al 9
                tabLayout.addTab(aTab);
                adapter.addTabPage();
                aTab.select();//tras crearla entramos en ella
            }
        });


        Button button_del= (Button) findViewById(R.id.b_del_tab);
        button_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tabLayout.getTabCount()>1 && tabLayout.getSelectedTabPosition()>0)   //no se si la selección comienza en la 0 o en la 1
                {
                    int tab_to_remove = tabLayout.getSelectedTabPosition();
                    tabLayout.getTabAt(tab_to_remove - 1).select();//<---------force it to go to the previous tab
                    tabLayout.removeTabAt(tab_to_remove);
                    adapter.removeTabPage(tab_to_remove);
                }
            }
        });


    }
}
