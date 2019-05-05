/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 19759309-1
 */
public class credito {
    
    
    private String nombre;
    private double monto;
    private int cuotas;
    private boolean segDesgravamen;
    private boolean segIncendio;

    public credito() {
    }

    public credito(String nombre, double monto, int cuotas, boolean segDesgravamen, boolean segIncendio) {
        this.nombre = nombre;
        this.monto = monto;
        this.cuotas = cuotas;
        this.segDesgravamen = segDesgravamen;
        this.segIncendio = segIncendio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public boolean isSegDesgravamen() {
        return segDesgravamen;
    }

    public void setSegDesgravamen(boolean segDesgravamen) {
        this.segDesgravamen = segDesgravamen;
    }

    public boolean isSegIncendio() {
        return segIncendio;
    }

    public void setSegIncendio(boolean segIncendio) {
        this.segIncendio = segIncendio;
    }
    
    

    
}
