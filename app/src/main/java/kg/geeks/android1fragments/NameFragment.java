package kg.geeks.android1fragments;

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

public class NameFragment extends Fragment {

    public EditText etName, etLastName;
    private Button buttonNF;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_name, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        initUI(view);
        onClickButtonSend();

    }



    private void initUI(View view) {

        etName = view.findViewById(R.id.et_name);
        etLastName = view.findViewById(R.id.et_last_name);
        buttonNF = view.findViewById(R.id.btn_nf);
    }

    private void onClickButtonSend() {
        buttonNF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etName.getText().toString().isEmpty() && !etLastName.getText().toString().isEmpty()) {
                    sendUIData();
                   // navigateToAF();
                } else {
                    Toast.makeText(getActivity(), "Fill the fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    private void sendUIData() {
        Bundle bundle = new Bundle();
        String name = etName.getText().toString(), lastName = etLastName.getText().toString();
        bundle.putString(InfoFragment.KEY_NAME, name);
        bundle.putString(InfoFragment.KEY_LAST_NAME, lastName);

        AgeFragment fragment = new AgeFragment();

        fragment.setArguments(bundle);

        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container_view, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void navigateToAF() {
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, new AgeFragment())
                .commit();
    }
}