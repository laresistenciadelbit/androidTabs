package com.chatapp.tablayoutagain;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    FrameLayout simpleFrameLayout;
    static TabLayout tabLayout;
    ArrayList<Fragment>fragment_arr=new ArrayList<>();
    ArrayList<String>opened_channel_arr=new ArrayList<>();
    static ArrayList<ArrayList<String>>opened_channel_arr_content=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get the reference of FrameLayout and TabLayout
        simpleFrameLayout = (FrameLayout) findViewById(R.id.simpleFrameLayout);
        tabLayout = (TabLayout) findViewById(R.id.simpleTabLayout);

        TabLayout.Tab firstTab = tabLayout.newTab();
        firstTab.setText("First"); // set the Text for the first Tab
        //firstTab.setIcon(R.drawable.ic_launcher); // set an icon for the
        tabLayout.addTab(firstTab); // add  the tab at in the TabLayout
        fragment_arr.add(new myFragment());
        opened_channel_arr.add("First");
        opened_channel_arr_content.add(new ArrayList<String>());

        TabLayout.Tab secondTab = tabLayout.newTab();
        secondTab.setText("Second"); // set the Text for the second Tab
        //secondTab.setIcon(R.drawable.ic_launcher); // set an icon for the second tab
        tabLayout.addTab(secondTab); // add  the tab  in the TabLayout
        fragment_arr.add(new myFragment());
        opened_channel_arr.add("Second");
        opened_channel_arr_content.add(new ArrayList<String>());

        TabLayout.Tab thirdTab = tabLayout.newTab();
        thirdTab.setText("Third"); // set the Text for the first Tab
        //thirdTab.setIcon(R.drawable.ic_launcher); // set an icon for the first tab
        tabLayout.addTab(thirdTab); // add  the tab at in the TabLayout
        fragment_arr.add(new myFragment());
        opened_channel_arr.add("Third");
        opened_channel_arr_content.add(new ArrayList<String>());

        TabLayout.Tab thirdTab1 = tabLayout.newTab();
        thirdTab1.setText("4"); // set the Text for the first Tab
        //thirdTab1.setIcon(R.drawable.ic_launcher); // set an icon for the first tab
        tabLayout.addTab(thirdTab1); // add  the tab at in the TabLayout
        fragment_arr.add(new myFragment());
        opened_channel_arr.add("4");
        opened_channel_arr_content.add(new ArrayList<String>());

        TabLayout.Tab thirdTab2 = tabLayout.newTab();
        thirdTab2.setText("5"); // set the Text for the first Tab
        //thirdTab2.setIcon(R.drawable.ic_launcher); // set an icon for the first tab
        tabLayout.addTab(thirdTab2); // add  the tab at in the TabLayout
        fragment_arr.add(new myFragment());
        opened_channel_arr.add("5");
        opened_channel_arr_content.add(new ArrayList<String>());

        TabLayout.Tab thirdTab3 = tabLayout.newTab();
        thirdTab3.setText("6"); // set the Text for the first Tab
        //thirdTab3.setIcon(R.drawable.ic_launcher); // set an icon for the first tab
        tabLayout.addTab(thirdTab3); // add  the tab at in the TabLayout
        fragment_arr.add(new myFragment());
        opened_channel_arr.add("6");
        opened_channel_arr_content.add(new ArrayList<String>());

        // perform setOnTabSelectedListener event on TabLayout
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.
            simpleFrameLayout, fragment_arr.get(tab.getPosition())); //tomamos el fragment del arraylist
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
        }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        Button button_add= (Button) findViewById(R.id.b_add_tab);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabLayout.Tab aTab = tabLayout.newTab();
                String tabname="otra-"+ new Random().nextInt((9 - 0 + 1) + 0);
                aTab.setText(tabname); //random del 0 al 9
                tabLayout.addTab(aTab);
                //adapter.addTabPage();
                fragment_arr.add(new myFragment());
                opened_channel_arr.add(tabname);
                opened_channel_arr_content.add(new ArrayList<String>());

                aTab.select();//tras crearla entramos en ella
            }
        });


        Button button_del= (Button) findViewById(R.id.b_del_tab);
        button_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tab_to_remove=tabLayout.getSelectedTabPosition();
                if(tabLayout.getTabCount()>1 && tab_to_remove>0)   //no se si la selección comienza en la 0 o en la 1
                {
                    tabLayout.getTabAt(tab_to_remove - 1).select();//<---------force it to go to the previous tab
                    tabLayout.removeTabAt(tab_to_remove);
                    ////(si usaramos adapter (swipe)): adapter.removeTabPage(tab_to_remove);
                    //eliminamos de los arraylist
                        opened_channel_arr.remove(tab_to_remove);
                        opened_channel_arr_content.remove(tab_to_remove);
                        fragment_arr.remove(tab_to_remove);
                }
            }
        });


        Button button_mod_frag= (Button) findViewById(R.id.mod_frag_3_layout);   //modifica contenido del layout de un fragment desde MainActivity
        button_mod_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0; i<opened_channel_arr.size();i++)
                    if(opened_channel_arr.get(i).equals("Third")  && thirdTab.isSelected() )   //buscamos el que queremos modificar
                        ( (TextView) fragment_arr.get(i).getView().findViewById(R.id.tv_fragment) ).setText("texto cambiado!");
            }
        });

        Button button_mod_cache= (Button) findViewById(R.id.mod_tab3_content);   //modifica contenido de un fragment almacenandolo en cache hasta que se restaure la pestaña y lo recupere
        button_mod_cache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0; i<opened_channel_arr.size();i++)
                    if(opened_channel_arr.get(i).equals("Third"))
                        opened_channel_arr_content.get(i).add("contenido añadido desde cache!");    //contenido añadido desde cache, al abrir la pestaña recuperará este contenido
            }
        });


    }
}
