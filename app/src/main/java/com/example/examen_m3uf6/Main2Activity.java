package com.example.examen_m3uf6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main2Activity extends AppCompatActivity {

    Button apply;

    EditText title, sitio, fecha, mail, room, precio, aforo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        apply = findViewById(R.id.btn_aply);
        title = findViewById(R.id.camp_title);
        sitio = findViewById(R.id.camp_lugar);
        fecha = findViewById(R.id.camp_date);
        mail = findViewById(R.id.camp_mail);
        room = findViewById(R.id.camp_room);
        precio = findViewById(R.id.camp_precio);
        aforo = findViewById(R.id.camp_aforo);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subirThread.start();
                subirThread.interrupt();
            }
        });


    }

    Thread subirThread = new Thread(){

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


                String sql = "INSERT INTO EventDetail values("+title.getText().toString()+", ‘02/28/2020’, ‘INS JdA’, ‘jda@jda.org’, ‘Aula 39’, 50, 20, ‘Examen ABP de M3, M6, M8 i M9’);";

                Statement st = conn.createStatement();
                ResultSet srs = st.executeQuery(sql);


                srs.close();
                st.close();
                conn.close();



            }catch (SQLException se){
                se.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    };
}
