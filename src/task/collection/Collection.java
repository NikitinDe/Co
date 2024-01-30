package task.collection;
import task.models.BigBox;
import org.w3c.dom.ls.LSOutput;
import task.models.BigBox;
import task.models.MediumBox;
import javax.swing.*;
import java.util.*;
import static java.lang.reflect.Array.set;
import static java.util.Collections.reverseOrder;
import static task.generics.Generics.*;
public class Collection {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 5, 2, 9, 9, 9);
        List<Integer> integerList2 = new ArrayList<>(List.of(2, 5, 6, 4));
        List<String> stringList = List.of("Привет", "Пока", "hello", "Bay-bay", "2");//set содержит уникальные значения
        Set<Integer> integerSet2 = Set.of(2, 4, 5);

        Map<Integer, String> mapa = new HashMap<>();//ключ/значение внутри лежит массив LinkedList
        Queue<Integer> queue = new LinkedList<>(); //Очередь первый зашел - вышел первый.
        Deque<Integer> stack = new LinkedList<>(); // stack первый зашел - вышел последний.

        String keyValue = mapa.put(4, "Коса");
        Integer key = 4;//ключ/значение внутри лежит массив LinkedList

        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "Лояльный", 500));
        orders.add(new Order(2, "Мега-Лояльный", 1000));
        orders.add(new Order(3, "Негативный", 250));

        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, "Сложение", "Выполнена"));
        tasks.add(new Task(2, "Умножение", "Невыполена"));
        tasks.add(new Task(3, "Деление", "Выполнена"));

        Map<Student, Integer> student = new HashMap<>();
        Student st1 = new Student("Денис", 27);
        Student st2 = new Student("Павел", 35);
        Student st3 = new Student("Николай", 18);
        student.put(st1, 27);
        student.put(st2, 35);
        student.put(st3, 18);

        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "Яйцо", 60));
        list.add(new Product(2, "Хлеб", 0));
        list.add(new Product(3, "Кортошка", 50));

        List<Student1> list1 = new ArrayList<>();
        list1.add(new Student1("Максим", 25));
        list1.add(new Student1("Павел", 100));
        list1.add(new Student1("Николай", 53));
        list1.add(new Student1("Александр", 47));

        Set<String> stringSet2 = new HashSet<>();
        stringSet2.add("Hello");
        stringSet2.add("2");
        stringSet2.add("Hello");

        List<BigBox> list2 = new ArrayList<>();
        list2.add(new BigBox());

        List<MediumBox> list3 = new ArrayList<>();
        list3.add(new MediumBox());

        String str = "Дом";

        System.out.println(maxElement(integerList));
        removeDuplicates(stringList);
        sortList(integerList2);
        set(stringSet2, str);
        intersectionSets(stringSet2, integerSet2);
        removingFromSet(stringSet2, integerSet2);
        keyMap(mapa, keyValue);
        valuesKey(mapa, key);
        removeMap(mapa, keyValue);
        addQueue(queue, key);
        removeQueue(queue, key);

        emptyQueue(queue);
        largestAmount(orders);
        getTotalAmount(orders);
        unfinishedTasks(tasks);
        taskTitle(tasks);
        listStudent(student);
        studentAge(student);
        product(list);
        productStock(list);
        attendanceStudent(list1);
        averageAttendance(list1);


        BigBox box = new BigBox();
        System.out.println(box(list2, box));

        MediumBox boxes = new MediumBox();
        System.out.println(addBoxToList(list3, boxes));
        printBoxList(list2);
        copyBoxes(list3, list3);


    }
    // TODO: Для каждой задачи сгенерируйте самостоятельно коллекции и карты для тестирования своих методов
    // TODO: Найти наибольший элемент в списке.


    private static int maxElement(List<Integer> integerList) {

        int max = integerList.get(0);
        for (int i = 0; i < integerList.size(); i++) {
            int a = integerList.get(i);
            if (a > max) {
                max = a;
            }
        }
        return max;
    }

    // TODO: Удалить все дубликаты из списка.
    private static void removeDuplicates(List<String> stringList) {
        Set<String> set = new HashSet<>(stringList);
        System.out.println(set);
    }

    // TODO: Отсортировать список в порядке убывания.
    private static void sortList(List<Integer> integerList2) {
        integerList2.sort(Comparator.reverseOrder());
        System.out.println(integerList2);
    }

    // TODO: Проверить, содержит ли множество определенный элемент.


    private static void set(Set<String> stringSet, String str) {
        if (stringSet.contains(str)) {
            System.out.println("В данном множестве есть заданная  строка: " + stringSet);
        } else {
            System.out.println("В данном множестве нет заданной строки!");
        }
    }

    // TODO: Найти пересечение двух множеств.
    private static void intersectionSets(Set<String> stringSet, Set<Integer> integerSet2) {
        Set<String> sett = new HashSet<>(stringSet);
        sett.retainAll(integerSet2);
        System.out.println("Пересечение двух множеств:" + sett);

    }

    // TODO: Удалить все элементы из множества, которые также содержатся в другом множестве.
    private static void removingFromSet(Set<String> stringSet, Set<Integer> integerSet) {
        stringSet.removeAll(integerSet);
        System.out.println(stringSet);
    }


    // TODO: Проверить, содержит ли карта определенный ключ.


    private static void keyMap(Map<Integer, String> mapa, String keyValue) {
        if (mapa.containsKey(keyValue)) {
            System.out.println("карта содержит ключ");
        } else {
            System.out.println("карта не содержит данный ключ");
        }

    }

    // TODO: Получить все значения, связанные с определенным ключом.


    private static void valuesKey(Map<Integer, String> mapa, Integer key) {
        List<String> values = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : mapa.entrySet()) {
            if (entry.getKey().equals(key)) {
                values.add(entry.getValue());
            }
        }
        if (mapa.containsKey(key)) {
            System.out.println("Значения определнного ключа " + key + values);
        } else {
            System.out.println("Ключ не найден!");
        }
    }

    // TODO: Удалить все записи из карты, у которых значение равно определенному значению.


    private static void removeMap(Map<Integer, String> mapa, String keyValue) {
        Iterator<Map.Entry<Integer, String>> mapIterator = mapa.entrySet().iterator();
        while (mapIterator.hasNext()) {
            Map.Entry<Integer, String> iterator = mapIterator.next();
            if (iterator.getValue().equals(keyValue)) {
                mapIterator.remove();
            }
        }
    }

    // TODO: Добавить элемент в очередь.
    private static void addQueue(Queue<Integer> queue, Integer key) {
        queue.add(key);
    }

    // TODO: Получить и удалить первый элемент из очереди.
    private static void removeQueue(Queue<Integer> queue, Integer key) {
        queue.remove(key); // удаляет  элемнет из очереди если нужно с конца то это steck!

    }

    // TODO: Проверить, пуста ли очередь.
    private static void emptyQueue(Queue<Integer> queue) {
        if (!queue.isEmpty()) {
            System.out.println("Очередь не пуста" + queue.poll());
        } else {
            System.out.println("Очередь пуста!");
        }
    }


    // TODO: Учет заказов:
    //  Создайте класс Order с полями id, customer и totalAmount.
    //  Создайте метод, который будет принимать список заказов и выводить заказы с наибольшей суммой.
    //  Создайте метод, который будет принимать список заказов и возвращать общую сумму всех заказов.
    public static class Order {
        private int id;
        private String customer;
        private int totalAmount;

        public Order(int id, String customer, int totalAmount) {
            this.id = id;
            this.customer = customer;
            this.totalAmount = totalAmount;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCustomer() {
            return customer;
        }

        public void setCustomer(String customer) {
            this.customer = customer;
        }

        public int getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(int totalAmount) {
            this.totalAmount = totalAmount;
        }
    }

    public static void largestAmount(List<Order> orders) {
        int max = 0;
        List<Order> ord = new ArrayList<>();

        for (Order order : orders) {
            if (order.getTotalAmount() > max) {
                max = order.getTotalAmount();
                ord.clear();
                ord.add(order);
            } else if (order.getTotalAmount() == max) {
                ord.add(order);
            }
        }

        for (Order order : ord) {
            System.out.println(" ");
            System.out.println("Номер: " + order.getId());
            System.out.println("Клиент: " + order.getCustomer());
            System.out.println("Сумма заказа: " + order.getTotalAmount());
            System.out.println();
        }
    }

    public static void getTotalAmount(List<Order> orders) {
        int totalAmount = 0;
        for (Order order : orders) {
            totalAmount += order.getTotalAmount();
        }
        System.out.println(totalAmount);
    }

    // TODO: Управление задачами:
    //  Создайте класс Task с полями id, title и completed.
    //  Создайте метод, который будет принимать список задач и выводить только незавершенные задачи на экран.
    //  Создайте метод, который будет принимать список задач и возвращать список задач с определенным заголовком.

    public static class Task {
        private int id;
        private String title;
        private String completed;

        public Task(int id, String title, String completed) {
            this.id = id;
            this.title = title;
            this.completed = completed;

        }

        public void setId(int id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setCompleted(String completed) {
            this.completed = completed;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getCompleted() {
            return completed;
        }

        @Override
        public String toString() {
            return id + "," + title + "," + completed;

        }

    }

    public static void unfinishedTasks(List<Task> tasks) {

        for (Task god : tasks) {
            if (!god.getCompleted().equals("Выполнена")) {
                System.out.println(god);
            }

        }

    }

    public static void taskTitle(List<Task> tasks) {
        for (Task list : tasks) {
            if (list.getTitle().equals("Сложение")) {
                System.out.println(list);
            }
        }
    }


    // TODO: Создание списка студентов:
    //  Создайте класс Student с полями name и age.
    //  Создайте метод, который будет принимать список студентов и выводить их на экран.
    //  Создайте метод, который будет принимать список студентов и возвращать список студентов, у которых возраст больше определенного значения.

    public static class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }

    }

    public static void listStudent(Map<Student, Integer> student) {
        System.out.println(student);
    }

    public static void studentAge(Map<Student, Integer> student) {
        for (Integer value : student.values()) {
            if (value > 20) {
                int age = value;
                for (Student key : student.keySet()) {
                    if (key.getAge() == value) {
                        System.out.println(key.getName() + " = " + age);
                    }
                }
            }
        }
    }


    // TODO: Учет товаров на складе:
    //  Создайте класс Product с полями id, name и quantity.
    //  Создайте метод, который будет принимать список товаров и выводить только товары с нулевым количеством на складе.
    //  Создайте метод, который будет принимать список товаров и возвращать общее количество товаров на складе.

    public static class Product {
        private int id;
        private String name;
        private int quantity;

        public Product(int id, String name, int quantity) {
            this.id = id;
            this.name = name;
            this.quantity = quantity;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }


        @Override
        public String toString() {

            return "{id " + id + ", " + "name " + name + ", " + "quantity " + quantity + "}";
        }

    }


    public static void product(List<Product> list) {
        for (Product kol : list) {
            if (kol.getQuantity() == 0) {
                System.out.println(kol);
            }
        }
    }

    public static int productStock(List<Product> list) {
        int sum = 0;
        for (Product gen : list) {
            sum += gen.getQuantity();
        }
        return sum;
    }


    // TODO: Учет посещаемости:
    //  Создайте класс Student с полями name и attendance.
    //  Создайте метод, который будет принимать список студентов и выводить студентов с наихудшей посещаемостью.
    //  Создайте метод, который будет принимать список студентов и возвращать среднюю посещаемость.
    public static class Student1 {
        private String name;
        private Integer attendance;

        public Student1(String name, Integer attendance) {
            this.name = name;
            this.attendance = attendance;
        }

        public String getName() {
            return name;
        }

        public Integer getAttendance() {
            return attendance;
        }

        @Override
        public String toString() {
            return "{Student- " + name + ", " + " Attendace: " + attendance + "%}";
        }
    }

    public static void attendanceStudent(List<Student1> list1) {
        int min = 50;// минимальная посещаемость 50%
        for (Student1 attend : list1) {
            if (attend.getAttendance() < min) {
                System.out.println(attend);
            }
        }
    }

    public static int averageAttendance(List<Student1> list1) {
        int sum = 0;
        int s = list1.size();
        for (Student1 sr : list1) {
            sum += sr.getAttendance();
        }
        return sum / s;//среднея посещаемость.
    }
}