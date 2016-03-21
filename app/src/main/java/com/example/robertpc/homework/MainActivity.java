package com.example.robertpc.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
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

            @Override
            public void onClick(View v) {

                if(uEmail == null || uPass == null){
                      Toast.makeText(getApplicationContext(), "You don't have account", Toast.LENGTH_SHORT).show();
                }else if(email.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Email is empty", Toast.LENGTH_SHORT).show();
                }else if(pass.getText().toString().matches("")){
                    Toast.makeText(getApplicationContext(), "Password is empty", Toast.LENGTH_SHORT).show();
                }else if(!uEmail.equals(email.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Email not Exist", Toast.LENGTH_SHORT).show();
                }else if(!uPass.equals(pass.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Password is incorrect", Toast.LENGTH_SHORT).show();
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
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
