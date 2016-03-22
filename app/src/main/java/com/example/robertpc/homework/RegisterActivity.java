package com.example.robertpc.homework;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        bRegister = (Button) findViewById(R.id.btn_submit);
        tEmail = (EditText) findViewById(R.id.editTxtEmail);
        tPass = (EditText) findViewById(R.id.editTxtPass);
        tConfirm = (EditText) findViewById(R.id.editTxtConfim);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uEmail = tEmail.getText().toString();
                String uPass = tPass.getText().toString().trim();
                String uCon = tConfirm.getText().toString().trim();

                AlertDialog.Builder alertMessage = new AlertDialog.Builder(RegisterActivity.this, R.style.MyAlertDialogStyle);

                if(uEmail.matches("") || uPass.matches("") || uCon.matches("")){


                    alertMessage.setTitle("Oop !")
                            .setMessage("Please fill all field")
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
                    Toast.makeText(getApplicationContext(), "Saved!", Toast.LENGTH_SHORT).show();

                }


            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
    }

}
