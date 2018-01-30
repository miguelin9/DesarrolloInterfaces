package es.vcarmen.actividadtabs3;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private FragmentTabHost tabhost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tabs03);
        tabhost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabhost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        tabhost.addTab(
                tabhost.newTabSpec("tab1").setIndicator("Tab 1", null),
                Fragmento1.class,
                null);

        tabhost.addTab(
                tabhost.newTabSpec("tab2").setIndicator("Tab 2", null),
                Fragmento2.class,
                null);

        tabhost.addTab(
                tabhost.newTabSpec("tab3").setIndicator("Tab 3", null),
                Fragmento3.class,
                null);

    }
}
