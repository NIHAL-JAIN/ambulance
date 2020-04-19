package com.example.quickambulance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.quickambulance.Model.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MainActivity extends AppCompatActivity {

   Button btnSignIn,btnRegister;
   RelativeLayout rootLayout;

   FirebaseAuth auth;
   FirebaseDatabase db;
   DatabaseReference users;
   AlertDialog.Builder dialogReg;
   AlertDialog.Builder dialogLogn;

   MaterialEditText edtEmail ;
   MaterialEditText edtPassword;
   MaterialEditText edtName  ;
   MaterialEditText edtPhone ;
   MaterialEditText edtAddress;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Before setcontent View
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Arkhip_font.ttf")
                .setFontAttrId(R.attr.fontPath)
                 .build());
                 setContentView(R.layout.activity_main);

                 //Init FireBase
        auth = FirebaseAuth.getInstance();
        db= FirebaseDatabase.getInstance();
        users = db.getReference("Users");

                 //Init View
        btnRegister = findViewById(R.id.btnRegister);
        btnSignIn = findViewById(R.id.btnSignIn);
        rootLayout = findViewById(R.id.rootLayout);

        //Event
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRegisterDialog();
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLoginDialog();
            }
        });
    }
// login
    private void showLoginDialog() {
        dialogLogn = new AlertDialog.Builder(this);
        dialogLogn.setTitle("SIGN IN");
        dialogLogn.setMessage("Please use email to sign in");

        LayoutInflater inflater = LayoutInflater.from(this);
        View login_layout = inflater.inflate(R.layout.layout_login,null);

        final MaterialEditText edtEmail = login_layout.findViewById(R.id.edtEmail);
        final MaterialEditText edtPassword = login_layout.findViewById(R.id.edtPassword);

        dialogLogn.setView(login_layout);

        //Set button
        dialogLogn.setPositiveButton("SIGN IN", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        //Check Validation
                        if (TextUtils.isEmpty(edtEmail.getText().toString())) {
                            Snackbar.make(rootLayout, "Please enter email address", Snackbar.LENGTH_SHORT)
                                    .show();
                           // return;
                        }

                        if (TextUtils.isEmpty(edtPassword.getText().toString())) {
                            Snackbar.make(rootLayout, "Please enter password", Snackbar.LENGTH_SHORT)
                                    .show();
                          //  return;
                        }

                        if (edtPassword.getText().toString().length() < 6) {
                            Snackbar.make(rootLayout, "Password too short !!!", Snackbar.LENGTH_SHORT)
                                    .show();
                           // return;
                        }

                        //Login
                        auth.signInWithEmailAndPassword(String.valueOf(edtEmail.getText()),edtPassword.getText().toString())
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        startActivity(new Intent(MainActivity.this,Main2Activity.class));
                                        finish();

                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Snackbar.make(rootLayout,"Failed"+e.getMessage(),Snackbar.LENGTH_SHORT)
                                        .show();
                            }
                        });

                    }
                });

        dialogLogn.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        dialogLogn.show();


    }

    private void showRegisterDialog() {
        dialogReg= new AlertDialog.Builder(this);
        dialogReg.setTitle("REGISTER");
        dialogReg.setMessage("Please use email to register");
        dialogReg.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
           Toast.makeText(getApplicationContext(),"cancelled",Toast.LENGTH_SHORT).show();
            }
        });
        LayoutInflater inflater = LayoutInflater.from(this);
        View register_layout = inflater.inflate(R.layout.layout_register,null);


        dialogReg.setView(register_layout);

          edtEmail = register_layout.findViewById(R.id.edtEmail);
          edtPassword = register_layout.findViewById(R.id.edtPassword);
          edtName = register_layout.findViewById(R.id.edtName);
          edtPhone = register_layout.findViewById(R.id.edtPhone);
          edtAddress = register_layout.findViewById(R.id.edtAddress);

        //Set button
        dialogReg.setPositiveButton("Register", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialogInterface, int i) {


                //Check Validation
                if (TextUtils.isEmpty(edtEmail.getText().toString()))
                {
                    edtEmail.setText("");
                    edtEmail.setHint("Please enter email address");
                   // return;
                }else
                    if (TextUtils.isEmpty(edtPhone.getText().toString()))
                {
                    edtPhone.setText("");
                    edtPhone.setHint("Please enter phone number");
                 //   return;
                }else
                if (TextUtils.isEmpty(edtPassword.getText().toString()))
                {
                    edtPassword.setText("");
                    edtPassword.setHint("Please enter password");
                }else
                if (edtPassword.getText().toString().length()<6)
                {
                    edtPassword.setText("");
                    edtPassword.setHint("Please enter password of valid length");
                    //    return;
                }else
                if (TextUtils.isEmpty(edtAddress.getText().toString()))
                {
                    edtAddress.setText("");
                    edtAddress.setHint("Please enter password");
                }
                    //Register new user
                try {
                    Register(edtEmail.getText().toString(), edtPassword.getText().toString());
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });

        dialogReg.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        dialogReg.show();

    }
    private void Register(final String mail, final String pass){
        auth.createUserWithEmailAndPassword(mail,pass)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        //Save user to db
                        User user = new User();
                        user.setEmail(mail);
                        user.setPassword(pass);
                        user.setName(edtName.getText().toString());
                        user.setPhone(edtPhone.getText().toString());
                        user.setAddress(edtAddress.getText().toString());
                        //Use email to key
                        users.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(user)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(getApplicationContext(),"register success",Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(getApplicationContext(),"register failed "+e.getMessage(),Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"failed "+e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
