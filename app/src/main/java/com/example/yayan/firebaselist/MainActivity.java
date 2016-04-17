package com.example.yayan.firebaselist;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends ActionBarActivity {
    public Firebase myFirebaseRef;
public EditText editText;
    public EditText editText2;
FirebaseListAdapter<Personne> personneFirebaseListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        myFirebaseRef = new Firebase("https://luminous-heat-8924.firebaseio.com/");
       final ListView listView=(ListView) findViewById(R.id.listView);
        personneFirebaseListAdapter=new FirebaseListAdapter<Personne>(this,Personne.class,
                android.R.layout.two_line_list_item,myFirebaseRef) {
            @Override
            protected void populateView(View view, Personne personne, int i) {
                ((TextView)view.findViewById(android.R.id.text1)).setText(personne.getName().toString());
                ((TextView)view.findViewById(android.R.id.text2)).setText(personne.getLastname().toString());
            }
        };


        listView.setAdapter(personneFirebaseListAdapter);


           editText =(EditText) findViewById(R.id.editText);
           editText2 =(EditText) findViewById(R.id.editText2);



    }

    public void push(View v){


        String name=editText.getText().toString();
        String lastname=editText2.getText().toString();

        Personne p = new Personne(name,lastname);

        myFirebaseRef.push().setValue(p);
        editText2.setText("");
        editText.setText("");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        personneFirebaseListAdapter.cleanup();
    }
}
