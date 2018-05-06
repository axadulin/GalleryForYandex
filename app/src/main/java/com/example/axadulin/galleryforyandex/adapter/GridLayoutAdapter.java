package com.example.axadulin.galleryforyandex.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.axadulin.galleryforyandex.R;
import com.example.axadulin.galleryforyandex.helper.OnItemClickListener;
import com.example.axadulin.galleryforyandex.model.FlickrPicture;
import com.squareup.picasso.Picasso;
import java.util.List;



public class GridLayoutAdapter extends RecyclerView.Adapter<GridLayoutAdapter.ViewHolder> {
    private List<FlickrPicture> mList;
    private Context mContext;
    private OnItemClickListener mItemClickListener;

    public GridLayoutAdapter(Context context, List<FlickrPicture> flickrPictureList, OnItemClickListener listener) {
        mContext = context;
        mList = flickrPictureList;
        mItemClickListener = listener;
    }

    public void setImageList(List<FlickrPicture> list) {
        this.mList = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_itemview, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mItemClickListener.onItemClick(view, viewHolder.getAdapterPosition());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FlickrPicture flickrPicture = mList.get(position);
        holder.mArticleTitle.setText(flickrPicture.getTitle());

        Picasso.with(mContext)
                .load(flickrPicture.getSmallPhotoURI())
                .into(holder.mArticleImage);
    }

    @Override
    public int getItemCount() {
        if (mList != null) {
            return mList.size();
        } else {
            return 0;
        }
    }

     class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mArticleImage;
        private TextView mArticleTitle;

         ViewHolder(View itemView) {
            super(itemView);

            mArticleImage = itemView.findViewById(R.id.article_image);
            mArticleTitle = itemView.findViewById(R.id.article_title);
        }
    }
}
