package com.network02.android.firebasedemo1;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class UserArrayAdapter extends ArrayAdapter<User> {
    public UserArrayAdapter(Context context, ArrayList<User> users) {
        super(context, 0, users);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        User user = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
        }

        TextView username = (TextView) convertView.findViewById(R.id.userUsername);
        TextView firstName = (TextView) convertView.findViewById(R.id.userFirstName);
        TextView lastName = (TextView) convertView.findViewById(R.id.userLastName);
        TextView age = (TextView) convertView.findViewById(R.id.userAge);
        TextView favoriteColors = (TextView) convertView.findViewById(R.id.userFavoriteColors);

        List<String> favColors = user.getFavoriteColors();

        if (favColors == null) {
            Log.d("adapter", "Colors list is null");
        }

        String acc = "";
        for(String color : favColors) {
            acc += color + " ";
        }

        username.setText(user.getUsername());
        firstName.setText(user.getFirstName());
        lastName.setText(user.getLastName());
        age.setText(user.getAge() + "");
        favoriteColors.setText(acc);

        return convertView;
    }
}
