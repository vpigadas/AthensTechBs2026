package gr.athenstech.course.network;

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
import com.google.gson.JsonElement;

import org.json.JSONArray;

import java.io.ObjectInputStream;

import gr.athenstech.course.databinding.ActivityNetworkBinding;

public class NetworkActivity extends AppCompatActivity {

    private ActivityNetworkBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNetworkBinding.inflate(getLayoutInflater());

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
                // Display the first 3000 characters of the response string.
                binding.networkMessage.setText("Response is: " + response.substring(0, 3000));

                Gson gson = new Gson();
                Pet[] jsonElement = gson.fromJson(response, Pet[].class);
                Log.d("NetworkActivity", "Parsed JSON: " + jsonElement.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                binding.networkMessage.setText("That didn't work!");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}