package com.houseofivy.docket;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.houseofivy.docket.R;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class timeTable extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private DrawerLayout dl;
    private ActionBarDrawerToggle andt;
    private int fragmentPosition;
    static TimeTable_Data timeTable_data = new TimeTable_Data();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        dl = findViewById(R.id.drl_student);
        andt = new ActionBarDrawerToggle(this, dl, R.string.open, R.string.close);
        andt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(andt);
        andt.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view_student);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_se_option:
                        Toast.makeText(timeTable.this, "SE", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(timeTable.this, timeTable_se.class));
                        timeTable.this.finish();
                        break;

                    case R.id.nav_te_option:
                        Toast.makeText(timeTable.this, "TE", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_be_option:
                        Toast.makeText(timeTable.this, "BE", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(timeTable.this, timeTable_be.class));
                        timeTable.this.finish();
                        break;

                    case R.id.nav_teacher:
                        Toast.makeText(timeTable.this, "Teacher", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(timeTable.this, timeTable_teacher.class));
                        timeTable.this.finish();
                        break;

                    case R.id.nav_notify:
                        Toast.makeText(timeTable.this, "Notification", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_timetable_manage:
                        Toast.makeText(timeTable.this, "Teacher", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(timeTable.this, timeTable_manage.class));
                        timeTable.this.finish();
                        break;

                    case R.id.nav_timetable_create:
                        Toast.makeText(timeTable.this, "Teacher", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(timeTable.this, timeTable_Generate.class));
                        break;

                    case R.id.nav_logout:
                        Toast.makeText(timeTable.this, "Logout", Toast.LENGTH_SHORT).show();
                        FirebaseAuth firebaseAuth;
                        firebaseAuth = FirebaseAuth.getInstance();
                        firebaseAuth.signOut();
                        startActivity(new Intent(timeTable.this, LoginActivity.class));
                        timeTable.this.finish();
                        break;

                    default:
                        Toast.makeText(timeTable.this, "You Clicked a Button", Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });


    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_time_table, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
/*
        switch (id){
            case R.id.action_se:
                startActivity(new Intent(this,timeTable_SE.class));
                return true;

            case R.id.action_te:
                startActivity(new Intent(this,timeTable.class));
                return true;

            case R.id.action_be:
                startActivity(new Intent(this,timeTable_BE.class));
                return true;
        }
*/


        return andt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);

            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_time_table, container, false);
            TextView header = rootView.findViewById(R.id.tv_header);
            header.setText("TE TIMETABLE");
            Button btn[] = new Button[timeTable_data.ids.length];
            switch (getArguments().getInt(ARG_SECTION_NUMBER)){
                case 1:
                    for(int i = 0 ; i < timeTable_data.ids.length ; i ++){
                        btn[i] = (Button) rootView.findViewById(timeTable_data.ids[i]);
                        btn[i].setText(timeTable_data.te_t1[i]);
                    }
                    break;

                case 2:
                    for(int i = 0 ; i < timeTable_data.ids.length ; i ++){
                        btn[i] = (Button) rootView.findViewById(timeTable_data.ids[i]);
                        btn[i].setText(timeTable_data.te_t2[i]);
                    }
                    break;

                case 3:
                    for(int i = 0 ; i < timeTable_data.ids.length ; i ++){
                        btn[i] = (Button) rootView.findViewById(timeTable_data.ids[i]);
                        btn[i].setText(timeTable_data.te_t3[i]);
                    }
                    break;

                case 4:
                    for(int i = 0 ; i < timeTable_data.ids.length ; i ++){
                        btn[i] = (Button) rootView.findViewById(timeTable_data.ids[i]);
                        btn[i].setText(timeTable_data.te_t4[i]);
                    }
                    break;

            }
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            fragmentPosition = position;
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 4;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            String title;
            switch(position){
                case 0:
                    return "T!";

                case 1:
                    return "T2";

                case 2:
                    return "T3";

                case 3:
                    return "T4";
            }
            return null;
        }
    }




    public void onClickListen(View view) {
        switch (view.getId()) {
            case R.id.tv_0_0:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_0_1:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_0_2:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_0_3:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_0_4:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_0_5:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_0_6:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_1_0:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_1_1:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_1_2:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_1_3:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_1_4:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_1_5:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_1_6:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_2_0:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_2_1:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_2_2:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_2_3:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_2_4:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_2_5:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_2_6:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_3_0:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_3_1:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_3_2:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_3_3:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_3_4:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_3_5:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_3_6:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_4_0:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_4_1:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_4_2:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_4_3:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_4_4:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_4_5:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_4_6:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_5_0:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_5_1:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_5_2:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_5_3:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_5_4:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_5_5:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_5_6:
                Toast.makeText(timeTable.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;
        }
    }

    public void showPopUp() {
        final Dialog myDialog = new Dialog(this);

        myDialog.setContentView(R.layout.pop_up_info);
        Button close = myDialog.findViewById(R.id.btn_pop_up_close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
}
