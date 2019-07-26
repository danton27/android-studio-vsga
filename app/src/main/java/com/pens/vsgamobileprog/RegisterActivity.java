package com.pens.vsgamobileprog;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class RegisterActivity extends AppCompatActivity {
    Animation frombottom, fromtop;
    Button btnSign;
    EditText edUsername, edPassword, edEmail, edName, edAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        fromtop = AnimationUtils.loadAnimation(this, R.anim.fromtop);
        btnSign = (Button) findViewById(R.id.btnsign);

        edUsername = (EditText) findViewById(R.id.edUsername);
        edPassword = (EditText) findViewById(R.id.edPassword);
        edEmail = (EditText) findViewById(R.id.edEmail);
        edName = (EditText) findViewById(R.id.edName);
        edAddress = (EditText) findViewById(R.id.edAddress);

        btnSign.startAnimation(frombottom);
        edUsername.startAnimation(fromtop);
        edPassword.startAnimation(fromtop);
        edEmail.startAnimation(fromtop);
        edName.startAnimation(fromtop);
        edAddress.startAnimation(fromtop);

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isValidation();
            }
        });
    }

    public void isValidation() {
        if (
                TextUtils.isEmpty(edUsername.getText().toString().trim()) &&
                TextUtils.isEmpty(edEmail.getText().toString().trim()) &&
                TextUtils.isEmpty(edPassword.getText().toString().trim()) &&
                TextUtils.isEmpty(edName.getText().toString().trim()) &&
                TextUtils.isEmpty(edAddress.getText().toString().trim()) ) {
            edUsername.setError("Username is empty");
            edEmail.setError("Email is empty");
            edPassword.setError("Password is empty");
            edName.setError("Name is empty");
            edAddress.setError("Address is empty");
        } else if (TextUtils.isEmpty(edUsername.getText().toString().trim())) {
            edUsername.setError("Username is empty");
        } else if (TextUtils.isEmpty(edEmail.getText().toString().trim())) {
            edEmail.setError("Email is empty");
        } else if (TextUtils.isEmpty(edPassword.getText().toString().trim())) {
            edPassword.setError("Password is empty");
        } else if (TextUtils.isEmpty(edName.getText().toString().trim())) {
            edName.setError("Name is empty");
        } else if (TextUtils.isEmpty(edAddress.getText().toString().trim())) {
            edAddress.setError("Address is empty");
        } else if (!TextUtils.isEmpty(edEmail.getText().toString().trim())){
            String email = edEmail.getText().toString().trim();
            String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
            if (email.matches(emailPattern))
            {
                simpanFileData();
            }
            else
            {
                edEmail.setError("Email is not valid!");
            }
        }
    }

    public void simpanFileData() {
        String isiFile = edUsername.getText().toString() + ";" +
                edPassword.getText().toString() + ";" +
                edEmail.getText().toString() + ";" +
                edName.getText().toString() + ";" +
                edAddress.getText().toString();

        File file = new File(getFilesDir(), edUsername.getText().toString());
        FileOutputStream outputStream = null;

        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, false);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "Sign Up Successfully", Toast.LENGTH_SHORT).show();
        finish();
    }
}
