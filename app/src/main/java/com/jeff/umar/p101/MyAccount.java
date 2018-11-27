package com.jeff.umar.p101;


import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.sql.*;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyAccount extends Fragment {
    private MyAccount.OnFragmentInteractionListener mListener;
    private static final String url = "jdbc:mysql://194.168.155.138:3306/test";
    private static final String user = "user";
    private static final String paas = "password";
    private TextView forename,lastname;



    private class MyTask extends AsyncTask<Void, Void,Void>{
        private String fname= "",lname="";
        @Override
        protected Void doInBackground(Void... voids) {

            try {

                // The newInstance() call is a work around for some
                // broken Java implementations

                Class.forName("com.mysql.jdbc.Driver");/// name of the DRiver
                Connection myconnection = DriverManager.getConnection(url, user, paas);// hostname username and password in public varibles

                Statement mystate = myconnection.createStatement();
                String sql = "SELECT * FROM test.users where forename like 'U%'";

                // getting the sql names and id

                final ResultSet myrsult = mystate.executeQuery("SELECT * FROM test.users where forename like 'U%'");/// query command
                myrsult.next();
                fname = myrsult.getString("forename");// collect info from the query
                lname = myrsult.getString(3);
                while (myrsult.next()){
                    System.out.println(myrsult.getString("last_name")+ ","+myrsult.getString("first_name "));
                }


            } catch (ClassNotFoundException e) {
                e.printStackTrace();



            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            lastname.setText(lname);
            forename.setText(fname);
        }
    }









    public MyAccount() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_my_account, container, false);
        forename = (TextView)view.findViewById(R.id.Forname);
        lastname = (TextView)view.findViewById(R.id.lastname);
        Button btnloading = (Button)view.findViewById(R.id.button121);
        btnloading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyTask().execute();
            }
        });



        return view;
    }





    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Classes.OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
            Toast.makeText(context, "Classes", Toast.LENGTH_SHORT).show();
        }


    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
