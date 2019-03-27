package com.example.apitest;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.info.ContactInfo;
import com.example.adapter.RecyclerViewAdapte;
import com.example.adapter.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemSelectedListener {

    private Spinner spinner_toolbar;
    private RecyclerView recyclerView;
    List<ContactInfo> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInfo();
        init();


    }

    /*初始化*/
    private void init(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        spinner_toolbar = (Spinner) findViewById(R.id.SpinnerToolbar);
        final List<String> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            datas.add("项目" + i);
        }
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(this);
        spinner_toolbar.setAdapter(spinnerAdapter);
        spinnerAdapter.setDatas(datas);
        spinner_toolbar.setOnItemSelectedListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.card_list);
        /*设置等高*/
        recyclerView.setHasFixedSize(true);
        /*创建一个LinearLayoutManager*/
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        /*得到的layoutManager，并设置纵向排列*/
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapte recyclerViewAdapte = new RecyclerViewAdapte(mList);
        recyclerView.setAdapter(recyclerViewAdapte);
}

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /*spinner_toolbar选中*/
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String s = spinner_toolbar.getSelectedItem().toString();
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
    }

    /*spinner_toolbar未选中*/
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    private void initInfo() {

//        测试数据
        ContactInfo element1 = new ContactInfo("小明", "西门", "feverdg@icloud.com");
        mList.add(element1);
        ContactInfo element2 = new ContactInfo("小红", "南宫", "146793455@icloud.com");
        mList.add(element2);
        ContactInfo element3 = new ContactInfo("小九九", "欧阳", "17987453@icloud.com");
        mList.add(element3);
        ContactInfo element4 = new ContactInfo("小九九", "欧阳", "17987453@icloud.com");
        mList.add(element4);
        ContactInfo element5 = new ContactInfo("小九九", "欧阳", "17987453@icloud.com");
        mList.add(element5);
        ContactInfo element6 = new ContactInfo("小九九", "欧阳", "17987453@icloud.com");
        mList.add(element6);
        ContactInfo element7 = new ContactInfo("小明", "西门", "feverdg@icloud.com");
        mList.add(element7);
        ContactInfo element8 = new ContactInfo("小红", "南宫", "146793455@icloud.com");
        mList.add(element8);
        ContactInfo element9 = new ContactInfo("小九九", "欧阳", "17987453@icloud.com");
        mList.add(element9);
        ContactInfo element10 = new ContactInfo("小九九", "欧阳", "17987453@icloud.com");
        mList.add(element10);
        ContactInfo element11 = new ContactInfo("小九九", "欧阳", "17987453@icloud.com");
        mList.add(element11);
        ContactInfo element12 = new ContactInfo("小九九", "欧阳", "17987453@icloud.com");
        mList.add(element12);
    }
}
