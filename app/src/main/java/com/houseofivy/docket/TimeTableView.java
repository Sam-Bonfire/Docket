package com.houseofivy.docket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class TimeTableView extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table_view);

        firebaseAuth= FirebaseAuth.getInstance();
        logout=(Button)findViewById(R.id.btnlogout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(TimeTableView.this,LoginActivity.class));
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logoutmenu:{
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(TimeTableView.this,LoginActivity.class));
            }
            case R.id.profileMenu:{
                startActivity(new Intent(TimeTableView.this,ProfileActivity.class));
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
