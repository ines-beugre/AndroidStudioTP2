package mm.ccn2.istic.fr.tp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {

    @Bind(R.id.newClient) Button mNewClient;
//    @Bind(R.id.itemList) TextView itemList;
    public static final String EXTRA_MESSAGE = "mmm.cc2.istic.fr.tp1_1.1.message";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ButterKnife.bind(this);

        mNewClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
//                String newView = itemList.getText().toString();
//                intent.putExtra(EXTRA_MESSAGE, newView);
                startActivity(intent);
                finish();
            }
        });
    }
}
