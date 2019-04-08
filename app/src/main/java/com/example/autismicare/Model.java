package com.example.autismicare;

public class Model {

    String ref;
    int image;


    public Model( String ref, int image){


        this.ref = ref;
        this.image = image;

    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
