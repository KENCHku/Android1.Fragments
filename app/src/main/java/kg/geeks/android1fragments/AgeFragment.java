package kg.geeks.android1fragments;

import static kg.geeks.android1fragments.InfoFragment.KEY_LAST_NAME;
import static kg.geeks.android1fragments.InfoFragment.KEY_NAME;

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
import android.widget.Toast;


public class AgeFragment extends Fragment {

    private EditText etAge, etSex;
    private Button buttonAF;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_age, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initUI(view);
        onClickButtonSend();
    }

    private void initUI(View view) {

        etAge = view.findViewById(R.id.et_age);
        etSex = view.findViewById(R.id.et_sex);
        buttonAF = view.findViewById(R.id.btn_af);
    }

    public void onClickButtonSend() {
        buttonAF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etAge.getText().toString().isEmpty() && !etSex.getText().toString().isEmpty()) {
                    sendUIData();
                    // navigateToAF();
                } else {
                    Toast.makeText(getActivity(), "Fill the fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void sendUIData() {
        Bundle bundle = getArguments();

        String age = etAge.getText().toString(), sex = etSex.getText().toString();
        //test
        bundle.putString(InfoFragment.KEY_AGE, age);
        bundle.putString(InfoFragment.KEY_SEX, sex);

        PlaceFragment fragment = new PlaceFragment();

        fragment.setArguments(bundle);

        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container_view, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void navigateToPF() {
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, new PlaceFragment())
                .commit();
    }
}