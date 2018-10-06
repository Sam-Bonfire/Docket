package com.houseofivy.docket;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class RegistrationActivity extends AppCompatActivity {


     private EditText userName,userEmail,userPassword,userRole;
    private Button regButton;
    private TextView userLogin;
    private FirebaseAuth firebaseAuth;
    String email,password,name,role;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setupUIView();
        firebaseAuth = FirebaseAuth.getInstance();


        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    //Upload data to database

                    String user_mail=userEmail.getText().toString().trim();
                    String user_password=userPassword.getText().toString().trim();
                    String user_role=userRole.getText().toString().trim();


                    firebaseAuth.createUserWithEmailAndPassword(user_mail, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {


                            if(task.isSuccessful()){
                                userProfile user=new userProfile(name,email,role);
                                FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            Toast.makeText(RegistrationActivity.this,"Done",Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                                
                            } else {
                                Toast.makeText(RegistrationActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
            }
        });
    }

 
    private void setupUIView(){
        userName=(EditText)findViewById(R.id.username);
        userEmail=(EditText)findViewById(R.id.useremail);
        userPassword=(EditText)findViewById(R.id.userpassword);
        regButton=(Button)findViewById(R.id.btnregister);
        userLogin=(TextView)findViewById(R.id.userlogin);
        userRole=(EditText)findViewById(R.id.etrole);

    }

    private Boolean validate(){
        Boolean result=false;
        name=userName.getText().toString();
        email=userEmail.getText().toString();
        password=userPassword.getText().toString();
        role=userRole.getText().toString();

        if(name.isEmpty() && password.isEmpty() && email.isEmpty() && role.isEmpty() ) {
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }
        return result;
    }

    private void sendEmailVerification() {
        FirebaseUser firebaseUser = firebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser != null) {
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        sendUserdata();
                        Toast.makeText(RegistrationActivity.this, "Registration Successfull,Verification mail sent!", Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                    } else {
                        Toast.makeText(RegistrationActivity.this, "Verification Mail not sent!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }


    private void sendUserdata(){
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference myref=firebaseDatabase.getReference(firebaseAuth.getUid());
        userProfile UserProfile=new userProfile(name,email,role);
        myref.setValue(UserProfile);
    }
}

