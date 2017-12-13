package com.developerhaoz.androidtrainingdemo.download;

/**
 * @author Haoz
 * @date 2017/12/12.
 */
public interface DownloadListener {

    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPaused();

    void onCanceled();
}
