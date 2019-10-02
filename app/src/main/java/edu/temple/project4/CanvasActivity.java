package edu.temple.project4;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        this.setTitle("Canvas Activity");
        View layout = findViewById(R.id.canvasLayout);

        Intent intent = getIntent();
        String value = intent.getStringExtra("key");

        layout.setBackgroundColor(Color.parseColor(value));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button = findViewById(R.id.buttonBack);

        //FloatingActionButton fab = findViewById(R.id.fab);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CanvasActivity.this, PaletteActivity.class);
                CanvasActivity.this.startActivity(intent);
                //Snackbar.make(view, "going back", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
            }
        });
    }

}
