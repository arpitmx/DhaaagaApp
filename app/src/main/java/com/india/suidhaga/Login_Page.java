package com.india.suidhaga;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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


public class Login_Page extends AppCompatActivity {


    EditText email,password;
    Button signinButton;
    TextView LinkSignIn;
    FirebaseAuth m1;
FirebaseAuth.AuthStateListener mlisr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        m1 = FirebaseAuth.getInstance();
        email = (EditText)findViewById(R.id.email2);
        password= (EditText)findViewById(R.id.password2);
        signinButton = (Button)findViewById(R.id.LogInButton2);
        LinkSignIn = findViewById(R.id.LinkSignin2);

mlisr = new FirebaseAuth.AuthStateListener() {
    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        FirebaseUser mFirebaseUser = m1.getCurrentUser();

        if(mFirebaseUser != null){

            Toast.makeText(Login_Page.this,"Logged In",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Login_Page.this, HomeActivity.class));


        }
        else{
            Toast.makeText(Login_Page.this,"You are not Registered,Sign In",Toast.LENGTH_SHORT).show();


        }
    }
    };

        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailID2 = email.getText().toString();
                String pass2 = password.getText().toString();

                if (emailID2.isEmpty()){
                    email.setError("Please Enter the Email ID");
                }
                else if(pass2.isEmpty()){
                    password.setError("Please Enter your Respective Password");
                }
                else if(emailID2.isEmpty() && pass2.isEmpty()){

                    email.setError("Please Enter the Email ID");
                    password.setError("Please Enter your Respective Password");
                }
                else if (!emailID2.isEmpty() && !pass2.isEmpty()){
                    m1.signInWithEmailAndPassword(emailID2,pass2).addOnCompleteListener(Login_Page.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){

                            Toast.makeText(Login_Page.this,"You are not Registered,Sign In",Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                            startActivity(new Intent(Login_Page.this, HomeActivity.class));
                        }
                        }
                    });

                }
                else{

                    Toast.makeText(Login_Page.this,"An Error Occured!",Toast.LENGTH_SHORT).show();

                }



            }


        });

        LinkSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_Page.this,Sign_In_Page.class));
            }
        });



    }

}

