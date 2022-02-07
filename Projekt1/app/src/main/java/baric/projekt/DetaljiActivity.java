package baric.projekt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class DetaljiActivity extends AppCompatActivity {


    //Promjena imena varijabli
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalji);

        Intent intent = getIntent();
        Uni uni = (Uni)intent.getSerializableExtra("University");

        TextView ime = findViewById(R.id.name);
        ime.setText(String.valueOf(uni.getName()));

        TextView country = findViewById(R.id.country);
        country.setText(String.valueOf(uni.getCountry()));

        Button nazad = findViewById(R.id.nazad);
        nazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}