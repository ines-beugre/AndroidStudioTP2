package mm.ccn2.istic.fr.tp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import mm.ccn2.istic.fr.tp1.entity.User;

public class Main2Activity extends AppCompatActivity {


    // 1 creation des variables
    @Bind(R.id.newClient) Button mNewClient;

   // @Bind(R.id.itemlList) RecyclerView mRecyclerView;
    public static final String EXTRA_MESSAGE = "mm.ccn2.istic.fr.tp1MESSAGE";

    // 3 Apres l'Adapter, on déclare la liste qui sera affichée dans la RecyclerView et l'Adapter
     List<User> users;
    private RecyclerView mRecyclerView;
    private MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        // 1 Instanciation d'activityView
        mRecyclerView = (RecyclerView)findViewById(R.id.itemlList);

        // 2 instanciation de la liste de user et ajout de user dans la liste
        users = new ArrayList<>();


        // 1 Permet d'appeller l'activité1
        mNewClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //4 Récuperation de la RecyclerView plus haut
        mRecyclerView = (RecyclerView)findViewById(R.id.itemlList);
        //5 Instanciationd de la liste de personne et ajouter des nouvelles personnes
        users = new ArrayList<>();
        users.add(new User ("Smith", "Bob", "10 10 87", "NY"));
        users.add(new User("Clara", "Li", "21 08 98", "LA"));

        //6 Instanciation de la l'Adapter
        myAdapter = new MyAdapter(users);

        //7 Disposition de la liste avec affichage verticale
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        //8 Lie l'adapter à la liste crée
        mRecyclerView.setAdapter(myAdapter);

        //

        /*
        * 9 apres l'intent user crée dans MainActivity1
        * on récupère le User crée dans l'activité 1 et le bundle permet de s'assurer que l'objet User n'est pas null, sinon erreur
        * voir ce lien https://openclassrooms.com/forum/sujet/probleme-intent-putextra
        *
        * */
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            User user = bundle.getParcelable("user");
            //10 on l'ajoute  la liste de users
            users.add(new User(user.getLastname(), user.getFirstname(), user.getBirthday(), user.getBirthcity()));
        }

    }

}
