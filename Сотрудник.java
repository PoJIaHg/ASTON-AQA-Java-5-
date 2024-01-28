    public class Сотрудник {
        private String Name;
        private String position;
        private String email;
        private String phone;
        private int salary;
        private int age;

        // Конструктор класса
        public Сотрудник(String fullName, String position, String email, String phone, int salary, int age) {
            this.Name = fullName;
            this.position = position;
            this.email = email;
            this.phone = phone;
            this.salary = salary;
            this.age = age;
        }

        // Метод для вывода информации о сотруднике
        public void printInfo() {
            System.out.println("ФИО: " + Name);
            System.out.println("Должность: " + position);
            System.out.println("Email: " + email);
            System.out.println("Телефон: " + phone);
            System.out.println("Зарплата: " + salary);
            System.out.println("Возраст: " + age);
            System.out.println();
        }

        public static void main(String[] args) {
            // Создание массива из 5 сотрудников
            Сотрудник[] employees = new Сотрудник[5];

            // Заполнение массива объектами
            employees[0] = new Сотрудник("Pivnov Pivas", "Engineer", "ivivan@mailbox.com", "892312312", 55000, 30);
            employees[1] = new Сотрудник("Petrov Petr", "Developer", "petrov@mailbox.com", "892345678", 88000, 35);
            employees[2] = new Сотрудник("Sidorov Sidr", "Manager", "sidorov@mailbox.com", "892332211", 44000, 28);
            employees[3] = new Сотрудник("Kozlov Kozel", "Designer", "kozlov@mailbox.com", "892367890", 77000, 32);
            employees[4] = new Сотрудник("Korablev Anton", "AQA junior", "pojiahg@yandex.ru", "89031656493", 66666, 34);

            // Вывод информации о сотрудниках
            for (Сотрудник employee : employees) {
                employee.printInfo();
            }
        }
    }
