package com.example.proto1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class BuyListActivity extends AppCompatActivity {

    private ListView listView;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_list);

        setUIViews();

        firebaseAuth = FirebaseAuth.getInstance();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setupListView();
    }

    private void setUIViews(){
        listView = (ListView)findViewById(R.id.lvBuy);
    }

    private void setupListView(){
        String[] title = getResources().getStringArray(R.array.BuyList);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, title);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch(position){
                    case 0 : {
                        startActivity(new Intent(BuyListActivity.this, BuyMusicConcertList.class));
                        break;
                    }
                    case 1 : {
                        startActivity(new Intent(BuyListActivity.this, BuySportList.class));
                        break;
                    }
                    case 2 : {
                        startActivity(new Intent(BuyListActivity.this, BuyLocalEventList.class));
                        break;
                    }
                    case 3 : {
                        startActivity(new Intent(BuyListActivity.this, BuyMovieList.class));
                        break;
                    }

                }
            }
        });

    }

    public class SimpleAdapter extends BaseAdapter{

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title;
        private String[] titleArray;

        public SimpleAdapter(Context context, String[] title){
            mContext = context;
            titleArray = title;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return titleArray.length;
        }

        @Override
        public Object getItem(int position) {
            return titleArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.buy_list_single_item, null);
            }

            title = (TextView)convertView.findViewById(R.id.tvTitle);

            title.setText(titleArray[position]);

            return convertView;
        }
    }

    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(this, MainActivity.class));
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
                startActivity(new Intent(this, ProfileActivity.class));
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
