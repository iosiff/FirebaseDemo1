package com.network02.android.firebasedemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class AddUser extends AppCompatActivity {
    private EditText username;
    private EditText firstName;
    private EditText lastName;
    private EditText age;
    private EditText favoriteColors;
    private Button addUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        username = (EditText)findViewById(R.id.fieldUsername);
        firstName = (EditText)findViewById(R.id.fieldFirstName);
        lastName = (EditText)findViewById(R.id.fieldLastName);
        age = (EditText)findViewById(R.id.fieldAge);
        favoriteColors = (EditText)findViewById(R.id.fieldColors);

        addUser = (Button)findViewById(R.id.addUserButton);
        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewUser();
            }
        });
    }

    private void addNewUser() {
        String usernameValue = username.getText().toString().trim();
        String firstNameValue = firstName.getText().toString().trim();
        String lastNameValue = lastName.getText().toString().trim();
        int ageValue = Integer.parseInt(age.getText().toString().trim());

        String[] colors = favoriteColors.getText().toString().split("[ ]+");

        List<String> favoriteColors = new ArrayList<>();

        for(String c : colors) {
            favoriteColors.add(c);
        }

        User user = new User(usernameValue, firstNameValue, lastNameValue, ageValue, favoriteColors);


        // add it to the database
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference users = database.getReference().child("users");

        users.push().setValue(user);

        finish();
    }
}
