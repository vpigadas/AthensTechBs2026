package gr.athenstech.course.list;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.List;

import gr.athenstech.course.databinding.ActivityRecyclerBinding;
import gr.athenstech.course.network.Pet;

public class RecyclerActivity extends AppCompatActivity {

    private ActivityRecyclerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRecyclerBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
    }

    @Override
    protected void onResume() {
        super.onResume();
        makeNetworkRequest();
    }

    private void makeNetworkRequest() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://petstore3.swagger.io/api/v3/pet/findByStatus?status=available";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Pet[] jsonElement = gson.fromJson(response, Pet[].class);
                Log.d("NetworkActivity", "Parsed JSON: " + jsonElement.toString());

                CustomAdapter adapter = new CustomAdapter(List.of(jsonElement));
                binding.recyclerView.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}