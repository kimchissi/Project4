package edu.temple.project4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity {

    boolean firstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle("Palette Activity");
        Resources res = this.getResources();
        String[] colors = res.getStringArray(R.array.color_array);
        //String[] colors = {"select", "red", "yellow", "green", "blue", "purple", "teal", "aqua", "fuchsia", "black", "white"};



        final Spinner spinner = findViewById(R.id.colorSpinner);


        final ColorAdapter adapter = new ColorAdapter(PaletteActivity.this, colors);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (firstTime) {
                    firstTime = false;
                } else {

                    //adapter.getView(position, view, parent).setBackgroundColor(Color.WHITE);
                    Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);
                    intent.putExtra("key", (parent.getSelectedItem().toString()));
                    PaletteActivity.this.startActivity(intent);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
