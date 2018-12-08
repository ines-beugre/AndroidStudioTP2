package mm.ccn2.istic.fr.tp1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private LinearLayout parentLinearLayout;

    @Bind(R.id.valid) Button mValid;
    @Bind(R.id.lastname) TextView lastname;
    @Bind(R.id.firstname) TextView firstname;
    @Bind(R.id.birthday) TextView birthday;
    @Bind(R.id.birthcity) TextView birthcity;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        parentLinearLayout = (LinearLayout) findViewById(R.id.parent_linear_layout);

        mValid = (Button) findViewById(R.id.valid);

        /*
        * partie 2.1
        * le bouton Valider doit créer un nouvelle utilisateur dans la liste
        * */
        mValid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                * Après User Parcelable
                * 1 on recupère le user crée dans l'activity1
                 * */
                String nom = lastname.getText().toString();
                String prenom = firstname.getText().toString();
                String dateDeNaissance = birthcity.getText().toString();
                String villeDeNaissance = birthcity.getText().toString();

                User user = new User(nom, prenom, dateDeNaissance, villeDeNaissance);

                // 2 faire un intent vers Main2Activity

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("user", user);
                startActivity(intent);
                finish();

            }
        });


        //partie 1.1
//        mValid.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Context context = getApplicationContext();
//                CharSequence info = "Votre nom est: " + lastname.getText().toString() + "\n" +
//                                    "Votre prénom: " + firstname.getText().toString() + "\n" +
//                                    "Votre date de naissance: " + birthday.getText().toString() + "\n" +
//                                    "Votre ville de naissance: " + birthcity.getText().toString() + "\n";
//
//                int duration = Toast.LENGTH_LONG;
//
//                Toast toast = Toast.makeText(context, info, duration);
//                toast.show();
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.reset, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
       switch (item.getItemId()) {
           case R.id.reset:
                reset();
                return true;
           case R.id.addNum:
               onAddField(view);
                return true;
           default:
            return super.onOptionsItemSelected(item);
       }
    }

    private void reset() {
        EditText field;
        int [] ids = new int [] {
                R.id.lastname,
                R.id.firstname,
                R.id.lastname,
                R.id.birthday,
                R.id.birthcity
        };

        for (int i = 0; i < ids.length; i++) {
            field = (EditText) findViewById(ids[i]);
            field.setText(null);
        }
    }

    private void onAddField(View view) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.field, null);
        // Add the new row before the add field button.
        parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount() - 1);
    }




}

//    private void addNumber() {
//        LinearLayout numberLayout = new LinearLayout(this);
//
//        // Définition du composant Text.
//        TextView number = new TextView(this);
//        number.setText(String.format(getString(R.string.app_name), post.get));
//
//    }

//        String lname = lastname.getText().toString();
//        String fname = firstname.getText().toString();
//        String bday = birthday.getText().toString();
//        String bcity = birthcity.getText().toString();
//
//        List<String> myEditTexts = new ArrayList<>();
//        myEditTexts.add(lname);
//        myEditTexts.add(fname);
//        myEditTexts.add(bday);
//        myEditTexts.add(bcity);
