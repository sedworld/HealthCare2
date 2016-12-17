package com.example.victor.healthcare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.daimajia.swipe.SwipeLayout;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerViewAdapter mRecyclerViewAdapter;
    RecyclerView.LayoutManager mRecyclerViewLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerViewLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mRecyclerViewLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerViewAdapter = new RecyclerViewAdapter();
        mRecyclerViewAdapter.setDataSource(makeData());
        mRecyclerView.setAdapter(mRecyclerViewAdapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private String[] makeData(){
        String[] mDataSet = new String[12];
        for (int i = 0; i < 12; i++) {
            mDataSet[i] = "item" + i;
        }
        return mDataSet;
    }

    public static Intent newIntent(Context context){
        return new Intent(context, MainActivity.class);
    }


}
