package com.houseofivy.docket;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class TimeTableView extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table_view);

        firebaseAuth = FirebaseAuth.getInstance();
        logout = (Button) findViewById(R.id.btnlogout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(TimeTableView.this, LoginActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logoutmenu: {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(TimeTableView.this, LoginActivity.class));
            }
            case R.id.profileMenu: {
                startActivity(new Intent(TimeTableView.this, ProfileActivity.class));
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClickListen(View view) {
        switch (view.getId()) {
            case R.id.tv_0_0:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_0_1:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_0_2:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_0_3:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_0_4:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_0_5:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_0_6:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_1_0:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_1_1:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_1_2:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_1_3:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_1_4:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_1_5:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_1_6:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_2_0:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_2_1:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_2_2:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_2_3:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_2_4:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_2_5:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_2_6:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_3_0:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_3_1:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_3_2:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_3_3:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_3_4:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_3_5:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_3_6:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_4_0:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_4_1:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_4_2:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_4_3:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_4_4:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_4_5:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_4_6:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_5_0:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_5_1:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_5_2:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_5_3:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_5_4:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_5_5:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;

            case R.id.tv_5_6:
                Toast.makeText(TimeTableView.this, "Button is clicked", Toast.LENGTH_SHORT).show();
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
