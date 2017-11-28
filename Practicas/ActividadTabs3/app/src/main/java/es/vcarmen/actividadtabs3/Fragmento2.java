package es.vcarmen.actividadtabs3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by matinal on 6/11/17.
 */

public class Fragmento2 extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmento2, container, false);
        TextView tv = (TextView) v.findViewById(R.id.texto);
        tv.setText("TOCADA LA PESTAÑÁ: " + this.getTag());
        return v;
    }
}
