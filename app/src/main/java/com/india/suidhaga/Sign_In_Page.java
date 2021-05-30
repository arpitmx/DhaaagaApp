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


public class Sign_In_Page extends AppCompatActivity {


    EditText email,password;
    Button signinButton;
    TextView LinkLogin;
    FirebaseAuth m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_page);

  m = FirebaseAuth.getInstance();
  email = (EditText)findViewById(R.id.email);
  password= (EditText)findViewById(R.id.password);
signinButton = (Button)findViewById(R.id.SignInButton);
        LinkLogin = findViewById(R.id.LinkLogin);

                signinButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
   String emailID = email.getText().toString();
   String pass = password.getText().toString();

   if (emailID.isEmpty()){
       email.setError("Please Enter the Email ID");
   }
   else if(pass.isEmpty()){
       password.setError("Please Enter your Respective Password");
   }
   else if(emailID.isEmpty() && pass.isEmpty()){

       email.setError("Please Enter the Email ID");
       password.setError("Please Enter your Respective Password");
   }
   else if (!emailID.isEmpty() && !pass.isEmpty()){

       m.createUserWithEmailAndPassword(emailID,pass).addOnCompleteListener(Sign_In_Page.this, new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {
               if(!task.isSuccessful()){

                   Toast.makeText(Sign_In_Page.this,"Sign Up UnSuccessfull!.Please Try Again",Toast.LENGTH_SHORT).show();
               }
               else
               {
                   Toast.makeText(Sign_In_Page.this,"Sign Up Successfull!",Toast.LENGTH_SHORT).show();
                     startActivity(new Intent(Sign_In_Page.this, HomeActivity.class));
               }
           }
       });

   }
   else{

       Toast.makeText(Sign_In_Page.this,"An Error Occured!",Toast.LENGTH_SHORT).show();

   }



    }


  });

                LinkLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(Sign_In_Page.this,Login_Page.class));
                    }
                });



}

}

