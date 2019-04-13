package com.example.dattrinh.a24h;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by DatTrinh on 7/7/2018.
 */

public class WebViewActivity extends AppCompatActivity {
    private WebView webView;
    /*hiện thị dl web, chạy trên trình duyệt, cập nhật*/
    private ProgressDialog progressDialog;
    /*xử lý load*/
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        Intent intent = this.getIntent();
        String link =  intent.getStringExtra(MainActivity.LINK);
        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(false);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon  /*đại dien*/) {
                super.onPageStarted(view, url, favicon);
                //call ngày sau khi chúng ta gọi phương thức loadUrl của WebView. Thường sử dụng cho việc show animation loading tăng trải nghiệm người dùng.

                if (progressDialog == null) {
                    progressDialog = new ProgressDialog(WebViewActivity.this);
                    progressDialog.setMessage("Loading...");
                    progressDialog.show();
                } else {
                    progressDialog.show();
                }
            }

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                //gọi khi WebView bắt đầu kết xuất  và hien thi. Thường sử dụng để kết thúc nhanh
                super.onPageCommitVisible(view, url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                //gọin khi mà WebView đã render toàn bộ trang, load trang thành công.
                super.onPageFinished(view, url);
                progressDialog.dismiss();
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
               // gọi khi có lỗi xảy ra ví dụ như không có mạng, đường dẫn không đúng… Thường
                super.onReceivedError(view, request, error);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
              //  dùng cho việc load lại trang hay xử lý UI (Xử lý để che hình mặc định khi webview bị lỗi)
                super.onReceivedError(view, errorCode, description, failingUrl);
            }
        });
        webView.loadUrl(link);
    }
}
