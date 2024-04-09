package com.college.demo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    final String TAG = "hjk";
    Button myBtn;
    Button btnPay;
    CheckBox chkCream;
    CheckBox chkSugar;
    RadioGroup radCoffeeType;
    TextView longPressTv;
    MainFragment mainFragment;
    MenuFragment menuFragment;
    WebView browser;
    ListView listView;
    Button changeDataBtn;
    TextView spinnerTv;
    Spinner spinner;
    String[] items = {"mike",  "angel", "crow", "john", "ginnie", "sally", "cohen", "rice"};
    Button spinnerRefreshBtn;
    /**
     * requestCode는 처음 startActivityForResult에서 설정한 1이 넘어오고
     * resultCode는 RESULT_OK 넘어옴
     * requestCode, resultCode를 활용해, switch문으로 다른 화면에서 넘어오는 데이터 구분
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String outName = data.getStringExtra("name");
        Toast.makeText(this, "전달 받은 name값: " + outName, Toast.LENGTH_LONG).show();
        /**
         * this: 객체를 대신함 : 객체의 이름은 알 수 없음
         * 여기서 this는 AppCompatActivity의 객체임
         * method: 객체로 부르는 매소드가 있고 클래스로 부르는 메소드(static) 두가지가 있음
         */
    }

    LinearLayout container;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "In the onStart() event");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "In the onRestart() event");

    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "In the onResume() event");
        updateTime();

    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "In the onPause() event");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "In the onStop() event");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "In the onDestroy() event");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2024.03.12
        container = (LinearLayout) findViewById(R.id.container);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.sub1, container, true); //container에 sub1을 붙여주기

                CheckBox checkBox = (CheckBox) container.findViewById(R.id.checkBox); //container로 찾는 범위를 한정
                checkBox.setText("로딩되었어요.");
            }
        });


        //2024.03.19
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);

        //View.OnClickListener : 익명(Anonymous) 클래스 -> 객체를 한개만 생성
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01010001000"));
                startActivity(intent);
            }
        });

        Button btnNew = (Button) findViewById(R.id.btn_new);
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                startActivityForResult(intent, 1);
                //Toast.makeText(this, "전달 받은 name값: ", Toast.LENGTH_LONG).show();
                //여기 toast의 this는 OnClickListener의 객체임
            }
        });
        Log.d(TAG, "In the onCreate() event");


        //2024.03.26
        myBtn = (Button)findViewById(R.id.myBtn);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTime();
            }
        });

        //2024.03.28
        chkSugar = (CheckBox)findViewById(R.id.chkSugar);
        chkCream = (CheckBox)findViewById(R.id.chkCream);
        btnPay = (Button)findViewById(R.id.btnPay);
        chkSugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chkSugar.isChecked()){
                    Log.d(TAG, "sugar가 체크");
                }else{
                    Log.d(TAG, "sugar가 체크해제");
                }
            }
        });
        /**핸들러는 등록한 순서의 역순으로 작동함
        따라서 checkedChange가 먼저 실행됨**/
        chkCream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chkCream.isChecked()){
                    Log.d(TAG, "cream이 체크");
                }else{
                    Log.d(TAG, "cream이 체크해제");
                }
            }
        });
        chkCream.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Log.d(TAG, "dcream이 체크");
                }else{
                    Log.d(TAG, "dcream이 체크해제");
                }
            }
        });
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "Coffee ";
                if (chkCream.isChecked()){
                    msg += " & cream ";
                }
                if (chkSugar.isChecked()){
                    msg += " & Sugar";
                }
                Toast.makeText(getApplicationContext(), msg,
                        Toast.LENGTH_SHORT).show();
            }
        });

        radCoffeeType = (RadioGroup)findViewById(R.id.radGroupCoffeeType);
        radCoffeeType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d(TAG, "radio : id "+ checkedId);
                if(checkedId == R.id.radDecaf){
                    Log.d(TAG, "Decof 선택 ");
                } else if (checkedId == R.id.radExpresso) {
                    Log.d(TAG, "Expresso 선택 ");
                } else if (checkedId == R.id.radColombian) {
                    Log.d(TAG, "Colombian 선택 ");
                }
            }
        });


        //24.04.2
        longPressTv = (TextView) findViewById(R.id.longPress_tv);
        registerForContextMenu(longPressTv); //현재 뷰가 컨텍스트 메뉴가 동작하는 뷰로 설정하기 위해서

        mainFragment = new MainFragment();
        menuFragment = new MenuFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main_container, mainFragment)
                .commit();


        //24.04.04
        String[] names = {"LEE", "CHOI", "KIM", "JEONG", "RHO"};
        listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        listView.setAdapter(adapter);

//        String[] numbers = {"1","2","3","4","5"};
        Integer[] numbers = {1,2,3,4,5};
        changeDataBtn = (Button) findViewById(R.id.changeDataBtn);
        changeDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, numbers);
                ArrayAdapter<Integer> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, numbers);
                listView.setAdapter(adapter);
            }
        });

        //2024.04.09
        spinnerTv = (TextView) findViewById(R.id.spinner_tv);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, items
        );
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerTv.setText(items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinnerTv.setText("");
            }
        });

        spinnerRefreshBtn = (Button) findViewById(R.id.spinner_refresh_btn);
        spinnerRefreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items = new String[] {"1", "2", "3", "4"};
                ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                        getApplicationContext(), android.R.layout.simple_spinner_item, items
                );
                spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(spinnerAdapter);
            }
        });
    }








    private void updateTime(){
        myBtn.setText(new Date().toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.game_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override //메뉴 이벤트 핸들러
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Handle item selection
        if(item.getItemId() == R.id.new_game){
            newGame();
            return true;
        } else if (item.getItemId() == R.id.help){
            showHelp();
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }



    private void newGame(){
        Toast.makeText(this, "new_game 메뉴가 선택됨", Toast.LENGTH_LONG);
    }
    private void showHelp(){
        Toast.makeText(this, "help 메뉴가 선택됨", Toast.LENGTH_LONG);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //title은 icon도 가능
        menu.setHeaderTitle("Choose a color");
        //add menu
        menu.add(0, v.getId(), 0, "Yellow");
        menu.add(0, v.getId(), 0, "Gray");
        menu.add(0, v.getId(), 0, "Cyan");
    }



    //context menu item select listener
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getTitle() == "Yellow"){
            longPressTv.setBackgroundColor(Color.YELLOW);
        } else if (item.getTitle() == "Gray"){
            longPressTv.setBackgroundColor(Color.GRAY);
        } else if (item.getTitle() == "Cyan"){
            longPressTv.setBackgroundColor(Color.CYAN);
        }
        return true;
//        return super.onContextItemSelected(item);
    }

    public void onFragmentChanged(int index){
        if(index == 0)
            getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_container, menuFragment).commit();
        else if(index == 1)
            getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_container, mainFragment).commit();
    }
}