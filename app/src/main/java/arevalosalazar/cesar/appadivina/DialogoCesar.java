package arevalosalazar.cesar.appadivina;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoCesar extends DialogFragment {
    ADialogoCesar acciones;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstancestate){
        AlertDialog.Builder volver = new AlertDialog.Builder(getActivity());
        volver.setMessage(R.string.volver);
        volver.setTitle(R.string.fin);
        volver.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int r) {
                acciones.onDialogPositiveClick(DialogoCesar.this);

            }
        });
        volver.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int r) {
                acciones.onDialogNegativeClick(DialogoCesar.this);

            }
        });
        return volver.create();
    }

    public void onAttach(Context contexto){
        super.onAttach(contexto);
        acciones = (ADialogoCesar) contexto;
    }
}
