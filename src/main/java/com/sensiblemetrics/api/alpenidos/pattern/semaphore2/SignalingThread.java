package com.sensiblemetrics.api.alpenidos.pattern.semaphore2;

public class SignalingThread extends Thread {

	private int type;

	public final static int TYPE_A = 1;

	public final static int TYPE_B = 0;

	public SignalingThread(final int type) {
		this.type = type;
	}

	public void run() {
		//As you always want a() to be called first, the thread that calls it releases the permit after calling a.
		if(type == TYPE_A) {
			Signaling.a();
			Signaling.semaphore.release();
		}
		if(type == TYPE_B) {
			Signaling.semaphore.acquire();
			Signaling.b();
		}
	}
}
