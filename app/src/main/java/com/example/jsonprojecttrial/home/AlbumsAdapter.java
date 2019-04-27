package com.example.jsonprojecttrial.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jsonprojecttrial.R;
import com.example.jsonprojecttrial.data.AlbumsResponse;
import com.example.jsonprojecttrial.databinding.ItemAlbumsBinding;

import java.util.ArrayList;
import java.util.List;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.AlbumsHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    private final List<AlbumsResponse> albumsResponses = new ArrayList<>();
    //we create an empty list array and store list information here from MainActivity
    // through setData below

    public void setData(List<AlbumsResponse> data){
        albumsResponses.clear(); //anytime setdata is called the list is cleared
        albumsResponses.addAll(data); //data passed through as a parameter is stored here
        notifyDataSetChanged(); //notify the user that the data in the recycler view has changed
    }

    @NonNull
    @Override
    public AlbumsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        return new AlbumsHolder(ItemAlbumsBinding
                .inflate(layoutInflater, viewGroup, false));

    }

    @Override
    public void onBindViewHolder(@NonNull AlbumsHolder albumsHolder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        albumsHolder.bind(albumsResponses.get(position));
        //list data from setData is binded with itemsAlbumsBinding
        //
    }

    @Override
    public int getItemCount() {//gets size of the list, so recycler view knows how much items needs
        // to be recycled
        return albumsResponses.size(); //returns the size of the list
    }

    public static class AlbumsHolder extends RecyclerView.ViewHolder{
        private final ItemAlbumsBinding itemAlbumsBinding;
        //all the data fields from the UI are stored here.

        public AlbumsHolder(ItemAlbumsBinding itemAlbumsBinding) {
            super(itemAlbumsBinding.getRoot());
            this.itemAlbumsBinding = itemAlbumsBinding;
            //constructor allows the UI data itemsAlbumsBiding class to get list data from this class
        }

        void bind(AlbumsResponse albumsResponse){
            itemAlbumsBinding.setAlbums(albumsResponse);
            //albums parameter is set to itemAlbumsBinding class (UI)
            itemAlbumsBinding.executePendingBindings();
            //makes sure the binding is done immediately
        }

    }
}
