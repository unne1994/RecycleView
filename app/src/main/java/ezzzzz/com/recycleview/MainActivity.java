package ezzzzz.com.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ArrayList<String> arrydata;
    private Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datas();
        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //adapter
        adapter adp = new adapter(MainActivity.this,arrydata);
        //adapter
        recyclerView.setAdapter(adp);
        
    }

    public void datas () {
        arrydata = new ArrayList<>();
        r = new Random();
        for (int i=0 ; i<100 ; i++){
            arrydata.add(String.valueOf(r.nextInt(100)+1));
            Log.d("dats", "datas: "+String.valueOf(r.nextInt(100)+1) );
        }
    }
}
