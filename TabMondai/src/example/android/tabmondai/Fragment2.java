package example.android.tabmondai;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Fragment2 extends Fragment {

	private static final String FILE_NAME = "TabMondai";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment2, container, false);
	}

	@Override
	public void onStart() {
		super.onStart();

		TableLayout tablelayout = (TableLayout) getActivity().findViewById(R.id.tl_tab2);
		tablelayout.removeAllViews();
		tablelayout.setStretchAllColumns(true);

		TextView headtxt1 = new TextView(getActivity());
		headtxt1.setText("è§ïiñº");
		headtxt1.setGravity(Gravity.CENTER_HORIZONTAL);
		headtxt1.setWidth(100);
		TextView headtxt2 = new TextView(getActivity());
		headtxt2.setText("âøäi");
		headtxt2.setGravity(Gravity.CENTER_HORIZONTAL);
		headtxt2.setWidth(60);
		TableRow headrow = new TableRow(getActivity());
		headrow.addView(headtxt1);
		headrow.addView(headtxt2);
		tablelayout.addView(headrow);

		try {
			FileInputStream stream = getActivity().openFileInput(FILE_NAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(stream));

			String line = "";
			while ((line = in.readLine()) != null) {
				String lineSplit[] = line.split(",");

				TextView nametxt = new TextView(getActivity());
				nametxt.setGravity(Gravity.CENTER_HORIZONTAL);
				nametxt.setText(lineSplit[0]);
				TextView pricetxt = new TextView(getActivity());
				pricetxt.setGravity(Gravity.CENTER_HORIZONTAL);
				pricetxt.setText(lineSplit[1]);

				TableRow row = new TableRow(getActivity());
				row.addView(nametxt);
				row.addView(pricetxt);
				tablelayout.addView(row);
			}
			in.close();
		} catch (Exception e) {
			Log.e("ERROR", "file accsess error");
		}
	}
}
