package fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.afrominds.R;

import java.util.ArrayList;
import java.util.List;

import adapter.CourseAdapter;
import handler.SingleCourse;

/**
 * A simple {@link Fragment} subclass.
 */
public class Courses extends Fragment {
    private List<SingleCourse> singleCourses = new ArrayList<>();
    private RecyclerView recyclerView;
    private CourseAdapter mAdapter;


    public Courses() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_courses, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_courses);

        mAdapter = new CourseAdapter(singleCourses);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();

        return view;
    }

    private void prepareMovieData() {

        SingleCourse c1 = new SingleCourse("Python", "Dr Kibwana",
                    "An introduction to python");
        singleCourses.add(c1);

        SingleCourse c2 = new SingleCourse("Forex", "Dr Mutua",
                "An introduction to python");
        singleCourses.add(c2);

        SingleCourse c3 = new SingleCourse("Python", "Dr Kibutha",
                "An introduction to forex");
        singleCourses.add(c3);

        SingleCourse c4 = new SingleCourse("Data Science", "Dr Alfred",
                "An introduction to data analysis");
        singleCourses.add(c4);

        SingleCourse c5 = new SingleCourse("Driving", "Dr Kiano",
                "An introduction to driving");
        singleCourses.add(c5);


        mAdapter.notifyDataSetChanged();
    }

}
