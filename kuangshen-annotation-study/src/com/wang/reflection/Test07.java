package com.wang.reflection;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-21 14:53
 **/
public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader); //sun.misc.Launcher$AppClassLoader

        //获取系统类加载器的父类加载器->扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent); //sun.misc.Launcher$ExtClassLoader

        //获取扩展类加载器的父类加载器-->根加载器（C/C++）
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1); //null

        ClassLoader classLoader = Class.forName("com.wang.reflection.Student").getClassLoader();
        System.out.println(classLoader); //sun.misc.Launcher$AppClassLoader

        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader); //jdk内部类是根加载器加载 null

        //如何获得系统类加载器可以加载的路径
        String property = System.getProperty("java.class.path");
        System.out.println(property);
        /*
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/charsets.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/deploy.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/ext/dnsns.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/ext/jaccess.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/ext/localedata.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/ext/nashorn.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/ext/sunec.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/ext/zipfs.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/javaws.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/jce.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/jfr.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/jfxswt.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/jsse.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/management-agent.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/plugin.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/resources.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/rt.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/lib/ant-javafx.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/lib/dt.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/lib/javafx-mx.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/lib/jconsole.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/lib/packager.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/lib/sa-jdi.jar:
        /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/lib/tools.jar:
        /Users/wangyinghao/Projects/IdeaProjects/coding-practise/out/production/kuangshen-annotation-study:
        /Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar
         */

        //双亲委派机制
    }
}
