package com.example.hangman.executor;


import android.os.Handler;
import android.os.Looper;

/**
 * 主线程 ，持有一个主线程的handler
 */
public class UIThread implements PostExecutionThread {

  private static class LazyHolder {
    private static final UIThread INSTANCE = new UIThread();
  }

  public static UIThread getInstance() {
    return LazyHolder.INSTANCE;
  }

  private final Handler handler;

  private UIThread() {
    this.handler = new Handler(Looper.getMainLooper());
  }

  /**
   * Causes the Runnable r to be added to the message queue.
   * The runnable will be run on the main thread.
   *
   * @param runnable {@link Runnable} to be executed.
   */
  @Override public void post(Runnable runnable) {
    handler.post(runnable);
  }
}

