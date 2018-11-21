package com.example.uzair.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static android.app.Activity.RESULT_OK;

public class ButtonsManager extends Fragment {
        public Button camera;
        public Button gallery;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.buttons, container, false);
        }


        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            camera= getView().findViewById(R.id.camerabtn);
            gallery=getView().findViewById(R.id.gallerybtn);
            camera.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                            startActivityForResult(intent,0);
                            //Intent takePicture = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                            //startActivityForResult(takePicture, 0);
                        }
                    });
            gallery.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            startActivityForResult(pickPhoto , 1);//one can be replaced with any action code

                        }
                    });

//        kbvExample.setImageURI(uri);
//        RandomTransitionGenerator generator = new RandomTransitionGenerator(duration, interpolator);
//        kbv.setTransitionGenerator(generator);

         //   Picasso.get().load(uri).into(this.kbvExample);
        }
    }


