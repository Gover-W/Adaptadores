package com.example.adaptadores.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adaptadores.MainActivity3;
import com.example.adaptadores.R;
import com.example.adaptadores.clase.Usuario;
import com.squareup.picasso.Picasso;

import java.util.List;
public class UsuarioAdaptador extends RecyclerView.Adapter<UsuarioAdaptador.ViewHolder> {

    private List<Usuario> datos;

    public UsuarioAdaptador(List<Usuario> datos){
        this.datos = datos;
    }

    @NonNull
    @Override
    public UsuarioAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioAdaptador.ViewHolder holder, int position) {
        Usuario dato = datos.get(position);
        holder.bind(dato);

        holder.btn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = holder.itemView.getContext();
                Intent intent = new Intent(context, MainActivity3.class);
                intent.putExtra("nombre", dato.getNombre());
                intent.putExtra("genero", dato.getGenero());
                intent.putExtra("imagen", dato.getImagen());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_nombre_usuario,txt_curso_usuario;
        Button btn_more;
        ImageView img_usuario;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            txt_nombre_usuario = itemView.findViewById(R.id.txt_nombre_usuario);
            txt_curso_usuario = itemView.findViewById(R.id.txt_curso_usuario);
            img_usuario = itemView.findViewById(R.id.img_usuario);
            btn_more = itemView.findViewById(R.id.btn_more);
        }

        public void bind(Usuario dato){
            txt_nombre_usuario.setText(dato.getNombre());
            txt_curso_usuario.setText(dato.getGenero());
            //imagen libreria
            Picasso.get().load(dato.getImagen()).into(img_usuario);
        }
    }
}
