/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagementapp;

/**
 *
 * @author Sciro
 */
public class Guest {
    private int guestId;
    private String name;
    private String email;

    public Guest(int guestId, String name, String email) {
        this.guestId = guestId;
        this.name = name;
        this.email = email;
    }

    public int getGuestId() {
        return guestId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
