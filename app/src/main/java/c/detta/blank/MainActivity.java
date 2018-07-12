package c.detta.blank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;



public class MainActivity extends AppCompatActivity{


    Button breeder;
    Button bayer;




    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        breeder = (Button) findViewById(R.id.breeder_buttom);
        bayer = (Button) findViewById(R.id.bayer_buttom);


        breeder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Breeder.class);
                startActivity(intent);
            }
        });
        bayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Bayer.class);
                startActivity(intent);
            }
        });


    }



}
