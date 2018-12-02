package mm.ccn2.istic.fr.tp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<User> users;
    private MyAdapter myAdapter;

    @Bind(R.id.newClient) Button mNewClient;

    public static final String EXTRA_MESSAGE = "mmm.cc2.istic.fr.tp1_1.1.message";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ButterKnife.bind(this);

        // 1 Instanciation d'activityView
        recyclerView = (RecyclerView)findViewById(R.id.itemList);

        // 2 instanciation de la liste de user et ajout de user dans la liste
        users = new ArrayList<>();

        // 3 Peupler la liste
        users.add(new User("Beugré", "Ines", "21 10 1988", "Abidjan"));
        users.add(new User("Mamadou", "Kindé", "21 08 1989", "Conakry"));

        // 6 Récupere le user nouvellement crée dans MainActivity
        User user = getIntent().getExtras().getParcelable("user");

            //je l'ajoute à la liste si il n'est null
            if (user != null) {
                users.add(new User(user.getLastname(), user.getFirstname(), user.getBirthday(), user.getBirthcity() ));
            }

        // 4 instanciation de l'adapter
        myAdapter = new MyAdapter(users);

        // 5  lie l'adapter à la liste
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(myAdapter);

        // 1 Permet d'appeller l'activité1
        mNewClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
