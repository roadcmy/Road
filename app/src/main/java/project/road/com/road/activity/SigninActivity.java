package project.road.com.road.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import project.road.com.road.utils.MD5utils;

public class SigninActivity extends AppCompatActivity {



    @Bind(R.id.et_account)
    EditText et_account;
    @Bind(R.id.et_password)
    EditText et_password;
    @Bind(R.id.register)
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        ButterKnife.bind(this);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(et_account.getText())) {
                    Toast.makeText(SigninActivity.this,
                            R.string.account_can_not_be_empty,
                            Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(et_password.getText())) {
                    Toast.makeText(SigninActivity.this,
                            R.string.password_can_not_be_empty,
                            Toast.LENGTH_LONG).show();
                    return;
                } else {
                    signIn(et_account.getText().toString(), MD5utils.md5(et_password.getText().toString()));//
                }
            }
        });

    }
    private void signIn(String account, String password) {
        RequestParams params = new RequestParams("http://14g97976j3.51mypc.cn:10759/my/createUser");
        params.addParameter("account", account);
        params.addParameter("password", password);
        x.http().post(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                UserInfo userInfo = gson.fromJson(result, UserInfo.class);
                if(userInfo.code == 201){
                    //成功
                    Toast.makeText(
                            SigninActivity.this,
                            "注册成功",
                            Toast.LENGTH_LONG)
                            .show();
                    finish();

                }
            }


            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                //失败
                Toast.makeText(
                        SigninActivity.this,
                        "注册失败",
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

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });
    }
}
