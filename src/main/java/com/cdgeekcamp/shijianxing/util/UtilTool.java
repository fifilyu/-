package com.cdgeekcamp.shijianxing.util;

import com.talanlabs.avatargenerator.*;
import com.talanlabs.avatargenerator.cat.CatAvatar;
import com.talanlabs.avatargenerator.eightbit.EightBitAvatar;
import com.talanlabs.avatargenerator.layers.backgrounds.ColorPaintBackgroundLayer;
import com.talanlabs.avatargenerator.layers.backgrounds.RandomColorPaintBackgroundLayer;
import com.talanlabs.avatargenerator.layers.masks.RoundRectMaskLayer;
import com.talanlabs.avatargenerator.layers.others.ShadowLayer;
import com.talanlabs.avatargenerator.smiley.SmileyAvatar;

import java.awt.*;
import java.io.File;
import java.util.Random;

public class UtilTool {
    public static String createUserPhotoImage(String userPhotoSaveDir, String imageFilenamePrefix) {
        Random random = new Random();
        int avatar_type = random.nextInt(14);

        Avatar avatar;

        switch (avatar_type) {
            case 1:
                avatar = TriangleAvatar.newAvatarBuilder().build();
                break;
            case 2:
                avatar = SquareAvatar.newAvatarBuilder().build();
                break;
            case 3:
                avatar = IdenticonAvatar.newAvatarBuilder().build();
                break;
            case 4:
                avatar = GitHubAvatar.newAvatarBuilder().layers(new ColorPaintBackgroundLayer(Color.WHITE)).build();
                break;
            case 5:
                avatar = GitHubAvatar.newAvatarBuilder().build();
                break;
            case 6:
                avatar = CatAvatar.newAvatarBuilder().build();
                break;
            case 7:
                avatar = CatAvatar.newAvatarBuilder().layers(new ShadowLayer(), new RandomColorPaintBackgroundLayer(), new RoundRectMaskLayer()).padding(8).margin(8).build();
                break;
            case 8:
                avatar = SmileyAvatar.newAccessoriesAvatarBuilder().build();
                break;
            case 9:
                avatar = SmileyAvatar.newEyeMouthAvatarBuilder().build();
                break;
            case 10:
                avatar = SmileyAvatar.newGhostAvatarBuilder().build();
                break;
            case 11:
                avatar = SmileyAvatar.newDefaultAvatarBuilder().build();
                break;
            case 12:
                avatar = EightBitAvatar.newMaleAvatarBuilder().build();
                break;
            case 13:
            default:
                avatar = EightBitAvatar.newFemaleAvatarBuilder().build();
        }

        final String imageFilename = imageFilenamePrefix + ".png";

        File f = new File(userPhotoSaveDir, imageFilename);
        avatar.createAsPngToFile(123456L, f);

        return imageFilename;
    }
}
