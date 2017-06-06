package com.network02.android.firebasedemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewUsers extends AppCompatActivity {

    private ArrayList<User> users;
    private UserArrayAdapter adapter;
    private ListView userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);

        users = new ArrayList<>();
        adapter = new UserArrayAdapter(this, users);

        userList = (ListView)findViewById(R.id.userList);
        userList.setAdapter(adapter);


        // populate the list with users from database
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference usersRef = database.getReference().child("users");
        usersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                adapter.clear();

                for(DataSnapshot child : dataSnapshot.getChildren()) {
                    User user = child.getValue(User.class);

                    List<String> cols = new ArrayList<String>();
                    for(DataSnapshot color : child.child("favoriteColors").getChildren()) {
                        cols.add(color.getValue().toString());
                    }

                    user.setFavoriteColors(cols);

                    users.add(user);
                }

                // sort the list
                Collections.sort(users, new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.getFirstName().compareTo(o2.getFirstName());
                    }
                });

                // update the list
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
