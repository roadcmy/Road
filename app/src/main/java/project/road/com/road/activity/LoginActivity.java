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
import project.road.com.road.bean.UserInfo;
import project.road.com.road.common.UserManage;
import project.road.com.road.utils.MD5utils;
import project.road.com.road.utils.PrefUtils;
import project.road.com.road.utils.SharedPrefUtility;

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
                Intent intent = new Intent(LoginActivity.this, SigninActivity.class);
                startActivity(intent);
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
                UserInfo userInfo = gson.fromJson(result, UserInfo.class);
                if (userInfo.data.account != null) {
                    UserManage.getInstance().saveUserInfo(LoginActivity.this, userInfo.data.account, userInfo.data.user_id);
                    //保存登录状态
                    SharedPrefUtility.setParam(LoginActivity.this, SharedPrefUtility.IS_LOGIN, true);
                    //保存登录个人信息
                    SharedPrefUtility.setParam(LoginActivity.this, SharedPrefUtility.LOGIN_DATA, result);
                    Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Result resultInfo = gson.fromJson(result, Result.class);
                    Toast.makeText(LoginActivity.this, resultInfo.desc, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                PrefUtils.setBoolean(getApplicationContext(), "is_first_enter", true);
                Toast.makeText(LoginActivity.this, ex.toString(), Toast.LENGTH_SHORT).show();
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

}


