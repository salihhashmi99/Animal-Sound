package com.example.newpracticeproject;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {
    private List<AnimalModel> animals;
    private MediaPlayer mediaPlayer;

    public AnimalAdapter(List<AnimalModel> animals){
        this.animals = animals;
        this.mediaPlayer = new MediaPlayer();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_animal, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AnimalModel animal = animals.get(position);

        holder.imageViewAnimal.setImageResource(animal.getImageResourceId());
        holder.textViewAnimalName.setText(animal.getName());
        
        holder.playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Clicked", Toast.LENGTH_SHORT).show();
                playAnimalSound(animal.getSoundResourceId(), v.getContext());
            }
        });
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder {
        ImageView imageViewAnimal;
        TextView textViewAnimalName;
        Button playButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewAnimal = itemView.findViewById(R.id.imageViewAnimal);
            textViewAnimalName = itemView.findViewById(R.id.textViewAnimalName);
            playButton = itemView.findViewById(R.id.buttonPlay);
        }
    }

    private void playAnimalSound(int soundResourceId, Context context) {
        try {
            if (context != null) {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setDataSource(context, Uri.parse("android.resource://" + context.getPackageName() + "/" + soundResourceId));
                mediaPlayer.prepare();
                mediaPlayer.start();
            } else {
                Log.e("AnimalAdapter", "Context is null in playAnimalSound");
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = new MediaPlayer();
//                mediaPlayer = null;
            }
        } catch (IOException e) {
            Log.e("AnimalAdapter", "Error playing animal sound", e);
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

}
