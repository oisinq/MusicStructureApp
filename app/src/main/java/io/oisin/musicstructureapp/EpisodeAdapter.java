/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.oisin.musicstructureapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * This adapter is used to store all of the different episodes and creates views for them dynamically
 */
public class EpisodeAdapter extends ArrayAdapter<Episode> {
    public EpisodeAdapter(Activity context, ArrayList<Episode> episodes) {
        super(context, 0, episodes);
    }

    /**
     * This method provides the view
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        // If the view doesn't exist already, we create it
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        // This is the current episode we want to make a view for
        Episode currentEpisode = getItem(position);

        // Here we extract all of the information from currentEpisode and transfer it to the TextViews and ImageViews
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title);
        titleTextView.setText(currentEpisode.getAlbumName());

        TextView subtitleTextView = (TextView) listItemView.findViewById(R.id.subtitle);
        subtitleTextView.setText(currentEpisode.getmArtistName());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        iconView.setImageResource(currentEpisode.getImageResourceId());

        return listItemView;
    }

}
