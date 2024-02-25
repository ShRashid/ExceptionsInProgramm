import java.io.FileWriter;

import java.io.IOException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите данные в следующем формате латиницей: Фамилия Имя Отчество дата_рождения номер_телефона пол");
            String input = scanner.nextLine();
            String[] data = input.split(" ");

            if (data.length != 6) {
                throw new IllegalArgumentException("Неверное количество данных!");
            }

            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDate = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            if (!birthDate.matches("\\d{2}.\\d{2}.\\d{4}")) {
                throw new IllegalArgumentException("Неверный формат даты рождения!");
            }

            if (gender != 'f' && gender != 'm') {
                throw new IllegalArgumentException("Неверно указан пол!");
            }

            String fileName = lastName + ".txt";
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(lastName + " " + firstName + " " + middleName + " " + birthDate + " "
                    + phoneNumber + " " + gender + "\n");
            fileWriter.close();

            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: ");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}
