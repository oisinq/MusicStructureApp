package io.oisin.musicstructureapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MusicActivity extends Activity {

    Episode episode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        // This extracts the episode data from the intent
        episode = (Episode) getIntent().getSerializableExtra("Episode");

        // We can now change the artwork and TextViews to match the data in "episode"
        changeAlbumArt();
        changeText();

        Button libraryButton = (Button) findViewById(R.id.library_button);
        // Whenever the library button is clicked, we want to return to the library screen
        libraryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MusicActivity.this, MainActivity.class);
                startActivity(numbersIntent);
            }
        });
    }

    /**
     * This changes the album art to that specified in "episode"
     */
    private void changeAlbumArt() {
        ImageView albumArt = (ImageView) findViewById(R.id.albumart);
        albumArt.setImageResource(episode.getImageResourceId());
    }

    /**
     * This changes the text to that specified in "episode"
     */
    private void changeText() {
        TextView episodeDetails = (TextView) findViewById(R.id.episode_details);
        episodeDetails.setText("Season " + episode.getSeasonNumber() + ": Episode " + episode.getEpisodeNumber());

        TextView albumDetails = (TextView) findViewById(R.id.album_details);
        albumDetails.setText(episode.getAlbumName() + " - " + episode.getmArtistName());
    }
}
