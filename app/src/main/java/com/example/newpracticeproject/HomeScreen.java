package com.example.newpracticeproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomeScreen extends AppCompatActivity {
    TextView desc;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        
        desc=findViewById(R.id.txtstart);
        
        recyclerView=findViewById(R.id.animalrecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<AnimalModel> animals = createAnimalList();
        AnimalAdapter animalAdapter = new AnimalAdapter(animals);
        recyclerView.setAdapter(animalAdapter);

    }

    private List<AnimalModel> createAnimalList() {
        List<AnimalModel> animals = new ArrayList<>();

        AnimalModel cat = new AnimalModel(R.drawable.cat, "Cat", R.raw.catsound);
        animals.add(cat);

        AnimalModel dog = new AnimalModel(R.drawable.dog, "Dog", R.raw.dogsound);
        animals.add(dog);

        AnimalModel goat = new AnimalModel(R.drawable.goat, "Goat", R.raw.goatsound);
        animals.add(goat);

        AnimalModel cow = new AnimalModel(R.drawable.cow,"Cow",R.raw.cowsound);
        animals.add(cow);

        AnimalModel rabbit = new AnimalModel(R.drawable.rabbit, "Rabbit",R.raw.catsound);
        animals.add(rabbit);

        return animals;
    }
}