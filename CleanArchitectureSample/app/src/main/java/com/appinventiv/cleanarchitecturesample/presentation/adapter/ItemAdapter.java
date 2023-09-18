package com.appinventiv.cleanarchitecturesample.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appinventiv.cleanarchitecturesample.R;
import com.appinventiv.cleanarchitecturesample.data.model.User;

import java.util.List;

/**
 * This class is an Adapter which present the data in a Recyclerview
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>  {
    private List<User> users;

    /**
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return
     */
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false));
    }

    /**
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bindData(users.get(position));
    }

    /**
     * This method returns the total child count of Recyclerview
     * @return int
     */
    @Override
    public int getItemCount() {
        return users!=null?users.size():0;
    }

    /**
     * This inner class initiates the individual item of recyclerview and binds data with it.
     */
    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        private final TextView title;
        private final TextView description;

        /**
         * constructor initialize the instance of UI widgets
         * @param itemView
         */
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
        }

        /**
         * This method binds the UI widgets with data
         * @param user
         */
        public void bindData(User user){
            title.setText(user.getUsername());
            description.setText(user.getEmail());
        }
    }

    /**
     * This method updates the UI whenever User list is getting updated
     * @param users
     */
    public void notifyAdapter(List<User> users){
        this.users = users;
        notifyDataSetChanged();
    }
}
