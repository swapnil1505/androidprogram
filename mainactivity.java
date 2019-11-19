package com.example.layoutusesinandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

public class MainActivity extends AppCompatActivity {
      EditText editText,editText1,a,b,c;
      FirebaseDatabase database;
    DatabaseReference myreff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendMessage(View view)
    {
        editText = findViewById(R.id.Entercity1);
        editText1 = findViewById(R.id.Entercity2);
        a = findViewById(R.id.editText8);
        b= findViewById(R.id.editText14);
        c = findViewById(R.id.editText10);
          String n = editText1.getText().toString();
      String m =  editText.getText().toString();
      if(m.equals("City1") &&(n.equals("City2"))) {
           myreff   =  database.getInstance().getReference().child("city1 to city2");
           myreff.addValueEventListener(new ValueEventListener() {
               @Override
               public void onDataChange(@NotNull  DataSnapshot dataSnapshot) {
                   String m = dataSnapshot.child("Bus1").getValue().toString();
                   String n = dataSnapshot.child("Bus2").getValue().toString();
                   String l = dataSnapshot.child("Bus3").getValue().toString();
                   a.setText(m);
                   b.setText(n);
                   c.setText(l);
               }

               @Override
               public void onCancelled(@NotNull  DatabaseError databaseError) {

               }
           });
          Intent intent = new Intent(this, MessageActivity.class);
          startActivity(intent);
      }
    }
}
