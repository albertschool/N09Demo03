package com.example.n09demo03;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import java.util.Locale;

/**
 * The TextToSpeechHelper class
 * <p>
 * This class concentrates all methods to fire TextToSpeech messages
 * </p>
 *
 * @author Levy Albert albert.school2015@gmail.com
 * @version 2.0
 * @since 21 /7/2023
 */
public class TextToSpeechHelper {
    private TextToSpeech textToSpeech;

    /**
     * TextToSpeechHelper method
     * <p> TextToSpeechHelper constructor
     * set all the parameters to init the TTS operation
     * </p>
     *
     * @param context the context object that triggered the method
     */
    public TextToSpeechHelper(Context context) {
        textToSpeech = new TextToSpeech(context,
                new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = textToSpeech.setLanguage(Locale.US);
                    if (result == TextToSpeech.LANG_MISSING_DATA ||
                            result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(context, "Language not supported",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        float sR = 0.8f;
                        textToSpeech.setSpeechRate(sR);
                    }
                } else {
                    Toast.makeText(context, "Couldn't initialize TTS ",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * onCreateContextMenu method
     * <p> Creating the context menu
     * </p>
     *
     * @param text the string to speech
     */
    public void speak(String text) {
        textToSpeech.speak(text,
                TextToSpeech.QUEUE_FLUSH, null, null);
    }

    /**
     * destroy method
     * <p> Destroying all TTS operations
     * </p>
     */
    public void destroy() {
        if (textToSpeech != null) {
            if (textToSpeech.isSpeaking()) {
                textToSpeech.stop();
            }
            textToSpeech.shutdown();
        }
    }
}
