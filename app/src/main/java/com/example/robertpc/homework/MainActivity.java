package com.example.robertpc.homework;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    Button btnRegister;
    EditText email;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        email = (EditText) findViewById(R.id.txtLoginEmail);
        pass = (EditText) findViewById(R.id.txtLoginPass);

        // Login Button
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {

            User user = new User();
            String uEmail = user.getEmail();
            String uPass = user.getPassword();

            AlertDialog.Builder alertMessage = new AlertDialog.Builder(MainActivity.this, R.style.MyAlertDialogStyle);

            @Override
            public void onClick(View v) {

                if(uEmail == null || uPass == null){

                    alertMessage.setIcon(R.drawable.ic_warning_24dp)
                            .setTitle("Oop")
                            .setMessage("You don't have account")
                            .setNegativeButton("Close", null)
                            .setCancelable(false)
                            .create();
                    alertMessage.show();

                }else if(email.getText().toString().matches("")) {

                    alertMessage.setIcon(R.drawable.ic_warning_24dp)
                            .setTitle("Oop")
                            .setMessage("Please input your Email")
                            .setNegativeButton("Close", null)
                            .setCancelable(false)
                            .create();
                    alertMessage.show();

                }else if(pass.getText().toString().matches("")){

                    alertMessage.setTitle("Oop !")
                            .setMessage("Please input your Password")
                            .setNegativeButton("Close", null)
                            .setCancelable(false)
                            .create();
                    alertMessage.show();

                }else if(!uEmail.equals(email.getText().toString())) {

                    alertMessage.setTitle("Oop !")
                            .setMessage("Email is incorrect")
                            .setNegativeButton("Close", null)
                            .setCancelable(false)
                            .create();
                    alertMessage.show();

                }else if(!uPass.equals(pass.getText().toString())) {

                    alertMessage.setTitle("Oop !")
                            .setMessage("Password is incorrect \n     Please Try Again")
                            .setNegativeButton("Close", null)
                            .setCancelable(false)
                            .create();
                    alertMessage.show();

                }else{
                    finish();
                    Intent in = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(in);

                }

            }
        });

        // Register Button
        btnRegister = (Button) findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(in);
                overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);
            }
        });
    }
}
