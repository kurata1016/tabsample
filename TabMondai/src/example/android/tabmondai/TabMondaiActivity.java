package example.android.tabmondai;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.Menu;

public class TabMondaiActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab_mondai);

		getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		ActionBar.Tab tab1 = getActionBar().newTab();
		tab1.setText("ê›íË");
		tab1.setIcon(android.R.drawable.ic_menu_add);
		tab1.setTabListener(new TabMondaiListener(new Fragment1()));

		ActionBar.Tab tab2 = getActionBar().newTab();
		tab2.setText("ï\é¶");
		tab2.setIcon(android.R.drawable.ic_menu_info_details);
		tab2.setTabListener(new TabMondaiListener(new Fragment2()));

		getActionBar().addTab(tab1);
		getActionBar().addTab(tab2);
	}

	private class TabMondaiListener implements ActionBar.TabListener {
		private Fragment fragment;

		public TabMondaiListener(Fragment fragment){
			this.fragment = fragment;
		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			ft.add(R.id.ll_tab, fragment);
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			ft.remove(fragment);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_tab_mondai, menu);
		return true;
	}

}
