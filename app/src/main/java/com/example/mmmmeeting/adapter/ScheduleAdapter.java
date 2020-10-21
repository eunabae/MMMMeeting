// 약속 목록의 카드뷰 생성, 게시글 생성, 수정, 삭제와 연결됨

package com.example.mmmmeeting.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mmmmeeting.Info.ScheduleInfo;
import com.example.mmmmeeting.OnScheduleListener;
import com.example.mmmmeeting.R;
import com.example.mmmmeeting.ScheduleDeleter;
import com.example.mmmmeeting.activity.MakeScheduleActivity;
import com.example.mmmmeeting.activity.ContentScheduleActivity;
import com.example.mmmmeeting.view.ReadScheduleView;
import com.google.android.exoplayer2.SimpleExoPlayer;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.MainViewHolder> {
    private ArrayList<ScheduleInfo> mDataset;
    private Activity activity;
    private ScheduleDeleter scheduleDeleter; //Firestore db에서 삭제 되도록 연동
    private ArrayList<ArrayList<SimpleExoPlayer>> playerArrayListArrayList = new ArrayList<>();
    private final int MORE_INDEX = 2;

    static class MainViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        MainViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public ScheduleAdapter(Activity activity, ArrayList<ScheduleInfo> myDataset) {
        this.mDataset = myDataset;
        this.activity = activity;

        scheduleDeleter = new ScheduleDeleter(activity);
    }



    public void setOnPostListener(OnScheduleListener onPostListener){
        scheduleDeleter.setOnPostListener(onPostListener);
    }

    @Override
    public int getItemViewType(int position){
        return position;
    }

    @NonNull
    @Override
    public ScheduleAdapter.MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_schedule, parent, false);
        final MainViewHolder mainViewHolder = new MainViewHolder(cardView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ContentScheduleActivity.class);
                intent.putExtra("scheduleInfo", mDataset.get(mainViewHolder.getAdapterPosition()));
                activity.startActivity(intent);
            }
        });

        cardView.findViewById(R.id.menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v, mainViewHolder.getAdapterPosition());
            }
        });

        return mainViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MainViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        TextView titleTextView = cardView.findViewById(R.id.titleTextView);

        ScheduleInfo postInfo = mDataset.get(position);
        titleTextView.setText(postInfo.getTitle());

        ReadScheduleView readScheduleView = cardView.findViewById(R.id.readScheduleView);
        LinearLayout contentsLayout = cardView.findViewById(R.id.contentsLayout);

        if (contentsLayout.getTag() == null || !contentsLayout.getTag().equals(postInfo)) {
            contentsLayout.setTag(postInfo);
            contentsLayout.removeAllViews();

            readScheduleView.setMoreIndex(MORE_INDEX);
            readScheduleView.setScheduleInfo(postInfo);

            ArrayList<SimpleExoPlayer> playerArrayList = readScheduleView.getPlayerArrayList();
            if(playerArrayList != null){
                playerArrayListArrayList.add(playerArrayList);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    private void showPopup(View v, final int position) {
        PopupMenu popup = new PopupMenu(activity, v);
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.modify:
                        myStartActivity(MakeScheduleActivity.class, mDataset.get(position));
                        return true;
                    case R.id.delete:
                        scheduleDeleter.storageDelete(mDataset.get(position));
                        return true;
                    default:
                        return false;
                }
            }
        });

        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.post, popup.getMenu());
        popup.show();
    }

    private void myStartActivity(Class c, ScheduleInfo postInfo) {
        Intent intent = new Intent(activity, c);
        intent.putExtra("scheduleInfo", postInfo);
        activity.startActivity(intent);
    }

    public void playerStop(){
        for(int i = 0; i < playerArrayListArrayList.size(); i++){
            ArrayList<SimpleExoPlayer> playerArrayList = playerArrayListArrayList.get(i);
            for(int ii = 0; ii < playerArrayList.size(); ii++){
                SimpleExoPlayer player = playerArrayList.get(ii);
                if(player.getPlayWhenReady()){
                    player.setPlayWhenReady(false);
                }
            }
        }
    }
}