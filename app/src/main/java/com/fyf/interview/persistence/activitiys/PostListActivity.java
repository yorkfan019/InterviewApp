package com.fyf.interview.persistence.activitiys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fyf.interview.R;
import com.fyf.interview.persistence.adapter.PostAdaptor;
import com.fyf.interview.persistence.db.PostsDatabaseHelper;
import com.fyf.interview.persistence.model.Post;
import com.fyf.interview.persistence.model.User;

import java.util.List;

public class PostListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_list);

        // Create sample data
        User sampleUser = new User();
        sampleUser.userName = "York";
        sampleUser.profilePictureUrl = "https://i.imgur.com/tGbaZCY.jpg";

        Post samplePost = new Post();
        samplePost.user = sampleUser;
        samplePost.text = "Won won!";

        // Get singleton instance of database
        PostsDatabaseHelper postsDatabaseHelper = PostsDatabaseHelper.getInstance(this);

        // Add sample post to the database
        postsDatabaseHelper.addPost(samplePost);

        // Get all posts from database
        List<Post> posts = postsDatabaseHelper.getAllPosts();
//        for (Post post : posts) {
//            // do something
//        }

        RecyclerView rvPosts = (RecyclerView) findViewById(R.id.rvPosts);
        // Create adapter passing in the sample user data
        PostAdaptor postAdaptor = new PostAdaptor(this,posts);
        // Attach the adapter to the recyclerview to populate items
        rvPosts.setAdapter(postAdaptor);
        // Set layout manager to position the items
        rvPosts.setLayoutManager(new LinearLayoutManager(this));
    }
}
