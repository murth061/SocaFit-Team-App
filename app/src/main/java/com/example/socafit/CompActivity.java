//package com.example.socafit;
//
//import android.os.Bundle;
//
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//
//
//import java.util.ArrayList;
//import java.util.List;
//public class CompActivity extends AppCompatActivity {
//    // A list to store the competitions
//    List<CompetitionList> compList;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        System.out.println("Hello?");
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_comp);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        System.out.println("Hello?");
//
////        val v = LayoutInflater.from(parent.context).inflate(R.layout.fragment_comp, parent, false)
//        //getting the recyclerview from xml
//        RecyclerView recyclerview_dwu = findViewById(R.id.recyclerview_dwu);
//        recyclerview_dwu.setHasFixedSize(true);
//        recyclerview_dwu.setLayoutManager(new LinearLayoutManager(this));
//
//        //initializing the productlist
//        compList = new ArrayList<>();
//
//
//        //adding some items to our list
//        compList.add(
//                new CompetitionList(
//                        1,
//                        "Run Your Heart Out!",
//                        "Compete against other runners every week!",
//                        "04/13-04/19",
//                        R.drawable.run_icon));
//
//        compList.add(
//                new CompetitionList(
//                        2,
//                        "Slow and Steady!",
//                        "Compete for distance against runners every month!",
//                        "04/01-04/30",
//                        R.drawable.run_icon));
//
//        compList.add(
//                new CompetitionList(
//                        3,
//                        "Lift em weights!",
//                        "Compete against others to flex your strength!",
//                        "04/01-04/12",
//                        R.drawable.trophy_icon));
//
//        //creating recyclerview adapter
//        CompetitionListAdapter adapter = new CompetitionListAdapter(this, compList, );
//
//        //setting adapter to recyclerview
//        recyclerview_dwu.setAdapter(adapter);
//
//
//    }
//
//}
