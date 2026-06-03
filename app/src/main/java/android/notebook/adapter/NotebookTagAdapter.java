package android.notebook.adapter;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.notebook.R;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotebookTagAdapter extends RecyclerView.Adapter<NotebookTagAdapter.ViewHolder> {

    private List<MaterialButton> materialButtons = new ArrayList<>();
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
        MaterialButton materialButton = holder.materialButton;
        materialButton.setText(tagList.get(position));
        materialButtons.add(materialButton);
        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (View view : materialButtons) {
                    view.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                }
                v.setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));
            }
        });
    }

    @Override
    public int getItemCount() {
        return tagList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public MaterialButton materialButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            materialButton = itemView.findViewById(R.id.button);
        }
    }
}
