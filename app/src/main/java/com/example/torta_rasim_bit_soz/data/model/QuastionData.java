package com.example.torta_rasim_bit_soz.data.model;

public class QuastionData {
    String variant;
    String answer;
    int image;
    int image1, image2, imag3;

    public QuastionData(String variant, String answer, int image, int image1, int image2, int imag3) {
        this.variant = variant;
        this.answer = answer;
        this.image = image;
        this.image1 = image1;
        this.image2 = image2;
        this.imag3 = imag3;
    }
    public String getVariant() {
        return variant;
    }

    public String getAnswer() {
        return answer;
    }

    public int getImage() {
        return image;
    }

    public int getImage1() {
        return image1;
    }

    public int getImage2() {
        return image2;
    }

    public int getImage3() {
        return imag3;
    }
}
