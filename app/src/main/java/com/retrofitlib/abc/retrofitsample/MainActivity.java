package com.retrofitlib.abc.retrofitsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.retrofitlib.abc.retrofitsample.pojo.Restaurant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listViewRestaurant);

        getRestaurants();


    }

    private void getRestaurants() {
        //final ProgressDialog loading = ProgressDialog.show(this, "Fetching Data", "Please wait...", false, false);

        // Create a very simple REST adapter which points the GitHub API endpoint.
        RestaurantAPI client = ServiceGenerator.createService(RestaurantAPI.class);


        // Fetch and print a list of the contributors to this library.
        Call<List<Restaurant>> call =
                client.getTask(19.145999, 72.990953);
        call.enqueue(new Callback<List<Restaurant>>() {
            @Override
            public void onResponse(Call<List<Restaurant>> call, Response<List<Restaurant>> response) {

                if (response.isSuccessful()) {
                    okhttp3.Response raw = response.raw();
                    Log.d("Error", response.toString() + "\n" + raw.toString());

                } else {

                }
            }

            @Override
            public void onFailure(Call<List<Restaurant>> call, Throwable t) {
                Log.d("Error", t.getMessage());

            }
        });

    }


}
