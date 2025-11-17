import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Ref_get {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("请通过命令行参数指定要反射的类名：");
            System.out.println("  • 有包名的类：java ReflectionDemo java.lang.String");
            System.out.println("  • 默认包中的类：java ReflectionDemo MyClass");
            return;
        }

        String className = args[0];
        try {
            Class<?> targetClass = Class.forName(className);
            
            System.out.println("=========================================");
            System.out.println("类名称: " + targetClass.getName());
            System.out.println("所在包: " + 
                (targetClass.getPackage() != null ? targetClass.getPackage().getName() : "默认包"));
            System.out.println("=========================================");

            Method[] methods = targetClass.getDeclaredMethods();
            System.out.println("方法列表 (" + methods.length + " 个):");
            for (int i = 0; i < methods.length; i++) {
                Method method = methods[i];
                System.out.println("  " + (i + 1) + ". " + method.getName());
                System.out.println("     修饰符: " + Modifier.toString(method.getModifiers()));
                System.out.println("     返回类型: " + method.getReturnType().getSimpleName());
                
                Class<?>[] paramTypes = method.getParameterTypes();
                if (paramTypes.length == 0) {
                    System.out.println("     参数: 无");
                } else {
                    System.out.print("     参数类型: ");
                    for (Class<?> paramType : paramTypes) {
                        System.out.print(paramType.getSimpleName() + " ");
                    }
                    System.out.println();
                }
                System.out.println("     ---");
            }

            Field[] fields = targetClass.getDeclaredFields();
            System.out.println("\n字段列表 (" + fields.length + " 个):");
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                System.out.println("  " + (i + 1) + ". " + field.getName());
                System.out.println("     类型: " + field.getType().getSimpleName());
                System.out.println("     修饰符: " + Modifier.toString(field.getModifiers()));
                System.out.println("     ---");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("错误：未找到类 '" + className + "'");
            System.out.println("可能原因：");
            System.out.println("  • 类名拼写错误");
            System.out.println("  • 类不在类路径中");
            System.out.println("  • 默认包中的类需要确保编译后的.class文件在当前目录");
            System.out.println("  • 有包名的类需要使用完整包路径");
        } catch (Exception e) {
            System.out.println("反射操作出现异常: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
