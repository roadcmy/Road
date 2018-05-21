package project.road.com.road.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.Bind;
import butterknife.ButterKnife;
import project.road.com.road.R;
import project.road.com.road.bean.Result;
import project.road.com.road.common.UserManage;
import project.road.com.road.utils.MD5utils;
import project.road.com.road.utils.PrefUtils;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.account)
    EditText account;
    @Bind(R.id.password)
    EditText password;
    @Bind(R.id.btnLogin)
    Button btnLogin;
    @Bind(R.id.btnRegister)
    Button btnRegister;

    LinearLayout pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        pic = (LinearLayout) findViewById(R.id.pic);

        //注册
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(account.getText())) {
                    Toast.makeText(LoginActivity.this,
                            R.string.account_can_not_be_empty,
                            Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(password.getText())) {
                    Toast.makeText(LoginActivity.this,
                            R.string.password_can_not_be_empty,
                            Toast.LENGTH_LONG).show();
                    return;
                } else {
                    signIn(account.getText().toString(),MD5utils.md5(password.getText().toString()));//
                }
            }
        });

        //登陆
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(account.getText())) {
                    Toast.makeText(LoginActivity.this,
                            R.string.account_can_not_be_empty,
                            Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(password.getText())) {
                    Toast.makeText(LoginActivity.this,
                            R.string.password_can_not_be_empty,
                            Toast.LENGTH_LONG).show();
                    return;
                } else {
                    login(account.getText().toString(), MD5utils.md5(password.getText().toString()));
                }
            }
        });
    }



    private void login(final String account, final String password) {
        RequestParams params = new RequestParams("http://14g97976j3.51mypc.cn:10759/my/userLogin");
        params.addParameter("account", account);
        params.addParameter("password", password);
        x.http().post(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Result resultInfo = gson.fromJson(result, Result.class);
                if(resultInfo.code == 200){
                    UserManage.getInstance().saveUserInfo(LoginActivity.this, account, password);
                    Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, resultInfo.desc, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                PrefUtils.setBoolean(getApplicationContext(), "is_first_enter", true);
                Toast.makeText(LoginActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(CancelledException cex) {
                PrefUtils.setBoolean(getApplicationContext(), "is_first_enter", true);
                Toast.makeText(LoginActivity.this, "取消登陆", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });
    }

    private void signIn(final String account, final String password) {
        RequestParams params = new RequestParams("http://14g97976j3.51mypc.cn:10759/my/createUser");
        params.addParameter("account", account);
        params.addParameter("password", password);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Result resultInfo = gson.fromJson(result, Result.class);
                if(resultInfo.code == 201){
                    Toast.makeText(LoginActivity.this, "注册成功",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this, resultInfo.desc.toString(),
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                //失败
                Toast.makeText(LoginActivity.this, "注册失败",
                        Toast.LENGTH_LONG)
                        .show();
                finish();
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

        });
    }



}


