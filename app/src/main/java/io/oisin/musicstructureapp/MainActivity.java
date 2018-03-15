package io.oisin.musicstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // This is the main view for the MainActivity activity
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // First, we want to create all of the episodes and addthem to the arraylist and create the views
        createEpisodes();

        // This code runs when an item in the grid is clicked
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // We can use this to find out exactly which episode is clicked on, and pass that information
            // to the MusicActivity class (so it can be updated dynamically)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent episodeIntent = new Intent(MainActivity.this, MusicActivity.class);
                Episode episode = (Episode) gridView.getItemAtPosition(position);
                episodeIntent.putExtra("Episode", episode);
                startActivity(episodeIntent);
            }
        });
    }

    private void createEpisodes() {
        // Create an ArrayList of Episode objects, containing all the associated information
        ArrayList<Episode> episodes = new ArrayList<>();
        episodes.add(new Episode(1, 1, getString(R.string.album1), getString(R.string.artist1), R.drawable.s1ep1));
        episodes.add(new Episode(1, 2, getString(R.string.album2), getString(R.string.artist2), R.drawable.s1ep2));
        episodes.add(new Episode(1, 3, getString(R.string.album3), getString(R.string.artist3), R.drawable.s1ep3));
        episodes.add(new Episode(1, 4, getString(R.string.album4), getString(R.string.artist4), R.drawable.s1ep4));
        episodes.add(new Episode(1, 5, getString(R.string.album5), getString(R.string.artist5), R.drawable.s1ep5));
        episodes.add(new Episode(1, 6, getString(R.string.album6), getString(R.string.artist6), R.drawable.s1ep6));
        episodes.add(new Episode(1, 7, getString(R.string.album7), getString(R.string.artist7), R.drawable.s1ep7));
        episodes.add(new Episode(2, 1, getString(R.string.album8), getString(R.string.artist8), R.drawable.s2ep1));
        episodes.add(new Episode(2, 2, getString(R.string.album9), getString(R.string.artist9), R.drawable.s2ep2));
        episodes.add(new Episode(2, 3, getString(R.string.album10), getString(R.string.artist10), R.drawable.s2ep3));
        episodes.add(new Episode(2, 4, getString(R.string.album11), getString(R.string.artist11), R.drawable.s2ep4));
        episodes.add(new Episode(2, 5, getString(R.string.album12), getString(R.string.artist12), R.drawable.s2ep5));


        EpisodeAdapter episodeAdapter = new EpisodeAdapter(this, episodes);

        gridView = (GridView) findViewById(R.id.listview_flavor);
        gridView.setAdapter(episodeAdapter);
    }
}
