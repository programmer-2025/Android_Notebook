package android.notebook.fragment;

import android.notebook.adapter.NoteBookDataPreviewAdapter;
import android.notebook.adapter.NotebookTagAdapter;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.notebook.R;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationView;

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
        super.onViewCreated(view, savedInstanceState);

        DrawerLayout drawerLayout = view.findViewById(R.id.drawer_layout);
        NavigationView navigationView = drawerLayout.findViewById(R.id.navigation_view);
        RecyclerView recyclerView = navigationView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new NotebookTagAdapter(Arrays.asList("Tag1", "Tag2", "Tag3")));

        ConstraintLayout includeDrawer = navigationView.findViewById(R.id.include_drawer_layout);
        MaterialButton addTagButton = includeDrawer.findViewById(R.id.addTagButton);
        addTagButton.setOnClickListener(v -> {
            drawerLayout.close();
            if (!(getFragmentManager().findFragmentById(R.id.fragmentContainerView) instanceof TagEditFragment)) {
                getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_in, R.anim.fade_out, R.anim.fade_in, R.anim.slide_out)
                        .add(R.id.fragmentContainerView, new TagEditFragment())
                        .commit();
            }
        });

        RecyclerView notebookDataPreviewRecycler = view.findViewById(R.id.notebook_dataPreview_recycler);
        notebookDataPreviewRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        notebookDataPreviewRecycler.setAdapter(new NoteBookDataPreviewAdapter(Arrays.asList("Tag1", "Tag2", "Tag3")));

        ConstraintLayout homeView = drawerLayout.findViewById(R.id.homeView);
        ConstraintLayout bottomView = homeView.findViewById(R.id.bottomView);
        MaterialButton materialButton = bottomView.findViewById(R.id.newNotebook);
        materialButton.setOnClickListener(v -> {
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in, R.anim.fade_out, R.anim.fade_in, R.anim.slide_out)
                    .replace(R.id.fragmentContainerView, new NotebookFragment())
                    .commit();
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}