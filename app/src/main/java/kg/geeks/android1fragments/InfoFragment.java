package kg.geeks.android1fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class InfoFragment extends Fragment {

    public static String KEY_NAME = "name";
    public static String KEY_LAST_NAME = "lastname";
    public static String KEY_AGE = "age";
    public static String KEY_SEX = "sex";
    public static String KEY_SCHOOL = "school";
    public static String KEY_WORK = "work";
    public static String DEFAULT_VALUE = "null";

    private TextView tvName, tvLastName, tvAge, tvSex, tvSchool, tvWork;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initUI(view);
        getBundleNF();
    }

    private void getBundleNF() {
        Bundle bundle = this.getArguments();
        if (bundle !=null ){
            String name = bundle.getString(KEY_NAME);
            String lastName = bundle.getString(KEY_LAST_NAME);
            String age = bundle.getString(KEY_AGE);
            String sex = bundle.getString(KEY_SEX);
            String school = bundle.getString(KEY_SCHOOL);
            String work = bundle.getString(KEY_WORK);

                tvName.append(name);
                tvLastName.append(lastName);
                tvAge.append(age);
                tvSex.append(sex);
                tvSchool.append(school);
                tvWork.append(work);
            }else{
            System.out.println("errorrrrrrrrrrrrrrrrrrrr");        }
        }


    private void initUI(View view) {
        tvName=view.findViewById(R.id.tv_name);
        tvLastName=view.findViewById(R.id.tv_last_name);
        tvAge=view.findViewById(R.id.tv_age);
        tvSex=view.findViewById(R.id.tv_sex);
        tvSchool=view.findViewById(R.id.tv_school);
        tvWork=view.findViewById(R.id.tv_work);
    }
}