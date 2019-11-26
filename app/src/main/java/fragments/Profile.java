package fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.afrominds.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Profile extends Fragment {
    private TextView na_me, cour_se, rat_ing;
    private ImageView user_img;
    private RecyclerView performa_nce, tas_ks;


    public Profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        na_me = view.findViewById(R.id.student_id);
        cour_se = view.findViewById(R.id.course_id);
        rat_ing = view.findViewById(R.id.rating_id);
        user_img = view.findViewById(R.id.img_usr);
        performa_nce = view.findViewById(R.id.performance_recycleview);
        tas_ks = view.findViewById(R.id.tasks_recycleview);

        return view;
    }

}
