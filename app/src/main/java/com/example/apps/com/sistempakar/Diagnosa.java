package com.example.apps.com.sistempakar;

/**
 * Created by RONIJR on 7/31/18.
 */

public class Diagnosa {
    private String id;
    private double mb;
    private double md;
    private String name;
    private String id_penyakit;

    //Empty Constructor
    public Diagnosa() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMb() {
        return mb;
    }

    public void setMb(double mb) {
        this.mb = mb;
    }

    public double getMd() {
        return md;
    }

    public void setMd(double md) {
        this.md = md;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_penyakit() {
        return id_penyakit;
    }

    public void setId_penyakit(String id_penyakit) {
        this.id_penyakit = id_penyakit;
    }

    // Constructor
    public Diagnosa(String id,double mb, double md,String id_penyakit, String name) {
        this.id =id;
        this.name = name;
        this.mb = mb;
        this.md=md;
        this.id_penyakit=id_penyakit;

    }
}
