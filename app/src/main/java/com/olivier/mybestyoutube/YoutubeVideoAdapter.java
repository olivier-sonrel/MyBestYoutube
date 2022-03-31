package com.olivier.mybestyoutube;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class YoutubeVideoAdapter extends RecyclerView.Adapter<YoutubeVideoAdapter.YoutubeVideoViewHolder>{

    private List<YoutubeVideo> youtubeVideoList;


    public class YoutubeVideoViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        TextView tvDescription;

        public YoutubeVideoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }

    public YoutubeVideoAdapter(List<YoutubeVideo> youtubeVideoList/*, TODO OnItemClickListener onItemClickListener*/) {
        this.youtubeVideoList = youtubeVideoList;
        /* TODO this.onItemClickListener = onItemClickListener;*/
    }


    @NonNull
    @Override
    public YoutubeVideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.youtube_video_item, parent, false);
        return new YoutubeVideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YoutubeVideoViewHolder holder, int position) {
        YoutubeVideo youtubeVideo = youtubeVideoList.get(position);
        holder.tvTitle.setText(youtubeVideo.getTitle());
        holder.tvDescription.setText(youtubeVideo.getDescription());

/*  TODO      holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null){
                    onItemClickListener.onItemClick(youtubeVideo);
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return youtubeVideoList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(YoutubeVideo youtubeVideo);
    }
}
