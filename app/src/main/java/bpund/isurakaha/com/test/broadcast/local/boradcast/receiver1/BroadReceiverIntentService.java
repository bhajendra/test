package bpund.isurakaha.com.test.broadcast.local.boradcast.receiver1;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

public class BroadReceiverIntentService extends IntentService {
    public static final String CUSTOM_ACTION = "intent.action.BroadReceiverIntentService";
    
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     *
     */
    public BroadReceiverIntentService() {
        super("bhajendra");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

      /*  Intent intent1 = new Intent(CUSTOM_ACTION);
        intent1.putExtra("dates", new Date().toString());
        LocalBroadcastManager.getInstance(BroadReceiverIntentService.this).sendBroadcast(intent1);
        Log.d("BroadReceiverService", "send from service" +intent1.getStringExtra("dates"));*/

    }
}
