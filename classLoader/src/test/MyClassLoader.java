package test;

import java.io.*;

public class MyClassLoader extends ClassLoader{

    private String path;//加载类的路径
    private String name;//类加载器名称

    public MyClassLoader(ClassLoader parent, String path, String name) {
        super(parent);
        this.path = path;
        this.name = name;
    }

    public MyClassLoader(String path, String name) {
        super();//让系统类加载器成为该类的父加载器
        this.path = path;
        this.name = name;
    }

    /**
     * 记载我们自定义的类，通过我们自定义的这个ClassLoader
     * @param name com.tulingedu.classloader.test.Demo
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?>findClass(String name) throws ClassNotFoundException{
        byte[] data = readClassFileToByteArray(name);
        return this.defineClass(name, data, 0, data.length);
    }

    /**
     * 读取.class文件的字节数组
     * com.tulingedu.classloader.test.Demo ->
     * F:/temp/com/tulingedu/classloader/test.Demo.class
     * @param name
     * @return
     */
    private byte[] readClassFileToByteArray(String name) {
        InputStream is = null;
        byte[] returnData = null;
        name = name.replaceAll("\\.", "/");

        String filePath = this.path + name + ".class";
        File file = new File(filePath);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try{
            int tmp = 0;
            is = new FileInputStream(file);
            while((tmp = is.read()) != -1){
                os.write(tmp);
            }
            returnData = os.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return returnData;
    }
}
