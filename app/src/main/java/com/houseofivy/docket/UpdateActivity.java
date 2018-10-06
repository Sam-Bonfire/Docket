package com.houseofivy.docket;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateActivity extends AppCompatActivity {

    private EditText updateName,updateEmail,updateRole;
    private Button updateButton;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        updateName=(EditText)findViewById(R.id.upname);
        updateEmail=(EditText)findViewById(R.id.upemail);
        updateButton=(Button)findViewById(R.id.upsave);
        updateRole=(EditText)findViewById(R.id.uprole);

        firebaseAuth= FirebaseAuth.getInstance();
        firebaseDatabase= FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference=firebaseDatabase.getReference(firebaseAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userProfile UserProfile=dataSnapshot.getValue(userProfile.class);
                updateName.setText(UserProfile.getUserEmail());
                updateEmail.setText(UserProfile.getUserName());
                updateRole.setText(UserProfile.getUserRole());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateActivity.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=updateName.getText().toString();
                String email=updateEmail.getText().toString();
                String role=updateRole.getText().toString();

                userProfile Userprofile=new userProfile(name,email,role);
                databaseReference.setValue(Userprofile);
                finish();
            }
        });
    }
}

