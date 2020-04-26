package com.example.proto1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class BuyMovieList extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_movie_list);

        firebaseAuth = FirebaseAuth.getInstance();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(BuyMovieList.this, MainActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.logoutMenu : {
                Logout();
                return true;
            }
            case R.id.profileMenu : {
                startActivity(new Intent(BuyMovieList.this, ProfileActivity.class));
                return true;
            }
            case android.R.id.home : {
                onBackPressed();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
