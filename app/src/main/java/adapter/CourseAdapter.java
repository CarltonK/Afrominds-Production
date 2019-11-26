package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.afrominds.R;

import java.util.List;

import handler.SingleCourse;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.MyViewHolder> {

    private List<SingleCourse> courses;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, tutor, desc;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.course_name);
            tutor = (TextView) view.findViewById(R.id.course_tut);
            desc = (TextView) view.findViewById(R.id.course_descriprion);
        }
    }

    public CourseAdapter(List<SingleCourse> courses) {
        this.courses = courses;
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.MyViewHolder holder, int position) {
        SingleCourse singleCourse = courses.get(position);
        holder.title.setText(singleCourse.getCourse_name());
        holder.tutor.setText(singleCourse.getCourse_tutor());
        holder.desc.setText(singleCourse.getCourse_description());

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.courses_layout_design, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }
}
