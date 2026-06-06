package android.notebook.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.notebook.R;

public class TagEditFragment extends Fragment {

    //引数は無しにする（※インスタンス化できないため）
    public TagEditFragment() {
        // Required empty public constructor
    }

    public static TagEditFragment newInstance() {
        return new TagEditFragment();
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