package team.itis.lists.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import team.itis.lists.R;

public class StrangeAdapter extends RecyclerView.Adapter<StrangeAdapter.ViewHolder> {
    private final int rowResId;
    private String[] dataset;

    // Provide a suitable constructor (depends on the kind of dataset)
    public StrangeAdapter(String[] dataset, int rowResId) {
        this.dataset = dataset;
        this.rowResId = rowResId;
    }

    @Override
    public StrangeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowResId, parent, false);
        return new StrangeAdapter.ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setItem(dataset[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return dataset.length;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public EditText editText;
        private String item;

        public ViewHolder(View itemView) {
            super(itemView);
            editText = itemView.findViewById(R.id.strange_edit_text);

        }

        public void setItem(String item) {
            this.item = item;
            editText.setText(this.item);
        }
    }
}