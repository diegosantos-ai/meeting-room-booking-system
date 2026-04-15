package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Booking;
import entities.Room;

public class Program {
    public static void main(String[] args) {
        // Try-with-resources para fechamento automático do Scanner
        try (Scanner sc = new Scanner(System.in)) {
            List<Room> rooms = initRooms();
            List<Booking> bookings = new ArrayList<>();
            int option;

            do {
                printMenu();
                option = readInteger(sc);

                switch (option) {
                    case 1:
                        showRoomStatus(rooms, bookings);
                        break;
                    case 2:
                        executeBookingFlow(sc, rooms, bookings);
                        break;
                    case 3:
                        showAllBookings(bookings);
                        break;
                    case 0:
                        System.out.println("Encerrando o sistema... Até logo!");
                        break;
                    default:
                        System.out.println("⚠️ Opção inválida! Tente novamente.");
                }
            } while (option != 0);
        }
    }

    private static void printMenu() {
        System.out.println("\n==============================");
        System.out.println("      SISTEMA DE RESERVAS     ");
        System.out.println("==============================");
        System.out.println("1. Listar Status das Salas");
        System.out.println("2. Reservar uma Sala");
        System.out.println("3. Ver Relatório de Reservas");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static List<Room> initRooms() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room("Sala A", 15, false));
        rooms.add(new Room("Sala B", 35, true));
        rooms.add(new Room("Sala C", 50, true));
        return rooms;
    }

    private static void showRoomStatus(List<Room> rooms, List<Booking> bookings) {
        System.out.println("\n--- STATUS ATUAL DAS SALAS ---");
        for (int i = 0; i < rooms.size(); i++) {
            Room r = rooms.get(i);
            // Conta quantas reservas existem para esta sala específica
            long count = bookings.stream()
                    .filter(b -> b.getRoom().getName().equals(r.getName()))
                    .count();
            
            String status = (count > 0) ? "Reservada (" + count + " turno(s))" : "Disponível";
            System.out.printf("[%d] %s | Capacidade: %d | Status: %s%n", 
                                i, r.getName(), r.getCapacity(), status);
        }
    }

    private static void executeBookingFlow(Scanner sc, List<Room> rooms, List<Booking> bookings) {
        showRoomStatus(rooms, bookings);
        System.out.print("\nDigite o índice da sala desejada: ");
        int index = readInteger(sc);

        if (index >= 0 && index < rooms.size()) {
            processBooking(sc, rooms.get(index), bookings);
        } else {
            System.out.println("❌ Erro: Índice de sala inválido!");
        }
    }

    private static void processBooking(Scanner sc, Room selectedRoom, List<Booking> bookings) {
        System.out.print("Nome do funcionário: ");
        String employeeName = sc.nextLine();
        
        String shift = "";
        boolean validShift = false;

        while (!validShift) {
            System.out.print("Turno (Manhã/Tarde/Noite): ");
            shift = sc.nextLine().trim();

            if (shift.equalsIgnoreCase("Manhã") || 
                shift.equalsIgnoreCase("Tarde") || 
                shift.equalsIgnoreCase("Noite")) {
                validShift = true;
            } else {
                System.out.println("⚠️ Entrada inválida! Use apenas: Manhã, Tarde ou Noite.");
            }
        }

        final String finalShift = shift; 
        boolean hasConflict = bookings.stream()
                .anyMatch(b -> b.getRoom().getName().equals(selectedRoom.getName()) 
                            && b.getShift().equalsIgnoreCase(finalShift));

        if (hasConflict) {
            System.out.println("❌ Erro: A " + selectedRoom.getName() + " já está ocupada no turno: " + shift);
        } else {
            bookings.add(new Booking(employeeName, selectedRoom, shift));
            System.out.println("✅ Sucesso: Reserva confirmada!");
        }
    }

    private static void showAllBookings(List<Booking> bookings) {
        System.out.println("\n--- RELATÓRIO GERAL DE RESERVAS ---");
        if (bookings.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada no sistema.");
        } else {
            bookings.forEach(System.out::println);
        }
    }

    private static int readInteger(Scanner sc) {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1; 
        }
    }
}
