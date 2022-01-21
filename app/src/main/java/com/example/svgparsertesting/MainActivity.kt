package com.example.svgparsertesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.util.Log
import java.io.InputStream


class MainActivity : AppCompatActivity() {

    lateinit var svg: SVG
    private lateinit var imageView: ImageView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        button = findViewById(R.id.button)

        val assetInStream: InputStream?
        assetInStream = assets.open("ab.svg")

        Log.d("myInputString", "$assetInStream")

        svg = SVGParser.getSVGFromInputStream(assetInStream)

        button.setOnClickListener {
            imageView.setImageDrawable(svg.createPictureDrawable())
        }
    }
}