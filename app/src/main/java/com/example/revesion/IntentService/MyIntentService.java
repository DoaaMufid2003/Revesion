package com.example.revesion.IntentService;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;
//intent server لا يستخدم في الموسيقي انما يستخدم لارسال واستقبال البيانات
//بعمل distroy من غير ما اوقفو بعد ما يخلص من الكود الي في handler بستدعي ال distroy
/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {

    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.example.revesion.IntentService.action.FOO";
    private static final String ACTION_BAZ = "com.example.revesion.IntentService.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.example.revesion.IntentService.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.example.revesion.IntentService.extra.PARAM2";

    public MyIntentService() {
        super("MyIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("tag","create");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        for (int i = 0; i < 1000000; i++) {
            if (i%1000==0){
//                Log.d("tag", String.valueOf(i));
            }
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("tag","Destrory");
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}