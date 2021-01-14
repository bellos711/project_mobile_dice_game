package org.holmesdude.crapsgame2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ExampleDialog extends AppCompatDialogFragment {
    private TextView textView;
    //private TextView textView2;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //return super.onCreateDialog(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //LayoutInflater inflater = getActivity().getLayoutInflater();
        //View view = inflater.inflate(R.layout.layout_dialog, null);

        //builder.setView(view)
        builder.setTitle("WIN OR LOSE")
                .setMessage("You WIN homie!")
                .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        //textView = view.findViewById(R.id.textView);
        //textView2 = view.findViewById(R.id.textView2);
        //textView2.setText("YOU WIN");
        return builder.create();
    }
}
