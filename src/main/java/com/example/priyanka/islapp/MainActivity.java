package com.example.priyanka.islapp;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.CardView;

import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    private CardView mCardView_alphabets;
    private CardView mCardView_foods;
    private CardView mCardView_medical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dl = (DrawerLayout)findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.home:
                        Intent i = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(i);
                        break;

                    case R.id.share:
//                        Toast.makeText(MainActivity.this, "My Cart",Toast.LENGTH_SHORT).show();
                        try {
                            Intent i_share = new Intent(Intent.ACTION_SEND);
                            i_share.setType("text/plain");
                            i_share.putExtra(Intent.EXTRA_SUBJECT, "DeafHub");
                            String sAux = "\nLet me recommend you this application\n\n";
                            sAux = sAux + "https://play.google.com/store/apps/details?id=the.package.id \n\n";
                            i_share.putExtra(Intent.EXTRA_TEXT, sAux);
                            startActivity(Intent.createChooser(i_share, "choose one"));
                        } catch(Exception e) {
                            //e.toString();
                        }
                        break;

                    case R.id.donateus:
//                        Toast.makeText(MainActivity.this, "My Cart",Toast.LENGTH_SHORT).show();
                        Intent i2 = new Intent(MainActivity.this, DonateUs.class);
                        startActivity(i2);
                        break;
                    case R.id.aboutus:
//                        Toast.makeText(MainActivity.this, "My Cart",Toast.LENGTH_SHORT).show();
                        Intent i3 = new Intent(MainActivity.this, AboutUs.class);
                        startActivity(i3);
                        break;
                    case R.id.fb:
//                        Toast.makeText(MainActivity.this, "My Cart",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("http://www.facebook.com/deafthub"));
                        startActivity(intent);
                        break;
                    case R.id.ig:
                        Intent intentig = new Intent();
                        intentig.setAction(Intent.ACTION_VIEW);
                        intentig.addCategory(Intent.CATEGORY_BROWSABLE);
                        intentig.setData(Uri.parse("http://www.instagram.com/deafthub"));
                        startActivity(intentig);
                        break;

                    default:
                        return true;
                }


                return true;

            }


        });



        mCardView_alphabets = (CardView)findViewById(R.id.cardView1);
        mCardView_alphabets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Alphabets.class);
                startActivity(intent);
            }
        });

        mCardView_foods=(CardView)findViewById(R.id.cardView2);
        mCardView_foods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Foods.class);
                startActivity(intent);
            }
        });

        mCardView_medical=(CardView)findViewById(R.id.cardView3);
        mCardView_medical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Medical.class);
                startActivity(intent);
            }
        });


    } //END OF ONCREATE

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}//END OF MAIN





