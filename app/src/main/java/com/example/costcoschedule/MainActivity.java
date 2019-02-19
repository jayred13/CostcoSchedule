package com.example.costcoschedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usernameInput, passwordInput;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView img= (ImageView) findViewById(R.id.image);
        img.setImageResource(R.drawable.costco_emblem);

        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
        checkBox = findViewById(R.id.checkBox);
    }

    public void submitClicked(View view){
        if(checkBox.isChecked()){
            new LoginSaver(
                    usernameInput.getText().toString(),
                    passwordInput.getText().toString()
            );
            showToast("Login Saved!");
        }
        showToast("Submited!");
        startActivity(new Intent(this, PersonalScheduleActivity.class));
    }

    private void showToast(String msg){
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}
