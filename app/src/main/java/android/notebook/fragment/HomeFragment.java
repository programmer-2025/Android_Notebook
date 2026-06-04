package android.notebook.fragment;

import android.notebook.adapter.NoteBookDataPreviewAdapter;
import android.notebook.adapter.NotebookTagAdapter;
import android.os.Bundle;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.notebook.R;

import java.util.Arrays;

public class HomeFragment extends Fragment {

    //引数は無しにする（※インスタンス化できないため）
    public HomeFragment() {}

    public static Fragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        DrawerLayout drawerLayout = view.findViewById(R.id.drawer_layout);
        RecyclerView recyclerView = drawerLayout.findViewById(R.id.navigation_view).findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new NotebookTagAdapter(Arrays.asList("Tag1", "Tag2", "Tag3")));

        RecyclerView notebookDataPreviewRecycler = view.findViewById(R.id.notebook_dataPreview_recycler);
        notebookDataPreviewRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        notebookDataPreviewRecycler.setAdapter(new NoteBookDataPreviewAdapter(Arrays.asList("Tag1", "Tag2", "Tag3")));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}