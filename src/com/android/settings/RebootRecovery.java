/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.os.Bundle;
import android.util.Log;
import android.app.Fragment;

import java.io.DataOutputStream;
import java.io.IOException;


public class RebootRecovery extends Fragment {
    private static final String TAG = "RebootRecovery";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

                Process mExe = null;
                try {
                    mExe = Runtime.getRuntime().exec("su");
                    DataOutputStream out = new DataOutputStream(mExe.getOutputStream());
                    out.writeBytes("setprop sys.powerctl reboot,recovery"+"\n");
                    out.flush();
                } catch (IOException e) {
                }
    }

}
