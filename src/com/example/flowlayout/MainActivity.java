package com.example.flowlayout;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private String[] mVals = new String[] { "Hello", "Android", "Weclome Hi ",
			"Button", "TextView", "Hello", "Android", "Weclome",
			"Button ImageView", "TextView", "Helloworld", "Android",
			"Weclome Hello", "Button Text", "TextView" };
	private TagFlowLayout mFlowLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mFlowLayout = (TagFlowLayout) findViewById(R.id.id_flowlayout);

		findViewById(R.id.vvvv).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, Main1Activity.class);
				startActivity(intent);
			}
		});
		
		
		mFlowLayout.setAdapter(new TagAdapter<String>(mVals) {

			@Override
			public View getView(FlowLayout parent, int position, String t) {
				TextView tv = (TextView) LayoutInflater.from(MainActivity.this)
						.inflate(R.layout.tv, mFlowLayout, false);
				tv.setText(t);
				return tv;
			}

		});
		
		
		mFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener()
        {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent)
            {
                Toast.makeText(MainActivity.this, mVals[position], Toast.LENGTH_SHORT).show();
                //view.setVisibility(View.GONE);
                return true;
            }
        });
		

	}

}
