package mm.ccn2.istic.fr.tp1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mm.ccn2.istic.fr.tp1.entity.User;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private TextView mLastname;
    private TextView mFirstname;
    private TextView mBirthday;
    private TextView mBirthcity;

    List<User> users;

    //2 Affiche la liste lors de la création de l"adapter
    public MyAdapter(List<User> users) {
        this.users = users;
    }

    //methode exécutée une foisà la création du ViewHolder
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder myViewHolder, int position) {
        myViewHolder.display(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    //1  sert a mettre à jour les données de la cellulle
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);

            mLastname = (TextView)itemView.findViewById(R.id.lastname);
            mFirstname = (TextView)itemView.findViewById(R.id.firstname);
            mBirthday = (TextView)itemView.findViewById(R.id.birthday);
            mBirthcity = (TextView)itemView.findViewById(R.id.birthcity);
        }

        public void display(User user){
            mLastname.setText(user.getLastname());
            mFirstname.setText(user.getFirstname());
            mBirthday.setText(user.getBirthday());
            mBirthcity.setText(user.getBirthcity());
        }
    }
}
