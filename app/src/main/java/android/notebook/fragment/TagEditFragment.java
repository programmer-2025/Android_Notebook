package android.notebook.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.notebook.R;

import com.google.android.material.button.MaterialButton;

public class TagEditFragment extends Fragment {

    //引数は無しにする（※インスタンス化できないため）
    public TagEditFragment() {
        // Required empty public constructor
    }

    public static TagEditFragment newInstance() {
        return new TagEditFragment();
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MaterialButton backHomeButton = view.findViewById(R.id.backHomeButton); //ホームフラグメントに戻るボタン
        backHomeButton.setOnClickListener(v -> {
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in, R.anim.fade_out, R.anim.fade_in, R.anim.slide_out)
                    .remove(this)
                    .replace(R.id.fragmentContainerView, new HomeFragment())
                    .commit();
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tag_edit, container, false);
    }
}