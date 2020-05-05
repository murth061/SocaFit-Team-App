package com.example.socafit;

import android.content.Context;
import android.media.Image;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.socafit.ui.HomePost;
import com.example.socafit.ui.home.HomeFragment;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PostListAdapter extends ArrayAdapter<HomePost> {

    private static final String TAG ="PostListAdapter";
    private Context mContext;
    private int mResource;
    private int lastPosition = -1;
    // for animation and more efficient loading
    private static class ViewHolder {
        TextView name;
        TextView userID;
        TextView postContent;
        ImageView img;
        TextView likesCount;
        Button reactButton;
        Button commentButton;
    }

    public PostListAdapter(Context context, int resource, ArrayList<HomePost> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //set up image loader (method is at bottom of this page)
        setupImageLoader();
        final String name = getItem(position).getName();
        final String userID = Objects.requireNonNull(getItem(position)).getUserName();
        final String postContent = getItem(position).getPostContent();
        final String imgURL = getItem(position).getImgURL();
        final int likesCount = (getItem(position).getLikes());
        // create a final view for the animation
        final View result;
        //viewholder
        final ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.post_name);
            holder.userID = (TextView) convertView.findViewById(R.id.post_username);
            holder.postContent = (TextView) convertView.findViewById(R.id.post_text);
            holder.img = (ImageView) convertView.findViewById(R.id.image);
            holder.likesCount = (TextView) convertView.findViewById(R.id.likes);
            //buttons
            holder.reactButton = (Button) convertView.findViewById(R.id.reactButton);
            holder.commentButton = (Button) convertView.findViewById(R.id.commentButton);
            result = convertView;
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext,
                (position>lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
        result.startAnimation(animation);
        lastPosition = position;
        ImageLoader imageLoader = ImageLoader.getInstance();

        //backup image in case they fail
        int defaultImage = mContext.getResources().getIdentifier("@drawable/leo",null,mContext.getPackageName());
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(defaultImage)
                .showImageOnFail(defaultImage)
                .showImageOnLoading(defaultImage).build();
        //download and display image from url
        imageLoader.displayImage(imgURL, holder.img, options);
        holder.name.setText(name);
        holder.userID.setText(userID);
        holder.postContent.setText(postContent);
        //COMMENT button
        holder.commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open up new comment page oooo
            }
        });
        //LIKE button
        holder.reactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // toast
                CharSequence text = "Liked " + holder.name.getText()+"'s Post";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(mContext, text, duration);
                toast.show();
                // unlike if already liked
                if(holder.reactButton.getText()=="❤ liked"){
                    // if user was the only one who liked
                    if(holder.likesCount.getText().charAt(0)=='1'){
                        holder.likesCount.setText(" ");
                        holder.reactButton.setText("like");
                    }
                    // just set back to original likes
                    else{
                        holder.likesCount.setText(likesCount+" ❤");
                        holder.reactButton.setText("like");
                    }
                }
                // like if we didn't like it
                else{
                    holder.likesCount.setText(Integer.toString(likesCount+1)+" ❤️");
                    holder.reactButton.setText("❤ liked");
                    // holder.reactButton.setTextColor("@color/heart");
                }
            }
        });
        if(likesCount == 0){
            holder.likesCount.setText(null);
        }
        else if(likesCount == 1){
            holder.likesCount.setText(Integer.toString(likesCount) + " ❤️");
        }
        else{
            holder.likesCount.setText((Integer.toString(likesCount) + " ❤"));
        }
        return convertView;
    }
    // END LIKE BUTTON
    // UNIVERSAL IMAGE LOADER SETUP
    private void setupImageLoader(){
        // UNIVERSAL IMAGE LOADER SETUP
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                mContext)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP
    }
}
