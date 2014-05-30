package example.android.tabmondai;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Fragment1 extends Fragment {

	private static final String FILE_NAME = "TabMondai";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment1, container, false);
	}

	@Override
	public void onStart() {
		super.onStart();

		Button button1 = (Button) getActivity().findViewById(R.id.bt_add);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String name = ((EditText) getActivity().findViewById(R.id.et_name)).getText()
						.toString();
				String price = ((EditText) getActivity().findViewById(R.id.et_price)).getText()
						.toString();

				try {
					FileOutputStream stream = getActivity().openFileOutput(FILE_NAME,
							Context.MODE_APPEND);
					BufferedWriter out = new BufferedWriter(new OutputStreamWriter(stream));
					out.write(name + "," + price);
					out.newLine();
					out.close();

					Toast.makeText(getActivity(), "ファイルに書き込みました", Toast.LENGTH_SHORT).show();
				} catch (Exception e) {
					Log.e("ERROR", "ファイル書き込みに失敗しました");
				}
			}
		});
	}
}
