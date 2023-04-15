package kg.geeks.android1fragments;

import static kg.geeks.android1fragments.InfoFragment.KEY_AGE;
import static kg.geeks.android1fragments.InfoFragment.KEY_LAST_NAME;
import static kg.geeks.android1fragments.InfoFragment.KEY_NAME;
import static kg.geeks.android1fragments.InfoFragment.KEY_SEX;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class PlaceFragment extends Fragment {

    private EditText etSchool, etWork;
    private Button buttonPF;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_place, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initUI(view);
        onClickButtonSend();
    }

    private void initUI(View view) {

        etSchool = view.findViewById(R.id.et_school);
        etWork = view.findViewById(R.id.et_work);
        buttonPF = view.findViewById(R.id.btn_pf);
    }

    private void onClickButtonSend() {
        buttonPF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // navigateToIF();
                sendUIData();

            }
        });
    }

    private void sendUIData() {
        Bundle bundle = getArguments();

        String school = etSchool.getText().toString(), work = etWork.getText().toString();
        //test
        bundle.putString(InfoFragment.KEY_SCHOOL, school);
        bundle.putString(InfoFragment.KEY_WORK, work);

        InfoFragment fragment = new InfoFragment();

        fragment.setArguments(bundle);

        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container_view, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    // }

    private void navigateToIF() {
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, new InfoFragment())
                .commit();
    }
}