package com.example.welcomedemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;


public class WelcomeActivity extends ActionBarActivity {

	private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        sp = getSharedPreferences("config", MODE_PRIVATE);
		Editor editor = sp.edit();
		if (sp.getString("first", "").equals("")) {
			//���ε�½
			editor.putString("first", "yes");
			editor.commit();
			startActivity(new Intent(this, FirstTimeActivity.class));
		}else{
			setContentView(R.layout.activity_welcome);
			toMainActivity();
		}
        
    }


    private void toMainActivity() {
		// TODO �Զ����ɵķ������
    	new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
				}
				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
						finish();
					}
				});
			}
		}).start();
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.welcome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
