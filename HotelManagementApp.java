/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hotelmanagementapp;

/**
 *
 * @author Sciro
 */
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;


public class HotelManagementApp {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=======================");
            System.out.println("Menu:");
            System.out.println("1. Tambah Kamar");
            System.out.println("2. Tambah Tamu");
            System.out.println("3. Tambah Reservasi");
            System.out.println("4. Tampilkan Data");
            System.out.println("5. Keluar");

            int choice = scanner.nextInt();
            System.out.println("=======================");
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nomor Kamar : ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Tipe Kamar : ");
                    String roomType = scanner.nextLine();
                    System.out.print("Harga : ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    Room room = new Room(roomNumber, roomType, price);
                    hotel.addRoom(room);
                    break;

                case 2:
                    System.out.print("ID Tamu : ");
                    int guestId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nama Tamu : ");
                    String name = scanner.nextLine();
                    System.out.print("Email : ");
                    String email = scanner.nextLine();
                    Guest guest = new Guest(guestId, name, email);
                    hotel.addGuest(guest);
                    break;

                case 3:
                    System.out.print("ID Reservasi : ");
                    int reservationId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("ID Tamu : ");
                    int guestIdForReservation = scanner.nextInt();
                    scanner.nextLine();
                    // mencari ID guest
                    Guest guestForReservation = findGuestById(hotel.getGuests(), guestIdForReservation);
                    if (guestForReservation == null) {
                        System.out.println("ID tamu tidak ada atau salah");
                        break;
                    }
                    System.out.print("ID Kamar : ");
                    int roomNumberForReservation = scanner.nextInt();
                    scanner.nextLine();
                    // Mencari nomor ruangan
                    Room roomForReservation = findRoomByNumber(hotel.getRooms(), roomNumberForReservation);
                    if (roomForReservation == null) {
                        System.out.println("Kamar tidak ada atau salah");
                        break;
                    }
                    System.out.print("Tanggal Check-In (DD-MM-YYYY) : ");
                    String checkInDateStr = scanner.nextLine();
                    System.out.print("Tanggal Check-Out (DD-MM-YYYY) : ");
                    String checkOutDateStr = scanner.nextLine();
                    Date checkInDate = parseDate(checkInDateStr);
                    Date checkOutDate = parseDate(checkOutDateStr);

                    Reservation reservation = new Reservation(reservationId, guestForReservation, roomForReservation, checkInDate, checkOutDate);
                    hotel.addReservation(reservation);
                    break;

                case 4:
                    displayData(hotel);
                    break;

                case 5:
                    System.out.println("Mematikan Sistem");
                    System.exit(0);

                default:
                    System.out.println("Salah Input");
                    break;
            }
        }
    }

    private static Guest findGuestById(List<Guest> guests, int guestId) {
        for (Guest guest : guests) {
            if (guest.getGuestId() == guestId) {
                return guest;
            }
        }
        return null;
    }

    private static Room findRoomByNumber(List<Room> rooms, int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    private static Date parseDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return dateFormat.parse(dateStr);
        } catch (java.text.ParseException e){
            System.out.println("Format tanggal salah");
        }
        return new Date();
    }

    private static void displayData(Hotel hotel) {
        System.out.println("Data Kamar :");
        for (Room room : hotel.getRooms()) {
            System.out.println("Nomor Kamar : " + room.getRoomNumber());
            System.out.println("Tipe Kamar : " + room.getRoomType());
            System.out.println("Harga : " + room.getPrice());
        }

        System.out.println("Data Tamu :");
        for (Guest guest : hotel.getGuests()) {
            System.out.println("ID Tamu : " + guest.getGuestId());
            System.out.println("Nama Tamu : " + guest.getName());
            System.out.println("Email : " + guest.getEmail());
        }

        System.out.println("Data Reservasi :");
        for (Reservation reservation : hotel.getReservations()) {
            System.out.println("ID Reservasi : " + reservation.getReservationId());
            System.out.println("ID Tamu : " + reservation.getGuest().getGuestId());
            System.out.println("ID Kamar : " + reservation.getRoom().getRoomNumber());
            System.out.println("Check-In : " + reservation.getCheckInDate());
            System.out.println("Check-Out : " + reservation.getCheckOutDate());
        }
    }
}