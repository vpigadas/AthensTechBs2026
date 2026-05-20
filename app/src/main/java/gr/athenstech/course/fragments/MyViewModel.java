package gr.athenstech.course.fragments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private final MutableLiveData<Integer> _counterLiveData = new MutableLiveData<>(0);
    public LiveData<Integer> counterLiveData = _counterLiveData;

    public void increaseNumber(){
        _counterLiveData.postValue(_counterLiveData.getValue() + 1);
    }

    public void decreaseNumber(){
        _counterLiveData.postValue(_counterLiveData.getValue() - 1);
    }
}
