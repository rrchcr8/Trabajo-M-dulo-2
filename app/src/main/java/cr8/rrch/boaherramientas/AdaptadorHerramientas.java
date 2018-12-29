package cr8.rrch.boaherramientas;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorHerramientas extends RecyclerView.Adapter<AdaptadorHerramientas.ViewHolderHerramientas> {

    //ArrayList<HerramientaVo> listaHerramientas;
    List<HerramientaVo> listaHerramientas;

    /*public AdaptadorHerramientas(ArrayList<HerramientaVo> listaHerramientas) {
        this.listaHerramientas = listaHerramientas;
    }
    */

    public AdaptadorHerramientas(List<HerramientaVo> listaHerramientas) {
        this.listaHerramientas = listaHerramientas;
    }
    @Override
    public ViewHolderHerramientas onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null, false);
        return new ViewHolderHerramientas(view);
    }

    @Override
    public void onBindViewHolder( ViewHolderHerramientas holder, int position) {
        holder.etNombre.setText(listaHerramientas.get(position).getNombre());
        holder.etPN.setText(listaHerramientas.get(position).getPN());
        holder.etCodigoBoa.setText(listaHerramientas.get(position).getCodigoBoa());
        //holder.foto.setImageResource(listaHerramientas.get(position).getFoto());


       if (listaHerramientas.get(position).getImagen()!=null){
            holder.imagen.setImageBitmap(listaHerramientas.get(position).getImagen());
        } else{
            holder.imagen.setImageResource(R.drawable.logo_letras);

        }


    }

    @Override
    public int getItemCount() {
        return listaHerramientas.size();
    }

    public class ViewHolderHerramientas extends RecyclerView.ViewHolder {
        TextView etNombre, etPN, etCodigoBoa;
        //ImageView  foto;
        ImageView  imagen;

        public ViewHolderHerramientas( View itemView) {
            super(itemView);
            etNombre=(TextView) itemView.findViewById(R.id.idNombre);
            etPN=(TextView) itemView.findViewById(R.id.idPN);
            etCodigoBoa=(TextView) itemView.findViewById(R.id.CodigoBoa);
            //foto=(ImageView) itemView.findViewById(R.id.IdImagen);
            imagen=(ImageView) itemView.findViewById(R.id.IdImagen);

        }
    }
}
