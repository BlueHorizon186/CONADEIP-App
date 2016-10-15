package mx.itesm.cem.mmf.protoconadeip;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    String[] opciones2 = {"X1","X2"};
    TabLayout tL;
    ViewPager vP;
    Pant1 p1=new Pant1();
    Pant2 p2=new Pant2();
    Pant3 p3=new Pant3();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vP=(ViewPager) findViewById(R.id.viewPager);
        vP.setAdapter(new CustomAdapter(getSupportFragmentManager(),getApplicationContext()));

        tL=(TabLayout) findViewById(R.id.tabLayout);
        tL.setupWithViewPager(vP);

        tL.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vP.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                vP.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                vP.setCurrentItem(tab.getPosition());
            }
        });
    }

    private class CustomAdapter extends FragmentPagerAdapter {
        private String frag []={"Apartado 1","Apartado 2","Apartado 3"};
        public CustomAdapter(FragmentManager supportFragmentManager, Context applicationContext) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            if(position==0){

                return p1;
            }else if(position==1){
                return p2;
            }else if(position==2){
                return p3;
            }else{
            return null;}
        }

        @Override
        public int getCount() {
            return frag.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return frag[position];
        }
    }
}
