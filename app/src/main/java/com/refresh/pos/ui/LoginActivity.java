package com.refresh.pos.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.refresh.pos.R;
import com.refresh.pos.config.Global;
import com.refresh.pos.domain.LanguageController;
import com.refresh.pos.network.CreHttpRequest;
import java.util.HashMap;
import java.util.Locale;

/**
 * This is the login activity page.
 *
 * @author Refresh Team
 *
 */
public class LoginActivity extends Activity implements CreAbsActivity {

	private Button loginButton;
	private EditText emailText;
	private EditText passwdText;

	private void setLanguage(String localeString) {
		Locale locale = new Locale(localeString);
		Locale.setDefault(locale);
		Configuration config = new Configuration();
		config.locale = locale;
		getBaseContext().getResources().updateConfiguration(config,
				getBaseContext().getResources().getDisplayMetrics());
	}

	@SuppressLint("MissingSuperCall")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		CreHttpRequest._context = this;
		initiateUI(savedInstanceState);
		setLanguage(LanguageController.getInstance().getLanguage());
	}

	private void login() {
		String email = emailText.getText().toString().trim();
		String passwd = passwdText.getText().toString().trim();
		if (email.isEmpty()) {
			Toast.makeText(this, R.string.error_email_required, Toast.LENGTH_LONG).show();
			return;
		} else if (passwd.isEmpty()) {
			Toast.makeText(this, R.string.error_email_required, Toast.LENGTH_LONG).show();
			return;
		}

		HashMap<String, String> params = new HashMap<>();
		params.put("method", "login");
		params.put("username", email);
		params.put("password", passwd);
		CreHttpRequest.doHttpPost(Global._pserverUrl, params,this);
	}

	private void initiateUI(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_login);
		loginButton = findViewById(R.id.loginButton);
		loginButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				login();
			}

		});

		emailText = findViewById(R.id.emailText);
		passwdText = findViewById(R.id.passwdText);
	}

	@Override
	public int onRequestSuccess(String code, String msg) {
		Global._papiKey = msg;
		Intent newActivity = new Intent(LoginActivity.this, MainActivity.class);
		startActivity(newActivity);
		LoginActivity.this.finish();
		return 0;
	}

	@Override
	public int onRequestFail(String code, String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
		return 0;
	}

	@Override
	public void showProgress(boolean bshow) {

	}
}

