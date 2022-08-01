package com.example.exam

import android.app.DownloadManager
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_henrystagram_upload.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class HenrystagramUploadActivity : AppCompatActivity() {

    lateinit var filePath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_henrystagram_upload)
        CheckedPermission()

        view_pictures.setOnClickListener {
            getPicture()
        }
        upload_post.setOnClickListener {
            uploadPost()
        }
        all_list.setOnClickListener {
            startActivity(Intent(this, HenrystagramPostListActivity::class.java))
        }
        my_list.setOnClickListener {
            startActivity(Intent(this, HenrystagramMyPostListActivity::class.java))
        }
        user_info.setOnClickListener {
            startActivity(Intent(this, HenrystagramUserInfo::class.java))
        }
    }

    fun CheckedPermission() {
        val cameraPermissionCheck = ContextCompat.checkSelfPermission(
            this@HenrystagramUploadActivity,
            android.Manifest.permission.CAMERA
        )
        if (cameraPermissionCheck != PackageManager.PERMISSION_GRANTED) {
            // 권한이 없는 경우
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.CAMERA),
                1000
            )
            Log.d("permission", "권한이 없다")
        }

        val storagePermissionCheck = ContextCompat.checkSelfPermission(
            this@HenrystagramUploadActivity,
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        )

        if (storagePermissionCheck != PackageManager.PERMISSION_GRANTED) {
            // 권한이 없는 경우
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                1000
            )
            Log.d("permission", "권한이 없다")
        }
    }
    fun getPicture() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI) // 외부저장소
        intent.setType("image/*") // 이미지만 보여주게
        startActivityForResult(intent, 1000)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1000) {
            val uri: Uri = data!!.data!!
            filePath = getImageFilePath(uri)
        }
    }

    // 경로 찾아주는 함수
    fun getImageFilePath(contentUri: Uri): String {
        var columnIndex = 0
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = contentResolver.query(
            contentUri, projection,
            null, null, null
        )
        if (cursor!!.moveToFirst()) {
            columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        }
        return cursor.getString(columnIndex)
    }

    fun uploadPost() {


        val file = File(filePath)
        val fileRequestBody = RequestBody.create(MediaType.parse("image/*"), file)
        val part = MultipartBody.Part.createFormData("image", file.name, fileRequestBody)
        val content = RequestBody.create(MediaType.parse("text/plain"), getContent())

        (application as MasterApplication).service.uploadPost(
            part, content
        ).enqueue((object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                Log.d("upload", "성공")
                if (response.isSuccessful) {
                    finish()
                    startActivity(
                        Intent(
                            this@HenrystagramUploadActivity,
                            HenrystagramMyPostListActivity::class.java
                        )
                    )
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.d("upload", "실패")
            }
        }))
    }

    fun getContent(): String {
        return content_input.text.toString()
    }

}