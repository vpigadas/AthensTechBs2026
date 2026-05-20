package gr.athenstech.course.fragments;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import gr.athenstech.course.R;

public class MyAndroidViewModel extends AndroidViewModel {

    private final MutableLiveData<Integer> _counterLiveData = new MutableLiveData<>(0);
    public LiveData<Integer> counterLiveData = _counterLiveData;

    public MyAndroidViewModel(@NonNull Application application) {
        super(application);
    }

    public void increaseNumber(){
        getApplication().getString(R.string.app_name);


        _counterLiveData.postValue(_counterLiveData.getValue() + 1);
    }

    public void decreaseNumber(){
        _counterLiveData.postValue(_counterLiveData.getValue() - 1);
    }
}
