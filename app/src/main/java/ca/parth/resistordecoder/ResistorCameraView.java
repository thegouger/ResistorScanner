package ca.parth.resistordecoder;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;

import org.opencv.android.JavaCameraView;

import java.util.List;

/**
 * Created by parth on 05/05/15.
 */
public class ResistorCameraView extends JavaCameraView {

    public ResistorCameraView(Context context, int cameraId) {
        super(context, cameraId);
    }

    public ResistorCameraView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    // zoom in and enable flash
    protected boolean initializeCamera(int width, int height)
    {
        boolean ret = super.initializeCamera(width, height);

        Camera.Parameters params = mCamera.getParameters();

        List<String> FocusModes = params.getSupportedFocusModes();
        if (FocusModes != null && FocusModes.contains(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO))
        {
            params.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO);
        }
        else if(FocusModes != null && FocusModes.contains(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE))
        {
            params.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
        }

        List<String> FlashModes = params.getSupportedFlashModes();
        if(FlashModes != null && FlashModes.contains(Camera.Parameters.FLASH_MODE_TORCH))
        {
            params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        }

        params.setZoom(params.getMaxZoom());
        mCamera.setParameters(params);

        return ret;
    }
}
