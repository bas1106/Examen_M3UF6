package com.example.examen_m3uf6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lista;

    Button add, edit, carga;

    ArrayList<Evento> evList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carga = findViewById(R.id.btn_carga);

        add = findViewById(R.id.btn_add);
        edit = findViewById(R.id.btn_editar);

        lista = findViewById(R.id.listview1);

        evList = new ArrayList<>();

        llenarListaThread.start();
        llenarListaThread.interrupt();

        System.out.println("Esto va asi "+ evList.size());

        EvAdapter evAdapter = new EvAdapter(getApplicationContext(), evList);
        lista.setAdapter(evAdapter);


    }

    Thread llenarListaThread = new Thread(){

        @Override
        public void run() {

                try{

                    Class.forName("org.postgresql.Driver");
                    final Connection conn = DriverManager.getConnection(
                            "jdbc:postgresql://192.168.0.22:5432/esdeveniments", "carol", "shaw");

                    if (conn != null) {
                        System.out.println("Connected to the database!");
                        Log.w("Error1","if true");
                    } else {
                        System.out.println("Failed to make connection!");
                        Log.w("Error1","if false");
                    }


                    Statement st = conn.createStatement();
                    ResultSet srs = st.executeQuery("SELECT * FROM eventdetail");
                    while (srs.next()) {
                        Evento ev = new Evento();
                        ev.setTitle(srs.getString(1));
                        ev.setDateAux(srs.getDate(2).toString());
                        ev.setPlace(srs.getString(3));
                        ev.setEmail(srs.getString(4));
                        ev.setRoom(srs.getString(5));
                        ev.setPrice(srs.getInt(6));
                        ev.setPeople(srs.getInt(7));
                        ev.setDescription(srs.getString(8));
                        System.out.println(ev.getTitle());
                        evList.add(ev);

                    }

                    srs.close();
                    st.close();
                    conn.close();

                    System.out.println("Esto va asi "+ evList.size());


                }catch (SQLException se){
                    se.printStackTrace();
                }catch (Exception e){
                    e.printStackTrace();
                }

        }

    };

}
