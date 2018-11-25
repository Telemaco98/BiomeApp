package com.example.ohara.potiguargenetics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick (View view) {
        switch (view.getId()) {
            case R.id.login_button:

                break;
            case R.id.register_button:
                    Intent intent = new Intent(this, RegisterActivity.class);
                    startActivity(intent);
                break;
        }
    }
}
