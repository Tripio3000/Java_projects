import java.io.File;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //ДОСТУПНЫЕ КЛАССЫ
        System.out.println("Classes:");
        File folder = new File("target/classes/classes");
        List<Object> lst = new ArrayList<>();
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            String name = file.getName();
            for (String retval : name.split("\\.")) {
                lst.add(retval);
                break ;
            }
        }
        for (Object s : lst) {
            System.out.println("-  " + s);
        }
        System.out.println("---------------------");
        //СКАНИРОВАНИЕ КЛАССА
        System.out.println("Enter class name:");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        if (!lst.contains(str)) {
            System.out.println("Error!");
        }
        Class cl = Class.forName("classes." + str);
        System.out.println("---------------------");
        System.out.println("ClassName: " + cl.getSimpleName());

        //ВЫВОД ПОЛЕЙ
        System.out.println("fields:");
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            System.out.print("      " + field.getType().getSimpleName() + " ");
            System.out.println(field.getName());
        }

        //ВЫВОД МЕТОДОВ
        System.out.println("method:");
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals("toString")) {
                continue ;
            }
            System.out.print("      " + method.getReturnType().getSimpleName() + " ");
            System.out.print(method.getName() + "(");
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.print(parameter.getType().getName());
            }
            System.out.println(")");
        }
        System.out.println("Let’s create an object.");
        Object obj = cl.newInstance();
        for (Field field : cl.getDeclaredFields()) {
            System.out.println(field.getName());
            str = scan.nextLine();
            field.setAccessible(true);
            Constructor constructor = field.getType().getConstructor(String.class);
            field.set(obj, constructor.newInstance(str));
        }
        System.out.println("Object created: " + obj);
        System.out.println("---------------------");
        System.out.println("Enter name of the field for changing:");
        str = scan.nextLine();
        for (Field field : cl.getDeclaredFields()) {
            if (str.equals(field.getName())) {
                System.out.println("Enter " + field.getType().getSimpleName() + " value");
                str = scan.nextLine();
                field.setAccessible(true);
                Constructor constructor = field.getType().getDeclaredConstructor(String.class);
                field.set(obj,constructor.newInstance(str));
                break ;
            }
        }
        System.out.println("Object updated: " + obj);
        System.out.println("---------------------");
        System.out.println("Enter name of the method for call:");

        str = scan.nextLine();
        for (Method method : cl.getDeclaredMethods()) {
            if (str.equals(method.getName())) {
                Class<?>[] params = method.getParameterTypes();
                List<Object> list = new ArrayList<Object>();
                for (int i = 0; i < params.length; i++) {
                    System.out.println("Enter " + params[i].getSimpleName() + " value");
                    str = scan.nextLine();
                    Constructor constructor = params[i].getConstructor(String.class);
                    boolean add = list.add(constructor.newInstance(str));
                }

                Object result = method.invoke(obj, list.toArray(new Object[list.size()]));
                if (!method.getReturnType().getSimpleName().equals("void")) {
                    System.out.println("Method returned:" + result);
                }
                break ;
            }
        }
    }
}
