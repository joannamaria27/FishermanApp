package com.example.fishermanapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditFishActivity extends AppCompatActivity {

    public static final String EXTRA_EDIT_FISH_NAZWA = "EDIT_FISH_TITLE";
    public static final String EXTRA_EDIT_FISH_DATA = "EDIT_FISH_DATA";
    public static final String EXTRA_EDIT_FISH_WIELKOSC = "EDIT_FISH_WIELKOSC";
    public static final String EXTRA_EDIT_FISH_WAGA = "EDIT_FISH_WAGA";
    public static final String EXTRA_EDIT_FISH_JEZIORO = "EDIT_FISH_JEZIORO";

    private EditText editNazwaEditText;
    private EditText editDataEditText;
    private EditText editWielkoscEditText;
    private EditText editWagaEditText;
    private EditText editJezioroEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_fish);

        editNazwaEditText = findViewById(R.id.edit_fish_nazwa);
        editDataEditText = findViewById(R.id.edit_fish_data);
        editWielkoscEditText = findViewById(R.id.edit_fish_wielkosc);
        editWagaEditText = findViewById(R.id.edit_fish_waga);
        editJezioroEditText = findViewById(R.id.edit_fish_jezioro);

        final Button button = findViewById(R.id.button_save);

        String nazwa = getIntent().getStringExtra("FISH_NAZWA");
        String data = getIntent().getStringExtra("FISH_DATA");
        String wielkosc = getIntent().getStringExtra("FISH_WIELKOSC");
        String waga = getIntent().getStringExtra("FISH_WAGA");
        String jezioro = getIntent().getStringExtra("FISH_JEZIORO");

        if(nazwa != null && data != null && jezioro != null && wielkosc != null && waga != null) {
            editNazwaEditText.setText(nazwa);
            editDataEditText.setText(data);
            editWielkoscEditText.setText(wielkosc);
            editWagaEditText.setText(waga);
            editJezioroEditText.setText(jezioro);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent replyIntent = new Intent();
                    if (TextUtils.isEmpty(editNazwaEditText.getText()) || TextUtils.isEmpty(editDataEditText.getText()) || TextUtils.isEmpty(editJezioroEditText.getText()) || TextUtils.isEmpty(editWagaEditText.getText()) || TextUtils.isEmpty(editWielkoscEditText.getText())) {
                        setResult(RESULT_CANCELED, replyIntent);
                    } else {

                        String nazwa = editNazwaEditText.getText().toString();
                        replyIntent.putExtra(EXTRA_EDIT_FISH_NAZWA, nazwa);

                        String data = editDataEditText.getText().toString();
                        replyIntent.putExtra(EXTRA_EDIT_FISH_DATA, data);

                        String wielkosc = editWielkoscEditText.getText().toString();
                        replyIntent.putExtra(EXTRA_EDIT_FISH_WIELKOSC,wielkosc );

                        String waga = editWagaEditText.getText().toString();
                        replyIntent.putExtra(EXTRA_EDIT_FISH_WAGA, waga);

                        String jezioro = editJezioroEditText.getText().toString();
                        replyIntent.putExtra(EXTRA_EDIT_FISH_JEZIORO, jezioro);


                        setResult(RESULT_OK, replyIntent);
                    }
                    finish();
                }
            });
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(editNazwaEditText.getText()) || TextUtils.isEmpty(editDataEditText.getText()) || TextUtils.isEmpty(editWielkoscEditText.getText()) || TextUtils.isEmpty(editWagaEditText.getText()) || TextUtils.isEmpty(editJezioroEditText.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String nazwa = editNazwaEditText.getText().toString();
                    replyIntent.putExtra(EXTRA_EDIT_FISH_NAZWA, nazwa);

                    String data = editDataEditText.getText().toString();
                    replyIntent.putExtra(EXTRA_EDIT_FISH_DATA, data);

                    String wielkosc = editWielkoscEditText.getText().toString();
                    replyIntent.putExtra(EXTRA_EDIT_FISH_WIELKOSC,wielkosc );

                    String waga = editWagaEditText.getText().toString();
                    replyIntent.putExtra(EXTRA_EDIT_FISH_WAGA, waga);

                    String jezioro = editJezioroEditText.getText().toString();
                    replyIntent.putExtra(EXTRA_EDIT_FISH_JEZIORO, jezioro);


                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });

    }
}
