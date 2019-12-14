package com.example.rideme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView profile,name,address,rides,no_of_rides,free_rides,no_of_free_rides,credits,no_of_credits;
    Button past_trips,see_all;
    ImageView profile_image;

    private RequestQueue mQueue;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            profile_image = findViewById(R.id.profile_image);

            profile= findViewById(R.id.toolbar_title);
            name=findViewById(R.id.name);
            address=findViewById(R.id.address);
            rides=findViewById(R.id.ride);
            no_of_rides=findViewById(R.id.ride_no);
            free_rides=findViewById(R.id.free_ride);
            no_of_free_rides=findViewById(R.id.free_ride_no);
            credits=findViewById(R.id.credits);
            no_of_credits=findViewById(R.id.credits_amount);

            past_trips=findViewById(R.id.past_trips);
            see_all=findViewById(R.id.see_all);

            //volley request
            mQueue = Volley.newRequestQueue(this);

            Glide.with(this)
                    .load("https://randomuser.me/api/portraits/men/78.jpg")
                    .into(profile_image);

            past_trips.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    JsonParse();
                }
            });


        }

        private void JsonParse() {
            String url = "https://gist.githubusercontent.com/iranjith4/522d5b466560e91b8ebab54743f2d0fc/raw/7b108e4aaac287c6c3fdf93c3343dd1c62d24faf/radius-mobile-intern.json";

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    List<ProfileApi> profileApis = new ArrayList<>();
                    try {
                        JSONObject parentJsonObject = response.getJSONObject("data");

                        JSONObject childJsonObject = parentJsonObject.getJSONObject("profile");

                        ProfileApi api = new ProfileApi();
                        api.setFirst_name(childJsonObject.getString("first_name"));
                        // middle name is the profile image
                        api.setMiddle_name(childJsonObject.getString("middle_name"));
                        api.setLast_name(childJsonObject.getString("last_name"));
                        api.setCity(childJsonObject.getString("city"));
                        api.setCountry(childJsonObject.getString("Country"));

                        JSONObject child2 = parentJsonObject.getJSONObject("stats");
                        api.setRides(child2.getString("rides"));
                        api.setFree_rides(child2.getString("free_rides"));

                        JSONObject child_2a = child2.getJSONObject("credits");
                        api.setValue(child_2a.getString("value"));
                        api.setCurrency(child_2a.getString("currency"));
                        api.setCurrency_symbol(child_2a.getString("currency_symbol"));

                        JSONArray childArray = parentJsonObject.getJSONArray("trips");

                        List<ProfileApi.Trips> tripsList = new ArrayList<>();
                        for (int i = 0; i <= childArray.length(); i++) {
                            JSONObject trips = childArray.getJSONObject(i);
                            ProfileApi.Trips trips1 = new ProfileApi.Trips();
                            trips1.setFrom(trips.getString("from"));
                            trips1.setTo(trips.getString("to"));
                            trips1.setFrom_time(trips.getString("from_time"));
                            trips1.setTo_time(trips.getString("to_time"));
                            trips1.setTrip_duration_in_mins(trips.getString("trip_duration_in_mins"));
                            JSONObject trips2 = trips.getJSONObject("cost");
                            trips1.setValue(trips.getString("value"));
                            trips1.setCurrency(trips.getString("currency"));
                            trips1.setCurrency_symbol(trips.getString("currency_symbol"));


                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });

        }



}
