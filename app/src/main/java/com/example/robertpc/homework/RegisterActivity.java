package com.example.robertpc.homework;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    Button bRegister;
    EditText tEmail;
    EditText tPass;
    EditText tConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bRegister = (Button) findViewById(R.id.btn_submit);
        tEmail = (EditText) findViewById(R.id.editTxtEmail);
        tPass = (EditText) findViewById(R.id.editTxtPass);
        tConfirm = (EditText) findViewById(R.id.editTxtConfim);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uEmail = tEmail.getText().toString().trim();
                String uPass = tPass.getText().toString().trim();
                String uCon = tConfirm.getText().toString().trim();

                AlertDialog.Builder alertMessage = new AlertDialog.Builder(RegisterActivity.this, R.style.MyAlertDialogStyle);

                if(uEmail.matches("") || uPass.matches("") || uCon.matches("")) {


                    alertMessage.setIcon(R.drawable.ic_warning_24dp)
                            .setTitle("Oop")
                            .setMessage("Please fill all the fields")
                            .setNegativeButton("Close", null)
                            .setCancelable(false)
                            .create();
                    alertMessage.show();

                }else if(!uPass.equals(uCon)){

                    alertMessage.setTitle("Oop !")
                            .setMessage("Confirm not matches")
                            .setNegativeButton("Close", null)
                            .setCancelable(false)
                            .create();
                    alertMessage.show();

                }else {

                    User user = new User();
                    user.setEmail(uEmail);
                    user.setPassword(uPass);

                    Intent in = new Intent(RegisterActivity.this, MainActivity.class);
                    in.putExtra("email", user.getEmail());
                    in.putExtra("pass", user.getPassword());
                    startActivity(in);
                }

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                overridePendingTransition(R.anim.enter_right, R.anim.exit_left);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter_right, R.anim.exit_left);
    }

}
