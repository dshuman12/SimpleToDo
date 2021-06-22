package com.example.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText editItem;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editItem = findViewById(R.id.editItem);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit Item");

        editItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create an intent to send the results to the Main Activity
                Intent intent = new Intent();
                //pass the data to Main Activity
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, editItem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));
                //set the result
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}