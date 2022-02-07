package baric.projekt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterListe extends RecyclerView.Adapter<AdapterListe.Red> {
    //Nista se ne mijenja ode osim imena liste
    private List<Uni> unis;
    private LayoutInflater layoutInflater;
    private ItemClickInterface itemClickInterface;

    public AdapterListe(Context context){
        layoutInflater = LayoutInflater.from(context);
    }

    public void setUnis(List<Uni> unis) {
        this.unis = unis;
    }

    @NonNull
    @Override
    public Red onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.red_liste,parent,false);
        return new Red(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Red holder, int position) {
        Uni uni = unis.get(position);
        holder.name.setText(uni.getName());
    }

    @Override
    public int getItemCount() {
        /*
        if (osobe==null){
            return 0;
        }else{
            return  osobe.size();
        }
        */
        return unis == null ? 0 : unis.size();
    }

    public class Red extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView name;
        private TextView country;

        public Red(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            country = itemView.findViewById(R.id.country);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(itemClickInterface==null){
                return;
            }
            itemClickInterface.onItemClick(unis.get(getAdapterPosition()));
        }
    }

    public interface ItemClickInterface{
        void onItemClick(Uni uni);
    }

    public void setItemClickInterface(ItemClickInterface itemClickInterface) {
        this.itemClickInterface = itemClickInterface;
    }
}
