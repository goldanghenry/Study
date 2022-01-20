package com.example.exam

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_async.*
import java.lang.Exception

class AsyncActivity : AppCompatActivity() {
    var task : BackgroundAsyncTask? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)


        start.setOnClickListener {
            task = BackgroundAsyncTask(progressbar, ment)
            task?.execute()
        }
        stop.setOnClickListener {
            task?.cancel(true)
        }

    }

    override fun onPause() {
        task?.cancel(true)
        super.onPause()
    }
}

class BackgroundAsyncTask (
    val progressbar : ProgressBar,
    val progressText : TextView
    ) : AsyncTask <Int, Int, Int>() { //<오버라이드 첫번째, 두번째, 세번 째 인수)
        // params -> doInBackground 에서 사용할 타입
        // progress -> onProgressUpdate 에서 사용할 타입
        // result -> onPostExecute 에서 사용할 타입
    var percent:Int = 0

    // implement
    override fun onPreExecute() {
        percent = 0
        progressbar.setProgress(percent)
    }

    override fun doInBackground(vararg params: Int?): Int {
        while(isCancelled() == false) { //isCancelled  완료되기전에 캔슬이 되었는지 안되었는지
            percent++
            if(percent>100) {
                break
            } else {
                publishProgress(percent)
            }
            try {
                Thread.sleep(100)
            }catch(e:Exception) {
                e.printStackTrace()
            }
        }
        return percent
    }

    override fun onProgressUpdate(vararg values: Int?) { // values는 바로 위의 percent값
        progressbar.setProgress(values[0] ?: 0) // null인 경우 0
        progressText.setText("퍼센트 :" +values[0])
        super.onProgressUpdate(*values)

    }

    override fun onPostExecute(result: Int?) {
        progressText.setText("작업이 완료되었습니다.")
    }

    override fun onCancelled() {
        progressbar.setProgress(0)
        progressText.setText("작업이 취소되었습니다.")
        super.onCancelled()
    }
}