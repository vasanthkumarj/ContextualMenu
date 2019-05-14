package com.vasanthkumarj15.contextualmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toolbar t;
    private Button b;
    private ActionMode actionMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=findViewById(R.id.contextToolbar);
        b=findViewById(R.id.click);
        t.setTitle("Contextual Menu");
        t.setSubtitle("by vas");

        t.inflateMenu(R.menu.menu_main);
        t.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                String s= (String) menuItem.getTitle();
                Toast.makeText(MainActivity.this,s+" Clicked",Toast.LENGTH_SHORT).show();
                return true;
            }
        });



    }

    public void changeMenu(View view) {
        actionMode=MainActivity.this.startActionMode(new CallMenu());
    }



    class CallMenu implements ActionMode.Callback {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.menu_context,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            actionMode.setTitle("Context Title");
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem item) {

            String s= (String) item.getTitle();
            Toast.makeText(MainActivity.this,s+" selected",Toast.LENGTH_SHORT).show();
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {

        }
    }


}
