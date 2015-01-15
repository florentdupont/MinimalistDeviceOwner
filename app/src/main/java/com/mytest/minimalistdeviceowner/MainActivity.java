package com.mytest.minimalistdeviceowner;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;


public class MainActivity extends Activity {

    CheckBox deviceOwnerAppChk;
    CheckBox profileOwnerAppChk;
    CheckBox adminAppChk;
    Button unsetDeviceOwnerAppBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deviceOwnerAppChk = (CheckBox) findViewById(R.id.device_owner_app);
        profileOwnerAppChk = (CheckBox) findViewById(R.id.profile_owner_app);
        adminAppChk = (CheckBox) findViewById(R.id.admin_app);
        unsetDeviceOwnerAppBtn = (Button) findViewById(R.id.unset_device_owner_btn);

        unsetDeviceOwnerAppBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unsetDeviceOwnerApp();
            }
        });

        refreshStatusDisplay();
    }

    private void unsetDeviceOwnerApp() {
        DevicePolicyManager dpm = (DevicePolicyManager) this.getSystemService(Context.DEVICE_POLICY_SERVICE);

        dpm.clearDeviceOwnerApp(getPackageName());

        refreshStatusDisplay();
    }

    private void refreshStatusDisplay() {
        DevicePolicyManager dpm = (DevicePolicyManager) this.getSystemService(Context.DEVICE_POLICY_SERVICE);
        ComponentName deviceAdminReceiver = new ComponentName(this, DeviceAdminRcvr.class);

        deviceOwnerAppChk.setChecked(dpm.isDeviceOwnerApp(getPackageName()));
        profileOwnerAppChk.setChecked(dpm.isProfileOwnerApp(getPackageName()));
        adminAppChk.setChecked(dpm.isAdminActive(deviceAdminReceiver));
    }


}
