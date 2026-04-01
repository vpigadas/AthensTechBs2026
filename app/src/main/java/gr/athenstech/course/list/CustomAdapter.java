package gr.athenstech.course.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import gr.athenstech.course.R;
import gr.athenstech.course.databinding.HolderItemBinding;
import gr.athenstech.course.network.Pet;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private List<Pet> pets;

    public CustomAdapter(List<Pet> pets) {
        this.pets = pets;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_item, parent, false);
        HolderItemBinding binding = HolderItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CustomViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.bind(pets.get(position));

    }

    @Override
    public int getItemCount() {
        return pets.size();
    }
}
