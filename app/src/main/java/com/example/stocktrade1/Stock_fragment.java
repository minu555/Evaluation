package com.example.stocktrade1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.stocktrade1.model.BseandNse;
import com.example.stocktrade1.model.Responsebase;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Stock_fragment extends Fragment {

    private static final String TAG = Stock_fragment.class.getName();
    ArrayList<BseandNse> dataholder;
    RecyclerView recyclerView;
    MyAdapter adapter;
    RequestQueue request;
    ViewPager viewPager;
    //private JsonObjectRequest mStringRequest;
    private String url = "https://mobaelinx.angelbroking.com/AngelService/MoversNews/Movers/1.0.0";
    private int position;
    private BottomSheetDialog bottomSheetDialog;
    TabLayout tabLayout;
    private EditText edittextnumber;
    private Button button1, button2;

    public Stock_fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stock_recycler, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        dataholder = new ArrayList<>();
        adapter = new MyAdapter(getContext(), dataholder);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        fetchdata();
        return view;
    }

    public void fetchdata() {
        //RequestQueue initialized
        RequestQueue requestQueue = Volley.newRequestQueue(this.getContext());
        JSONObject jsonObject = new JSONObject();
        JSONObject datas1 = new JSONObject();
        JSONObject datas2 = new JSONObject();
        try {
            datas1.put("category", "TOPGAINER");
            datas1.put("sessionID", "guest");
            datas1.put("userID", "guest");
            datas2.put("appID", "f363c1745f5f63433a57e369a01c5752");
            datas2.put("data", datas1);
            datas2.put("formFactor", "M");
            datas2.put("future", "0");
            datas2.put("response_format", "json");
            jsonObject.put("request", datas2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //created request
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Responsebase responseBase = new Gson().fromJson(response.toString(), Responsebase.class);
                dataholder.addAll(responseBase.getResponse().getData().getNse());
                dataholder.addAll(responseBase.getResponse().getData().getBse());
                adapter.notifyDataSetChanged();
                adapter.onLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        position = recyclerView.getChildAdapterPosition(v);
                        bottomsheet();
                        return true;
                    }
                });
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(request);
    }

    public void bottomsheet() {
        bottomSheetDialog = new BottomSheetDialog(this.getContext());
        View view = getLayoutInflater().from(getActivity()).inflate(R.layout.bottom_sheet, null);
        bottomSheetDialog.setCanceledOnTouchOutside(false);
        bottomSheetDialog.show();
        EditText edittextnumber = view.findViewById(R.id.edittextnumber);
        Button button1 = view.findViewById(R.id.button1);
        Button button2 = view.findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = edittextnumber.getText().toString();

                if (str.isEmpty()) {
                    Toast.makeText(getActivity(), "Enter valid input", Toast.LENGTH_SHORT).show();
                }else{
                    bottomSheetDialog.dismiss();
                    ViewPager viewPager = getActivity().findViewById(R.id.view_pager);
                    viewPager.setCurrentItem(1);

                }


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = edittextnumber.getText().toString();

                if (str.isEmpty()) {
                    Toast.makeText(getActivity(), "Enter valid input", Toast.LENGTH_SHORT).show();
                }else{
                    bottomSheetDialog.dismiss();
                    ViewPager viewPager = getActivity().findViewById(R.id.view_pager);
                    viewPager.setCurrentItem(1);

                }
            }
        });
        bottomSheetDialog.setContentView(view);
    }
}