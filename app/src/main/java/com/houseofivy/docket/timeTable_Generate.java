package com.houseofivy.docket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;

public class timeTable_Generate extends AppCompatActivity {
    private Button addTeacher,showTeacher;
    private int i = 0;
    private String[] teacher_list = new String[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table__generate);

        addTeacher = (Button) findViewById(R.id.btn_addTeacher);
        showTeacher = (Button) findViewById(R.id.btn_showTeacher);
        addTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 10){
                    Toast.makeText(timeTable_Generate.this, "Limit Exceeded", Toast.LENGTH_SHORT).show();
                    return;
                }
                LinearLayout teacher = findViewById(R.id.layout_teacher);
                EditText et_teacher = new EditText(timeTable_Generate.this);
                et_teacher.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
                et_teacher.setHint("Enter Teacher Name");
                et_teacher.setId(i);
                i++;
                teacher.addView(et_teacher);
            }
        });

        showTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int j = 0; j <= i ; j++){
                    EditText text = findViewById(j);
                    teacher_list[j] = text.getText().toString().trim();
                }
            }
        });
    }
}
