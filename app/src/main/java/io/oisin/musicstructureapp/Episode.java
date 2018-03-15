package io.oisin.musicstructureapp;

import java.io.Serializable;

// We make this custom class "Serializable" to make it easier to transfer it between activities in an intent
public class Episode implements Serializable {
    private int mSeasonNumber;
    private int mEpisodeNumber;
    private String mAlbumName;
    private String mArtistName;
    private int mImageResourceId;

    public Episode(int vSeason, int vEpisode, String vName, String vArtist, int imageResourceId) {
        mSeasonNumber = vSeason;
        mEpisodeNumber = vEpisode;
        mAlbumName = vName;
        mArtistName = vArtist;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the name of the current season
     */
    public int getSeasonNumber() {
        return mSeasonNumber;
    }

    /**
     * Get the name of the current episode
     */
    public int getEpisodeNumber() {
        return mEpisodeNumber;
    }

    /**
     * Get the name of the album featured in the episode
     */
    public String getAlbumName() {
        return mAlbumName;
    }

    /**
     * Get the name of the artist featured in the episode
     */
    public String getmArtistName() {
        return mArtistName;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }


}
