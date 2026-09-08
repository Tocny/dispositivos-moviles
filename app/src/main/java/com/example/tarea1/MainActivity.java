package com.example.tarea1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String DRAWING =
            "░░░░░░░▄██▄░░░░░░▄▄░░\n" +
            "░░░░░░░▐███▀░░░░░▄███▌\n" +
            "░░▄▀░░▄█▀▀░░░░░░░░▀██░\n" +
            "░█░░░██░░░░░░░░░░░░░░░\n" +
            "█▌░░▐██░░▄██▌░░▄▄▄░░░▄\n" +
            "██░░▐██▄░▀█▀░░░▀██░░▐▌\n" +
            "██▄░▐███▄▄░░▄▄▄░▀▀░▄██\n" +
            "▐███▄██████▄░▀░▄█████▌\n" +
            "▐████████████▀▀██████░\n" +
            "░▐████▀██████░░█████░░\n" +
            "░░░▀▀▀░░█████▌░████▀░░\n" +
            "░░░░░░░░░▀▀███░▀▀▀░░░░";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView drawingView = findViewById(R.id.tvDrawing);
        drawingView.setText(DRAWING);
    }
}
