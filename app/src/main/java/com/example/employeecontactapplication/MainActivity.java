package com.example.employeecontactapplication;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String selectedEmployeeName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("23ITR012 Employee App");
        setContentView(R.layout.activity_main);

        setupButtons();
    }

    private void setupButtons() {

        findViewById(R.id.btnCallDavid).setOnClickListener(v ->
                showCallDialog("Kaaviya Lakshmi"));

        findViewById(R.id.btnSMSDavid).setOnClickListener(v ->
                Toast.makeText(this,"SMS to Kaaviya Lakshmi",Toast.LENGTH_SHORT).show());

        findViewById(R.id.btnCallSarah).setOnClickListener(v ->
                showCallDialog("Ramesh Pandiyan"));

        findViewById(R.id.btnEmailSarah).setOnClickListener(v ->
                Toast.makeText(this,"Email to Ramesh Pandiyan",Toast.LENGTH_SHORT).show());

        findViewById(R.id.btnCallJohn).setOnClickListener(v ->
                showCallDialog("Ramya Devi"));

        findViewById(R.id.btnSMSJohn).setOnClickListener(v ->
                Toast.makeText(this,"SMS to Ramya Devi",Toast.LENGTH_SHORT).show());

        findViewById(R.id.btnCallJane).setOnClickListener(v ->
                showCallDialog("Laavanya Sri"));

        findViewById(R.id.btnEmailJane).setOnClickListener(v ->
                Toast.makeText(this,"Email to Laavanya Sri",Toast.LENGTH_SHORT).show());
    }

    private void showCallDialog(String employeeName) {

        selectedEmployeeName = employeeName;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_call_confirmation, null);
        builder.setView(view);

        TextView tv = view.findViewById(R.id.tvConfirmMessage);
        tv.setText("Do you want to call " + employeeName + "?");

        AlertDialog dialog = builder.create();

        Button cancel = view.findViewById(R.id.btnCancelDialog);
        Button call = view.findViewById(R.id.btnCallDialog);

        cancel.setOnClickListener(v -> dialog.dismiss());

        call.setOnClickListener(v -> {
            dialog.dismiss();
            Toast.makeText(this,
                    "Calling " + selectedEmployeeName + "...",
                    Toast.LENGTH_SHORT).show();
        });

        dialog.show();
    }
}