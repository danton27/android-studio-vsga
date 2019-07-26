package com.pens.vsgamobileprog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class LoginActivity extends AppCompatActivity {
    Animation fromtop, frombottom;
    Button btnlogin;
    EditText edUsername, edPassword;
    TextView tvSignUp;
    ImageView ivvsga;
    public static String FILENAME = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        fromtop = AnimationUtils.loadAnimation(this, R.anim.fromtop);

        btnlogin = (Button) findViewById(R.id.btnlogin);
        edUsername = (EditText) findViewById(R.id.edUsername);
        edPassword = (EditText) findViewById(R.id.edPassword);
        tvSignUp = (TextView) findViewById(R.id.txSignUp);
        ivvsga = (ImageView) findViewById(R.id.ivvsga);

        btnlogin.startAnimation(frombottom);
        ivvsga.startAnimation(fromtop);
        edUsername.startAnimation(fromtop);
        edPassword.startAnimation(fromtop);
        tvSignUp.startAnimation(fromtop);

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent movetoSignUp = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(movetoSignUp);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(edUsername.getText().toString().trim())
                && TextUtils.isEmpty(edPassword.getText().toString().trim())) {
                    edUsername.setError("Please fill username!");
                    edPassword.setError("Please fill password!");
                } else if (TextUtils.isEmpty(edUsername.getText().toString().trim())) {
                    edUsername.setError("Please fill username!");
                } else if (TextUtils.isEmpty(edPassword.getText().toString().trim())) {
                    edPassword.setError("Please fill password!");
                } else {
                    login();
                }
            }
        });

    }

    public void simplanFileLogin() {
        String isiFile = edUsername.getText().toString()+";"+ edPassword.getText().toString();

        File file = new File(getFilesDir(), FILENAME);

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

        Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
        onBackPressed();
    }

    public void login() {
        File sdcard = getFilesDir();
        File file = new File(sdcard, edUsername.getText().toString());
        if (file.exists()) {
            StringBuilder text = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                while(line != null) {
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
            } catch (IOException e) {
                System.out.println("Error " + e.getMessage());
            }
            String data = text.toString();
            String[] dataUser = data.split(";");

            if (dataUser[1].equals(edPassword.getText().toString())) {
                simplanFileLogin();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Password is not match!", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "User not found!", Toast.LENGTH_SHORT).show();
        }
    }
}
