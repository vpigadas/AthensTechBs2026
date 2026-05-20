package gr.athenstech.course.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import gr.athenstech.course.databinding.ActivityMyFragmentBinding;

public class MyFragmentActivity extends AppCompatActivity {

    private ActivityMyFragmentBinding binding;
    public int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyFragmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        BlankFragment fragment = new BlankFragment();
//        fragment.newInstance();
//        BlankFragment.newInstance();

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

//        Fragment fragment = BlankFragment.newInstance("first fragment!!!");

//        transaction.add(binding.fragmentContainerView.getId(), BlankFragment.newInstance("first fragment"), "first");
        transaction.replace(binding.fragmentContainerView.getId(), BlankFragment.newInstance());
        transaction.replace(binding.fragmentContainerView2.getId(), BottomFragment.newInstance());
//        transaction.hide(fragment);
//        transaction.remove(fragment);

        transaction.commit();


        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);

    }
}