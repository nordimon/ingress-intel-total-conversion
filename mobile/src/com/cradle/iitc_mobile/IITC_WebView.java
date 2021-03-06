package com.cradle.iitc_mobile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.GeolocationPermissions;

@SuppressLint("SetJavaScriptEnabled")
public class IITC_WebView extends WebView {

	private WebSettings settings;
	private IITC_WebViewClient webclient;

	// init web view
	private void iitc_init() {
		settings = this.getSettings();
		settings.setJavaScriptEnabled(true);
		settings.setDomStorageEnabled(true);
		settings.setAllowFileAccess(true);
		settings.setGeolocationEnabled(true);

		// our webchromeclient should share geolocation with the iitc script
		// allow access by default
		this.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
				callback.invoke(origin, true, false);
			}
		});

		webclient = new IITC_WebViewClient();
		this.setWebViewClient(webclient);
	}

	// constructors -------------------------------------------------
	public IITC_WebView(Context context) {
		super(context);

		iitc_init();
	}

	public IITC_WebView(Context context, AttributeSet attrs) {
		super(context, attrs);

		iitc_init();
	}

	public IITC_WebView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		iitc_init();
	}
	//----------------------------------------------------------------

}
