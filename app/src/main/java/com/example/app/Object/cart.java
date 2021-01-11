package com.example.app.Object;

public class cart {
    int id;
    int idPro;
    int quanlity;


    public cart(int id, int idPro, int quanlity) {
        this.id = id;
        this.idPro = idPro;
        this.quanlity = quanlity;
    }

    public cart(int idPro, int quanlity) {

        this.idPro = idPro;
        this.quanlity = quanlity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public int getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }
}
