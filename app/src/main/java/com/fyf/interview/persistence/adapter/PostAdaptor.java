package com.fyf.interview.persistence.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.fyf.interview.R;
import com.fyf.interview.persistence.model.Post;

import java.util.List;


// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class PostAdaptor extends RecyclerView.Adapter<PostAdaptor.ViewHolder> {


    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView postTextView;
        public Button editButton;
        public Button delButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            postTextView = (TextView) itemView.findViewById(R.id.post_name);
            editButton = (Button) itemView.findViewById(R.id.edit_button);
            delButton = (Button) itemView.findViewById(R.id.del_button);
        }

    }

    // Store a member variable for the Posts
    private List<Post> mPosts;
    // Store the context for easy access
    private Context mContext;

    // Pass in the posts array into the constructor
    public PostAdaptor(Context context, List<Post> posts) {
        mPosts = posts;
        mContext = context;
    }
    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }


    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View postView = inflater.inflate(R.layout.rv_item_sqlite,parent,false);
        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(postView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Get the data model based on position
        Post post = mPosts.get(position);

        // Set item views based on your views and data model
        TextView postTextView = holder.postTextView;
        postTextView.setText(post.text);
        Button editButton = holder.editButton;
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Button delButton = holder.delButton;
        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }
}
