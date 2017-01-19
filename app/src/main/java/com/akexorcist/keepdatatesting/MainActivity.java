package com.akexorcist.keepdatatesting;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String KEY_NAME = "key_name";
    private String handleStateName;
    private String regularName;

    private Button btnSave;
    private Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = (Button) findViewById(R.id.btn_save);
        btnShow = (Button) findViewById(R.id.btn_show);
        btnSave.setOnClickListener(this);
        btnShow.setOnClickListener(this);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        handleStateName = savedInstanceState.getString(KEY_NAME);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_NAME, handleStateName);
    }

    @Override
    public void onClick(View v) {
        if (v == btnSave) {
            onSaveButtonClick();
        } else if (v == btnShow) {
            onShowButtonClick();
        }
    }

    private void onSaveButtonClick() {
        String dummyName = "Akexorcist";
        SingletonCurrentUser.getInstance().setName(dummyName);
        StaticCurrentUser.setName(dummyName);
        this.regularName = dummyName;
        this.handleStateName = dummyName;
        Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
    }

    private void onShowButtonClick() {
        String message = "Singleton Name : " + SingletonCurrentUser.getInstance().getName() + "\n" +
                "Static Name : " + StaticCurrentUser.getName() + "\n" +
                "Regular Name : " + regularName + "\n" +
                "Handle State Name : " + handleStateName;
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Result")
                .setMessage(message)
                .setCancelable(true)
                .create();
        alertDialog.show();
    }
}
