package com.example.recycleviewdemo;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {
    Button add;
    EditText additemedit;
    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        additemedit = findViewById(R.id.addbox);
        add = findViewById(R.id.additem);

        // data to populate the RecyclerView with
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");
        animalNames.add("tiger");
        animalNames.add("Lion");
        animalNames.add("Aardvark");
        animalNames.add("Aardwolf");
        animalNames.add("Abyssinian");
        animalNames.add("African Bullfrog");
        animalNames.add("African Bush Elephant");
        animalNames.add("African Penguin");
        animalNames.add("African Wild Dog");
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        // recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MyRecyclerViewAdapter(this, animalNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        add.setOnClickListener(view -> {
            String item = additemedit.getText().toString();
            if (!item.isEmpty()){
                animalNames.add(animalNames.size(),item);

                adapter.notifyItemInserted(animalNames.size());
                Toast.makeText(MainActivity.this, "Item Added", Toast.LENGTH_LONG).show();
                additemedit.setText("");
            }
            else{
                Toast.makeText(MainActivity.this,"Enter Valid Item!",Toast.LENGTH_SHORT).show();
            }

        });

//        Button delete = findViewById(R.id.delete);
//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

//        remove.setOnClickListener(view -> {
//          String  removeitem = additemedit.getText().toString();
//            if (!removeitem.isEmpty()){
//                animalNames.remove(removeitem);
//                adapter.notifyItemRemoved(animalNames.size());
//                Toast.makeText(MainActivity.this,"item Removed",Toast.LENGTH_SHORT).show();
//                additemedit.setText("");
//            }
//            else {
//                Toast.makeText(MainActivity.this,"Enter Valid Item!",Toast.LENGTH_SHORT).show();
//            }
//
//        });

    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }

}