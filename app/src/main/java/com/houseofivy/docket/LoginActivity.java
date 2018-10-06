package com.houseofivy.docket;

import android.app.ProgressDialog;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private EditText Email,Role;
    private EditText Password;
    private TextView Info;
    private Button login;
    private int counter = 5;
    //private TextView tvregister;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    //private TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth=FirebaseAuth.getInstance();

        Email = (EditText) findViewById(R.id.etname);
        Password = (EditText) findViewById(R.id.pass);
        Info = (TextView) findViewById(R.id.tvinfo);
        login = (Button) findViewById(R.id.btn);
        Role=(EditText)findViewById(R.id.logRole);
       // tvregister=(TextView)findViewById(R.id.tvRegister);
      //  forgotPassword=(TextView)findViewById(R.id.etForgotPassword);

        Info.setText("Remaining attempts: 5");

        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        FirebaseUser user=firebaseAuth.getCurrentUser();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference ref = database.getReference("server/saving-data/fireblog/posts");

            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    userProfile value=dataSnapshot.getValue(userProfile.class);
                    System.out.println(value);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


        if(user!=null){
           finish();
         startActivity(new Intent(LoginActivity.this,TimeTableView.class));
        }



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Email.getText().toString(), Password.getText().toString() ,Role.getText().toString());

            }
        });




    }

    public void clicka(View v){
        startActivity(new Intent(LoginActivity.this,ForgotPassword.class));

    }




        public void click (View v){

        startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
    }


    private void validate(String usermail, String userpassword , String userrole) {

        progressDialog.setMessage("Please wait for some time.");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(usermail,userpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();

                    //Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                    checkEmailVerification();
                }else{
                    Toast.makeText(LoginActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                    counter--;
                    progressDialog.dismiss();
                    Info.setText("No of attempts remaining:-"+counter);
                    if(counter==0){
                        login.setEnabled(false);
                    }
                }
            }
        });

    }

    private void checkEmailVerification(){
        FirebaseUser firebaseUser=firebaseAuth.getInstance().getCurrentUser();
        Boolean emailFlag = firebaseUser.isEmailVerified();

        if(emailFlag){

            startActivity(new Intent(LoginActivity.this,TimeTableView.class));

        }
        else{
            Toast.makeText(this,"Verify your email",Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }
    }
}
