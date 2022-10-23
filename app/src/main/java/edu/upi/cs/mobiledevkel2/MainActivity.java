package edu.upi.cs.mobiledevkel2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import edu.upi.cs.mobiledevkel2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.home:
                    replaceFragment(new HomeFamilyFragment());
                    break;
                case R.id.homeLansia:
                    replaceFragment(new LansiaFamilyFragment());
                    break;
                case R.id.lansia:
                    replaceFragment(new LansiaFamilyFragment());
                    break;
                case R.id.family:
                    replaceFragment(new KeluargaFamilyFragment());
                    break;
                case R.id.guide:
                    replaceFragment(new GuideFamilyFragment());
                    break;
                case R.id.profil:
                    replaceFragment(new ProfilFamilyFragment());
                    break;

            }
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // item selection
        switch (item.getItemId()) {
            case R.id.notification:
                replaceFragment(new NotifFamilyFragment());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentTransaction replace = fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }


}