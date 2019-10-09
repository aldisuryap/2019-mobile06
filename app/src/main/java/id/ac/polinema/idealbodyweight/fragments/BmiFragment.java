package id.ac.polinema.idealbodyweight.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import id.ac.polinema.idealbodyweight.R;
import id.ac.polinema.idealbodyweight.util.BmiIndex;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BmiFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class BmiFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public BmiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bmi, container, false);
        final EditText heightText = view.findViewById(R.id.input_height_bmi);
        final EditText weightText = view.findViewById(R.id.input_weight_bmi);

        Button calculation = view.findViewById(R.id.button_calculate_bmi);
        calculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    String heightStr = heightText.getText().toString();
                    String weightStr = weightText.getText().toString();
                    if (!TextUtils.isEmpty(heightStr) && !TextUtils.isEmpty(weightStr) ) {
                        float height = Float.parseFloat(heightStr);
                        float weight = Float.parseFloat(weightStr);
                        BmiIndex bmi = new BmiIndex(height, weight);
                        mListener.onCalculateBodyMassIndexButtonClicked(bmi.getIndex(), bmi.getType());
                    } else {
                        Toast.makeText(getActivity(), "Input your weight and height please", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onCalculateBodyMassIndexButtonClicked(float index, String type);
    }
}
