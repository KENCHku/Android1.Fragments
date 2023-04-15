package kg.geeks.android1fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigateToFragment();
    }

    private void navigateToFragment() {
        getSupportFragmentManager()//manager of fragments
        .beginTransaction()//lets start fragments
        .add(R.id.fragment_container_view, new NameFragment())//intent but for fragments
        .commit();//here we finish the task
    }
}