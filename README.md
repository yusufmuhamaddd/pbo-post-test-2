# pbo-post-test-2


Penjelasan Source Code

Main Class HotelManagementApp

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
Pada case 1, program menerima input pengguna untuk menambahkan informasi kamar. Pengguna melakukan input nomor kamar, tipe kamar, dan harga. Informasi ini digunakan untuk membuat objek Room, yang ditambahkan ke daftar kamar di objek hotel.

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
sama seperti case 1, tapi ini untuk informasi tamu

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
sama seperti case 1 dan 2 tapi ini untuk informasi reservasi dan program mencari objek tamu dan kamar yang sesuai dengan ID yang telah pengguna inputkan

case 4:
    displayData(hotel);
    break;
untuk menampilkan data yang telah diinputkan

case 5:
    System.out.println("Mematikan Sistem");
    System.exit(0);
untuk keluar dari program

private static Guest findGuestById(List<Guest> guests, int guestId) {
    for (Guest guest : guests) {
        if (guest.getGuestId() == guestId) {
            return guest;
        }
    }
    return null;
}
untuk mencari ID tamu

private static Room findRoomByNumber(List<Room> rooms, int roomNumber) {
    for (Room room : rooms) {
        if (room.getRoomNumber() == roomNumber) {
            return room;
        }
    }
    return null;
}
untuk mencari nomor kamar

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
        System.println("Email : " + guest.getEmail());
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
untuk menampilkan seluruh data yang telah pengguna inputkan yang disimpan didalam class Hotel
