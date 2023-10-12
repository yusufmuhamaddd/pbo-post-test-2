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



Class Room

    public class Room {
    private int roomNumber;
    private String roomType;
    private double price;

    public Room(int roomNumber, String roomType, double price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }
    }
Room adalah class yang digunakan untuk mengelola informasi tentang kamar hotel.



Class Guest

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
Guest adalah class yang digunakan untuk mengelola informasi tentang tamu hotel.



Class Reservation

    import java.util.Date;

    public class Reservation {
        private int reservationId;
        private Guest guest;
        private Room room;
        private Date checkInDate;
        private Date checkOutDate;
    
    public Reservation(int reservationId, Guest guest, Room room, Date checkInDate, Date checkOutDate) {
        this.reservationId = reservationId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public int getReservationId() {
        return reservationId;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }
    }
Reservation adalah class yang digunakan untuk mengelola informasi tentang reservasi hotel.



Class Hotel

    import java.util.ArrayList;
    import java.util.List;

    public class Hotel {
        private List<Room> rooms = new ArrayList<>();
        private List<Guest> guests = new ArrayList<>();
        private List<Reservation> reservations = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
    }
Hotel adalah class yang digunakan untuk menyimpan dan mengirimkan informasi tentang kamar, tamu, dan reservasi ke main class HotelManagementApp
