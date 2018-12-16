package com.mobilancer.pastaneapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mobilancer.pastaneapp.model.Cake;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CustomOnClickListener{

    RecyclerView recyclerView;
    CakeListAdapter cakeListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvCakes);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        cakeListAdapter = new CakeListAdapter(createDummyCakeList(), this);
        recyclerView.setAdapter(cakeListAdapter);
    }

    private List<Cake> createDummyCakeList(){
        List<Cake> cakeList = new ArrayList<>();
        for(int i = 0; i < 50; i++){
            Cake cake = new Cake();
            cake.setName("cake" + i);
            cake.setDesc("desc" + i);
            cake.setAmount(i * 100);
            cakeList.add(cake);
        }
        return cakeList;
    }

    @Override
    public void onItemClicked(Cake cake) {
        Toast.makeText(this,cake.getName(),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("name", cake.getName());
        intent.putExtra("desc", cake.getDesc());
        intent.putExtra("amount", cake.getAmount());
        intent.putExtra("id", cake.getId());
        startActivity(intent);
    }
}
