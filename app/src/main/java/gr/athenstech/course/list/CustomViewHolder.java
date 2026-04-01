package gr.athenstech.course.list;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import gr.athenstech.course.databinding.HolderItemBinding;
import gr.athenstech.course.network.Pet;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    private HolderItemBinding binding;

    public CustomViewHolder(@NonNull HolderItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Pet pet) {
        binding.holderTxt.setText(pet.getName());
        // Bind data to views here
    }
}
