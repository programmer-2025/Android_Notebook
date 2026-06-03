package android.notebook.adapter;

import android.notebook.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotebookTagAdapter extends RecyclerView.Adapter<NotebookTagAdapter.ViewHolder> {

    private List<String> tagList = new ArrayList<>();

    public NotebookTagAdapter(List<String> list) {
        this.tagList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notebook_tag_recycler, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(tagList.get(position));
    }

    @Override
    public int getItemCount() {
        return tagList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tag_textView);
        }
    }
}
