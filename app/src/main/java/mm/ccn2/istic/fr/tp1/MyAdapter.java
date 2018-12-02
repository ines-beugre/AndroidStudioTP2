package mm.ccn2.istic.fr.tp1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<User> users;

    public MyAdapter(List<User> users) {
        this.users = users;
    }

    /*
    * Methode appellée quand le viewHolder est crée
    * return une instance de MyViewHolder avec comme paramètre a vue du layout correspondant au paramètre
    * layoutInflater permet de chercher la vue
    * view est le nom du layout du modele
    * */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //permet de chercher la vue
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    /*
    * Meth exécutée à chaque construction de cellule
    * */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.displayUser(users.get(position));
    }

    /*
    * retourne la taille de liste de user
    * */
    @Override
    public int getItemCount() {
        return users.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView lastname;
        private TextView firstname;
        private TextView birthday;
        private TextView birthcity;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            lastname = (TextView)itemView.findViewById(R.id.lastname);
            firstname = (TextView)itemView.findViewById(R.id.firstname);
            birthday = (TextView)itemView.findViewById(R.id.birthday);
            birthcity = (TextView)itemView.findViewById(R.id.birthcity);
        }

        public void displayUser(User user){

            lastname.setText(user.getLastname());
            firstname.setText(user.getFirstname());
            birthday.setText(user.getBirthday());
            birthcity.setText(user.getBirthcity() );
        }
    }
}
